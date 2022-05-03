package com.naveen.canteenapp.order.services;

import com.naveen.canteenapp.menu.dao.MenuRepository;
import com.naveen.canteenapp.menu.models.Menu;
import com.naveen.canteenapp.order.dao.OrderMenuRepository;
import com.naveen.canteenapp.order.dao.OrderRepository;
import com.naveen.canteenapp.order.dto.MenuQty;
import com.naveen.canteenapp.order.dto.OrderAcknowledgement;
import com.naveen.canteenapp.order.dto.OrderRequest;
import com.naveen.canteenapp.order.exceptions.InsufficientBalanceException;
import com.naveen.canteenapp.order.exceptions.ItemEmptyException;
import com.naveen.canteenapp.order.models.Order;
import com.naveen.canteenapp.order.models.OrderMenu;
import com.naveen.canteenapp.service.dao.ServiceRepository;
import com.naveen.canteenapp.user.dao.UserRepository;
import com.naveen.canteenapp.user.models.User;
import com.naveen.canteenapp.wallet.dao.WalletRepository;
import com.naveen.canteenapp.wallet.models.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderMenuRepository orderMenuRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    @Transactional
    public OrderAcknowledgement orderFood(OrderRequest request) throws Exception {
        String username = request.getUserid();
        List<MenuQty> menuQtys = request.getMenuQty();

        Order order = new Order();
        order.setUser(userRepository.findById(username).get());
        order.setTime(LocalDateTime.now());

        double total = getTotal(menuQtys);
        order.setTotal(total);

        if (!debitAmount(username, total)) {
            throw new InsufficientBalanceException("You don't have enough balance in your wallet");
        }

        List<OrderMenu> orderMenuList = getOrderMenuList(menuQtys);
        if (orderMenuList.size() <= 0) {
            // nothing in cart
            throw new Exception("Null cart list");
        }
        order.setMenuList(orderMenuList);

        // reduce qty in menu
        boolean reduceQty = reduceQty(menuQtys);

        if (!reduceQty) {
            throw new ItemEmptyException("Item is sold or empty");
        }
        orderRepository.save(order);

        return new OrderAcknowledgement("PAID", order);
    }

    private List<OrderMenu> getOrderMenuList(List<MenuQty> menuQtys) {
        List<OrderMenu> orderMenuList = new ArrayList<>();

        menuQtys.forEach(e -> {
            OrderMenu om = new OrderMenu(e.getQty(), e.getMenuId());
            Menu menu = menuRepository.findById(e.getMenuId()).get();
            om.setMenu(menu);
            orderMenuList.add(om);
        });

        return orderMenuList;
    }

    private boolean debitAmount(String username, double total) {
        Wallet wallet = walletRepository.findByUserId(username);
        if (wallet.getBalance() >= total) {
            wallet.setBalance(wallet.getBalance() - (int) total);
            walletRepository.save(wallet);
            return true;
        } else {
            // insufficient balance
            return false;
        }
    }

    private boolean reduceQty(List<MenuQty> menuQtys) {
        AtomicBoolean result = new AtomicBoolean(true);
        menuQtys.forEach(menuQty -> {
            Long id = menuQty.getMenuId();
            int qty = menuQty.getQty();

            Menu menu = menuRepository.findById(id).get();
            if (menu.getQty() >= qty) {
                menu.setQty(menu.getQty() - qty);
                menuRepository.save(menu);
            } else {
                // items sold or too late to confirm order
                result.set(false);
            }
        });
        return result.get();
    }

    private double getTotal(List<MenuQty> menuQtys) {
        AtomicReference<Double> price = new AtomicReference<>(0.0);
        menuQtys.forEach(menuQty -> {
            Long id = menuQty.getMenuId();
            int qty = menuQty.getQty();

            price.updateAndGet(v -> (double) (v + menuRepository.findById(id).get().getPrice() * qty));
        });
        return price.get();
    }

    @Override
    public Order getOrder(String username, Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        com.naveen.canteenapp.service.models.Service service = serviceRepository.findByOrderId(orderId);

        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        return orders.stream()
                .sorted(Comparator.comparing(Order::getTime).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getServedOrders() {
        return orderRepository.findServedOrders();
    }

    @Override
    public List<Order> getNotServedOrders() {
        return orderRepository.findAllNotServedOrders();
    }

    @Override
    public List<Order> getOrders(String username) {
        List<Order> orders = new ArrayList<>();

        try {
            orderRepository.findAll().forEach(order1 -> {
                if (order1.getUser().getUsername().equals(username)) {
                    orders.add(order1);
                }
            });

            if (orders.size() <= 0) {
                throw new RuntimeException("Order is empty");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return orders.stream()
                .sorted(Comparator.comparing(Order::getTime).reversed())
                .collect(Collectors.toList());

    }

}




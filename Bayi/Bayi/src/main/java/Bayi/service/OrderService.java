package Bayi.service;

import Bayi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private static Bayi.Repository.OrderRepository OrderRepository;

    public static Order createOrder(Order order) {
        return OrderRepository.save(order);
    }

    public static Order updateOrder(UUID id, Order OrderDetails) {
        Order Order = OrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

        Order.setCustomer(OrderDetails.getCustomer());
        Order.setDescription(OrderDetails.getDescription());
        Order.setPrice(OrderDetails.getPrice());
        Order.setStockQuantity(OrderDetails.getStockQuantity());

        return OrderRepository.save(Order);
    }

    public static void deleteOrder(UUID id) {
        OrderRepository.deleteById(id);
    }

    public static Order getOrderById(UUID id) {
        return OrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public static List<Order> searchOrders(String keyword) {
        return OrderRepository.findAll(); // Implement actual search logic based on keyword
    }
}

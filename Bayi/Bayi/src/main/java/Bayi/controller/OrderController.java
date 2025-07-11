package Bayi.controller;

import Bayi.model.Order;
import Bayi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(OrderService.createOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody Order OrderDetails) {
        return ResponseEntity.ok(OrderService.updateOrder(id, OrderDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        OrderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        return ResponseEntity.ok(OrderService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> searchOrders(@RequestParam(required = false) String keyword) {
        return ResponseEntity.ok(OrderService.searchOrders(keyword));
    }
}

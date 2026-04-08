package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public String getAllOrders(){
        return orderRepository.getAllOrders();
    }

    public String getOrderById(int id){
        return orderRepository.getOrderById(id);
    }

    public String getOrder(int id) {
        return orderRepository.findById(id);
    }

    public String createOrder() {
        return orderRepository.save();
    }

    public String deleteOrder(int id) {
        return orderRepository.delete(id);
    }


}

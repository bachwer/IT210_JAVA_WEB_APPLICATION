package org.example.repository;

import org.springframework.stereotype.Repository;


@Repository
public class OrderRepository {
    public String getAllOrders(){
        return "List All Orders";
    }

    public String getOrderById(int id){
        return "Order information ID: " + id;
    }

    public String findById(int id) {
        return "Order #" + id;
    }

    public String save() {
        return "Order created successfully";
    }

    public String delete(int id) {
        return "Order #" + id + " deleted";
    }
}

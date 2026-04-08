package org.example.model;


public class RestaurantTable {
    private int id;
    private int capacity;
    private String status;

    public RestaurantTable(int id, int capacity, String status) {
        this.id = id;
        this.capacity = capacity;
        this.status = status;
    }

    public int getId() { return id; }
    public int getCapacity() { return capacity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
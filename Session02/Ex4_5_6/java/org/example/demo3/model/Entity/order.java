package Session02.Ex4_5_6.java.org.example.demo3.model.Entity;

import java.util.Date;

public class order {
    private String id;
    private String productName;
    private Integer total;
    private Date orderDate;

    public order(String id, String productName, Integer total, Date orderDate) {
        this.id = id;
        this.productName = productName;
        this.total = total;
        this.orderDate = orderDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getTotal() {
        return total;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}

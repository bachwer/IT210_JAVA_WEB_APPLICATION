package Session01.Ex3.model;

public class OrderRequest {
    private String username;
    private String foodName;
    private int quantity;

    public OrderRequest(String username, String foodName, int quantity) {
        this.username = username;
        this.foodName = foodName;
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }
}

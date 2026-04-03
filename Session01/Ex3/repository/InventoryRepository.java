package Session01.Ex3.repository;

public interface InventoryRepository {
    int getStock(String foodName);
    void reduceStock(String foodName, int quantity);
}

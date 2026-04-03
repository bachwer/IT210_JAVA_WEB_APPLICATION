package Session01.Ex3.repository;

import java.util.HashMap;
import java.util.Map;

public class InventoryRepositoryImpl implements InventoryRepository{

    private Map<String, Integer> inventory = new HashMap<>();

    public InventoryRepositoryImpl(){
        inventory.put("Mì Xào Bò", 10);
        inventory.put("Mì Tôm Hùm",60 );
    }
    @Override
    public int getStock(String foodName) {
        return inventory.getOrDefault(foodName, 0);

    }

    @Override
    public void reduceStock(String foodName, int quantity) {
        inventory.put(foodName, inventory.get(foodName) - quantity);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }
}

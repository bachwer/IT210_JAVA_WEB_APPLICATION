package Session01.Ex3.service;

import Session01.Ex3.model.OrderRequest;
import Session01.Ex3.repository.InventoryRepository;
import Session01.Ex3.repository.UserAccountRepository;

public class OrderFoodService {

    private final InventoryRepository inventoryRepository;
    private final UserAccountRepository userAccountRepository;


    public OrderFoodService(InventoryRepository inventoryRepository, UserAccountRepository userAccountRepository) {
        this.inventoryRepository = inventoryRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public String orderFood(OrderRequest request){
        if(request.getUsername() == null || request.getUsername().isEmpty() || request.getQuantity() <= 0){
            return "invalid request !";
        }
        int stock = inventoryRepository.getStock(request.getFoodName());
        if (stock < request.getQuantity()){
            return "sold out !";
        }

        double price = 20000;
        double total = price * request.getQuantity();
        double balance = userAccountRepository.getBalance(request.getUsername());

        if(balance < total){
            return "Insufficient Balance!!";
        }
        userAccountRepository.deductBalance(request.getUsername(), total);
        inventoryRepository.reduceStock(request.getFoodName(), request.getQuantity());
        return "Success !";
    }
}

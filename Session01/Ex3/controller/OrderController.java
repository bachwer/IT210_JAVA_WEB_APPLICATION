package Session01.Ex3.controller;
import Session01.Ex3.model.OrderRequest;
import Session01.Ex3.repository.InventoryRepository;
import Session01.Ex3.repository.InventoryRepositoryImpl;
import Session01.Ex3.repository.UserAccountRepository;
import Session01.Ex3.repository.UserAccountRepositoryImpl;
import Session01.Ex3.service.OrderFoodService;
import org.springframework.web.bind.annotation.*;

public class OrderController {


    public static void main(String[] args) {
        InventoryRepository inventory = new InventoryRepositoryImpl();
        UserAccountRepository user = new UserAccountRepositoryImpl();

        // Inject vào service (DI thủ công)
        OrderFoodService service = new OrderFoodService(inventory, user);

        // Test case
        OrderRequest request = new OrderRequest("user1", "Mì Xào Bò", 1);

        String result = service.orderFood(request);
        System.out.println(result);
    }
}
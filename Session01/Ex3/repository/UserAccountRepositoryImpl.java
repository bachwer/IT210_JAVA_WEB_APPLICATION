package Session01.Ex3.repository;

import java.util.HashMap;
import java.util.Map;

public class UserAccountRepositoryImpl implements UserAccountRepository{

    private Map<String, Double> user = new HashMap<>();

    public UserAccountRepositoryImpl(){
        user.put("user1", 100000.0);
        user.put("user2", 5000.0);
    }

    @Override
    public double getBalance(String username) {
        return user.getOrDefault(username, 0.0);
    }

    @Override
    public void deductBalance(String username, double balance) {
        user.put(username, user.get(username) - balance);
    }

    public Map<String, Double> getUser() {
        return user;
    }

    public void setUser(Map<String, Double> user) {
        this.user = user;
    }
}

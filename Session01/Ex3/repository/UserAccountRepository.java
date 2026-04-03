package Session01.Ex3.repository;

public interface UserAccountRepository {
    double getBalance(String username);
    void deductBalance(String username, double balance);
}

package Session02.Ex4_5_6.java.org.example.demo3.model;



public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String code) {
        super("Không tìm thấy nhân viên với mã: " + code);
    }
}
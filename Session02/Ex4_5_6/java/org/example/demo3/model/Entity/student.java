package Session02.Ex4_5_6.java.org.example.demo3.model.Entity;

public class student {
    private String name;
    private String address;
    private int age;
    private double score;

    public student(String name, String address, int age, double score) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }
}

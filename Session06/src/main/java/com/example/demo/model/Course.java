package com.example.demo.model;
public class Course {
    private String id;
    private String code;
    private String name;
    private String description;
    private String instructor;
    private int duration;
    private String level;
    private double tuitionFee;
    private int studentCount;
    private int maxStudents;
    private String startDate;

    // --- Full Constructor ---
    public Course(String id, String code, String name, String description, String instructor,
                  int duration, String level, double tuitionFee, int studentCount,
                  int maxStudents, String startDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.duration = duration;
        this.level = level;
        this.tuitionFee = tuitionFee;
        this.studentCount = studentCount;
        this.maxStudents = maxStudents;
        this.startDate = startDate;
    }

    // --- Logic Method ---
    public boolean isFull() {
        return studentCount >= maxStudents;
    }

    // --- Getters and Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public double getTuitionFee() { return tuitionFee; }
    public void setTuitionFee(double tuitionFee) { this.tuitionFee = tuitionFee; }

    public int getStudentCount() { return studentCount; }
    public void setStudentCount(int studentCount) { this.studentCount = studentCount; }

    public int getMaxStudents() { return maxStudents; }
    public void setMaxStudents(int maxStudents) { this.maxStudents = maxStudents; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    // --- Optional: toString for debugging ---
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                ", enrollment=" + studentCount + "/" + maxStudents +
                '}';
    }
}
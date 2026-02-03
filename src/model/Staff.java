package model;

public class Staff {

    private int staffId;
    private String name;
    private double salary;
    private int experienceYears;

    public Staff(int staffId, String name, double salary, int experienceYears) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
        this.experienceYears = experienceYears;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}

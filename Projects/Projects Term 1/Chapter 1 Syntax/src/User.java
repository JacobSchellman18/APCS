/**
 * Created by PaulPlaia18 on 8/27/2016.
 */
public class User {
    private String name;
    private int age;
    private double excitement;
    private char goal;
    private boolean hSavior;

    public User(String name, int age, double excitement, char goal, boolean hSavior){ //overloaded in case we need it
        this.name = name;
        this.age = age;
        this.excitement = excitement;
        this.goal = goal;
        this.hSavior = hSavior;
    }

    public User(){} // non - overloaded constructor

    @Override // toString() method to easily output object state. @Override will overwrite existing method
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Excitement for APCS: " + excitement + ", Goal Grade: " + goal +
                ", Is a follower of Harambe: " + hSavior; // professional and readable formatting
    }

    /**
     * Used IntelliJ to automatically generate getters and setters. Very useful
     */

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getExcitement() {
        return excitement;
    }

    public void setExcitement(double excitement) {
        this.excitement = excitement;
    }

    public char getGoal() {
        return goal;
    }

    public void setGoal(char goal) {
        this.goal = goal;
    }

    public boolean ishSavior() {
        return hSavior;
    }

    public void setSavior(boolean hSavior) {
        this.hSavior = hSavior;
    }
}

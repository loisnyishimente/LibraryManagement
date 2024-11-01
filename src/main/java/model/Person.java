package model;

public class Person {
    private String phone;
    private String location;

    public Person(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package org.example.restaurant;

public class User {
    private String userName ;
    private String password ;
    private long number ;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getNumber() {
        return number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public User(String userName, String password, long number) {
        this.userName = userName;
        this.password = password;
        this.number = number;
    }

    private String address ;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }
}

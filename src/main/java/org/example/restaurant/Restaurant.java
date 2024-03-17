package org.example.restaurant;

public class Restaurant {
    private String name ;
    private String address ;
    private Long number ;
    private float rate ;
    private Food[] foods = new Food[10] ;

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public Long getNumber() {
        return number;
    }

    public float getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setFoods(Food[] foodsR) {
        for(int i=0 ; i<foodsR.length ; i++){
            foods[i] = foodsR[i];
        }
    }

    public Food[] getFoods() {
        return foods;
    }

    public Food[] getFood() {
        return foods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Food getFood(int i) {
        return foods[i];
    }
}

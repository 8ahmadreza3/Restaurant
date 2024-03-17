package org.example.restaurant;

public class Food {
    private String name ;
    private int price ;
    private int order = 0;

    public int getOrder() {
        return order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void plus(){
        ++order ;
    }

    public void less(){
        if(order>0)
            --order ;
    }
    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

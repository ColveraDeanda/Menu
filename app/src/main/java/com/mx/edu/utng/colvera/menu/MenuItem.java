package com.mx.edu.utng.colvera.menu;

/**
 * Created by UTNG on 20/09/2017.
 */

public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price){
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public String print(){
        String v;
        if(isVegetarian()){
             v ="vegetariano";
        }else{
            v = "No vegetariano";
        }
        return getName()+"\n"+
                getDescription()+"\n"+
                v+"\n"+
                getPrice()+"\n\n";

    }

}

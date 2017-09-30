package com.mx.edu.utng.colvera.menu;

/**
 * Created by UTNG on 20/09/2017.
 */

public class Waitress {

    MenuComponent allmenus;

    public Waitress(MenuComponent allmenus){
        this.allmenus = allmenus;
    }

    public String printMenu(){
        return allmenus.print();
    }



}

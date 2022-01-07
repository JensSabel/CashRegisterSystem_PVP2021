package com.example.demo.api;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomerController {

    private ArrayList myCart = new ArrayList();

    //Adds a product to the customers cart
    public void addToCustomerCart(String product){myCart.add(product);}

    //Removes a product from the customers cart
    public void removeFromCustomerCart(String product){myCart.remove(product);}

    //Prints the contents of the cart
    public String getCartToString(){return myCart.toString();}
}

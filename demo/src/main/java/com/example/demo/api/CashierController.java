package com.example.demo.api;

import com.example.demo.dao.CashPayment;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class CashierController {

    private HTTPhandler handman = new HTTPhandler();
    private CustomerController customer = new CustomerController();
    private ArrayList cart1 = new ArrayList();
    private ArrayList cart2; //for future userStories


    //Handler for pressing the CashButton
    @FXML
    public void onCashButtonPressed() throws IOException {

        System.out.println("Cash button pressed");
        double arbitraryCost = 24.99;
        handman.openCashRegister();
        TextInputDialog tid = new TextInputDialog();
        tid.setTitle("Cash Payment");
        tid.setHeaderText("Enter cash amount");

        Optional<String> cashPaid = tid.showAndWait();
        double cashAmount = Double.parseDouble(String.valueOf(cashPaid.get()));

        makeCashPayment(cashAmount, arbitraryCost);
    }

    //Handler for pressing the CardButton
    @FXML
    public void onCardButtonPressed() {System.out.println("Card button pressed");}

    //Handler for pressing the AddItemButton
    public void onAddItemButtonPressed() throws IOException, SAXException {
        System.out.println("Add item button pressed");
        String prodcutToAdd = handman.GetProductByBarCode("123");
        addToCarts(prodcutToAdd);
        System.out.println(prodcutToAdd);
    }

    //Handler for RemoveItemButton
    public void onRemoveItemButtonPressed() throws IOException, SAXException {

        //needs a way of selecting which product to remove
        //temp solution in place
        //Also String vars to be replaced with product-objects!
        String productToRemove = handman.GetProductByBarCode("123");
        removeFromCarts(productToRemove);
        System.out.println("Remove item button pressed");

    }

    //Adds item to both the customer screen and the cashier screen
    public void addToCarts(String product){
        cart1.add(product);
        customer.addToCustomerCart(product);
        System.out.println("Cashcart :" + cart1.toString());
        System.out.println("Custcart: " + customer.getCartToString());

    }

    //Removes item from botch customer and cashier cart
    public void removeFromCarts(String product){
        cart1.remove(product);
        customer.removeFromCustomerCart(product);
        System.out.println("Cashcart :" + cart1.toString());
        System.out.println("Custcart: " + customer.getCartToString());
    }

    //WIP until we have actual numbers to work with
    public void makeCashPayment(double amountPaid, double cost){
        CashPayment cash = new CashPayment();
        double paid = cash.makePay(amountPaid);
        double change = calculateChange(cost, amountPaid);
    }

    //Calculate change
    public double calculateChange(double amount, double paidAmount){return amount - paidAmount;}
}
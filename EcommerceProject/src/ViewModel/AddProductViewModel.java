/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;
import java.io.*;
import Model.ProductItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author mohdn
 */
public class AddProductViewModel {
    
    public boolean validateThenAdd(String id, String name, String price)  throws SQLException
    {
        try
        {
            int ID = Integer.parseInt(id);
            double Price = Double.parseDouble(price);
            //Check if name contains only space and letters
            boolean flag = name.matches("^[ A-Za-z]+$"); 
            
            if(!flag)
                return false;
        }
        catch(NumberFormatException e)
        {
            return false;           
        }
        int ID = Integer.parseInt(id);
        double Price = Double.parseDouble(price);
        
        DataBase dataBase = new DataBase();
        ArrayList<ProductItem> productsArrayList ;
        Connection connection;
        
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:productsDataBase.db");
            productsArrayList = dataBase.getProducts(connection);
            if (!isValidId(ID, productsArrayList)){
                JOptionPane.showMessageDialog(null, "Id must be unique");   
                return false;
            }
            
            else if(!isValidPrice(Price, productsArrayList)){
                JOptionPane.showMessageDialog(null, "Price number"
                        + " must be positive");  
                return false;
            }
                
            else{
                dataBase.addProductDataBase(connection, ID, name, Price);
                    return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddProductViewModel.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return true;
    }

    
    public boolean isValidId(int id, ArrayList<ProductItem> productsArrayList){
        for(ProductItem product : productsArrayList){
            if(product.getId() == id)
                return false;
        }
        return true;
    }
    
    public boolean isValidPrice(double price, ArrayList<ProductItem> productsArrayList){
        for(ProductItem product : productsArrayList){
            if(product.getPrice() < 0)
                return false;
        }
        return true;
    }
}

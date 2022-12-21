/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Model.ProductItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohdn
 */
public class ViewProductViewModel {
    public ArrayList<ProductItem> getProducts() 
    {
        ArrayList<ProductItem> productsArrayList = new ArrayList<>();
        DataBase dataBase = new DataBase();
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:productsDataBase.db");
            productsArrayList = dataBase.getProducts(connection);
        } catch (SQLException ex) 
        {
            Logger.getLogger(AddProductViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsArrayList;
    }
}

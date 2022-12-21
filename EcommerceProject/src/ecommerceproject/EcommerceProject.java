/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ecommerceproject;

import View.MainScreen;
import ViewModel.DataBase;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author mohdn
 */
public class EcommerceProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainScreen HomeScreen = new MainScreen();
        HomeScreen.setVisible(true);
        DataBase db = new DataBase();
        Connection connection;
        try {
            System.out.println("1");
            connection = DriverManager.getConnection("jdbc:sqlite:productsDataBase.db");
            System.out.println("s2");
            db.createTableDataBase(connection);          
        } 
        catch (Exception ex) {
            Logger.getLogger(EcommerceProject.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sdfasdfaqa23rawdfs");
        }
    }
    
}

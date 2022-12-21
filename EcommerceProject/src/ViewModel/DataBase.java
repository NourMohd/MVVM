/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Model.ProductItem;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author mohdn
 */
public class DataBase {

    public DataBase() {
    }
    
    public void createTableDataBase(Connection connection) throws SQLException, Exception{
        System.out.println("ssssssssssssssssss");
        String columnsTitle = "CREATE TABLE IF NOT EXISTS productsDataBase " +
                "( " +
                "Id integer PRIMARY KEY, " +
                "Name varchar(50), " +
                "Price float " +
                "); ";
        Statement statement = connection.createStatement();
        statement.executeUpdate(columnsTitle);
    }
    
    public void addProductDataBase(Connection connection, int id, String name, double price) throws SQLException{
        String addProductString = "INSERT INTO productsDataBase(Id, Name, Price) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addProductString);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setDouble(3, price);
        preparedStatement.executeUpdate();
    }
     public ArrayList<ProductItem> getProducts(Connection connection) throws SQLException{
        ArrayList<ProductItem> productsArrayList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from productsDataBase");
          while(resultSet.next())
          {
            productsArrayList.add(new ProductItem(resultSet.getInt("Id")
                    , resultSet.getString("Name")
                    , resultSet.getDouble("Price")));
          }
        return productsArrayList;
    }
    
}

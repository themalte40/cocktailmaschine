/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author dennis
 */
public class javaconnect {
    
    Connection conn = null;
    public static Connection ConnectDb(){
        
       try{
            Class.forName("org.sqlite.JDBC");
             Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/dennis/NetBeansProjects/cocktailmaschine3/JavaApplication3/Cocktails/rezepte/Benutzer.db");
             JOptionPane.showMessageDialog(null, "Connection ");
             return conn;
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}

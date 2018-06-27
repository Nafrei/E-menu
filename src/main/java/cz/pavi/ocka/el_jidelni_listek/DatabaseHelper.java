/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Langi
 */
public class DatabaseHelper {
    
    /* Definování proměnné třídy Connection */
    protected Connection conn;
    
    
    
    /**
     * Konstruktor. Slouží k připojení k MySQL serveru před JDBC.
     * @param dt MealServiceImplementation
     */
    public DatabaseHelper()
    {
        
        try
        {
            String driver = "com.mysql.jdbc.Driver"; //Do proměnné typu String uloží driver
            String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7244677?"; //Do proměnné typu String uloží url k databázi
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, "sql7244677", "CGzpYW3vTn"); //Do proměnné typu Connection uloží připojení k databázi
            if(conn.isClosed()) //Podmínka proběhne, pokud je připojení zavřeno
            {
                conn = (Connection) DriverManager.getConnection(url, "sql7244677", "CGzpYW3vTn"); //Znovu se připojí k databázi
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Načte všechna data z databáze Jídel podle typu
     * @param cisloTypu Typ jídla
     * @return Kolekce jídel
     */
    public ArrayList<Meal> nactiDataZDatabaze(int cisloTypu) 
    {
        ArrayList<Meal> jidla = new ArrayList<>();
        Meal j = null;
        try
        {
            final String dotaz = "SELECT * from Jidla WHERE Typ = ?";
            final PreparedStatement ps = (PreparedStatement) conn.prepareStatement(dotaz); 
            ps.setInt(1, cisloTypu);
            final ResultSet vysledek = ps.executeQuery();
        
            while(vysledek.next())
            {
                
                String nazev = vysledek.getString(2);
                int cena = vysledek.getInt(5);
                
                if(cisloTypu != 5)
                {
                int typ = vysledek.getInt(8);
                String popis = vysledek.getString(4);
                
                String alergeny = vysledek.getString(6);
                String gramy = vysledek.getString(7);
                
                InputStream binaryStream = vysledek.getBinaryStream(3);
                BufferedImage bf = ImageIO.read(binaryStream);
                Image obrazek = SwingFXUtils.toFXImage(bf, null);
            
                j = new Meal(nazev, popis, alergeny, gramy, cena, typ, obrazek);
                }
                else
                {
                    j = new Meal(nazev, cena);
                }
                jidla.add(j);
            }
            ps.close();
            vysledek.close();
        
        }
        catch(Exception ex)
        {
            System.out.println("chyba pri prenosu z databaze");
        }
        return jidla;
    }
    
    
    
}

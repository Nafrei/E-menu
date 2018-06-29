package cz.pavi.ocka.el_jidelni_listek;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.HashMap;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

public class DatabaseHelper {

    /**
     * Defined variable of the Connection class.
     */
    protected Connection conn;

    /**
     * Constructor. Serves to connect MySQL server before JDBC.
     *
     * @param dt MealServiceImplementation
     */
    public DatabaseHelper() {

        try {
            String driver = "com.mysql.jdbc.Driver"; //Saves driver to a String variable.
            String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7244887?"; //Saves database url to a String variable.
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, "sql7244887", "HYudjNBdUy"); //Saves connection to the database to Connection type variable.
            if (conn.isClosed()) //The condition runs if the connection is closed.
            {
                conn = (Connection) DriverManager.getConnection(url, "sql7244887", "HYudjNBdUy"); //Reconnects to the database.
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Loads all the data from the meals database by their type.
     *
     * @param typeNumber type of meal
     * @return collection of meals
     */
    public ArrayList<Meal> nactiDataZDatabaze(int typeNumber) {
        ArrayList<Meal> meals = new ArrayList<>();
        Meal j = null;
        try {
            final String query = "SELECT * from Jidla WHERE Typ = ?";
            final PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ps.setInt(1, typeNumber);
            final ResultSet result = ps.executeQuery();

            while (result.next()) {

                String name = result.getString(2);
                int price = result.getInt(5);

                if (typeNumber != 5) {
                    int type = result.getInt(8);
                    String description = result.getString(4);

                    String allergens = result.getString(6);
                    String quantity = result.getString(7);

                    InputStream binaryStream = result.getBinaryStream(3);
                    BufferedImage bf = ImageIO.read(binaryStream);
                    Image picture = SwingFXUtils.toFXImage(bf, null);

                    j = new Meal(name, description, allergens, quantity, price, type, picture);
                } else {
                    j = new Meal(name, price);
                }
                meals.add(j);
            }
            ps.close();
            result.close();

        } catch (Exception ex) {
            System.out.println("Chyba pri prenosu z databaze.");
        }
        return meals;
    }
    
    public void addOrderToDatabase(int chosenTable, HashMap<Meal, Meal>chosenMeals)
    {
       
        
            for (Meal j : chosenMeals.keySet()) 
            {
                try {
                
                final String query = "INSERT INTO Objednavky(CisloStolu, NazevJidla, Priloha, Cena)" + " VALUES(?, ?, ?, ?)";
                final PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
                ps.setInt(1, chosenTable);
                ps.setString(2, j.getName());
                if (chosenMeals.get(j) != null) 
                {
                    ps.setString(3, chosenMeals.get(j).getName());
                    ps.setInt(4, chosenMeals.get(j).getPrice()+j.getPrice());
                }
                else
                {
                    ps.setString(3, null);
                    ps.setInt(4, j.getPrice());
                }
               
                ps.executeUpdate();
               
                }catch(SQLException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            
            
        
        
    }

}

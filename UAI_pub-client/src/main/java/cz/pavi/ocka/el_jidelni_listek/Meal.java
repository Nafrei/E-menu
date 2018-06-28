/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import javafx.scene.image.Image;
/*
pokus
*/
/**
 *
 * @author Langi
 */
public class Meal {
    
    private String mealName;
    private String description;
    private String allergens;
    private String quantity;
    private int type;
    private Image picture;
    private int price;
   

    public Meal(String name, String description, String allergens, String quantity, int price, int type, Image picture) {
        this.mealName = name;
        this.description = description;
        this.allergens = allergens;
        this.quantity = quantity;
        this.picture = picture;
        this.type = type;
        this.price = price;
    }
    
    public Meal(String name, int price)
    {
        this.mealName = name;
        this.price = price;
    }
    
    public String getName()
    {
        return mealName;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getAllergens()
    {
        return allergens;
    }
    
    public String getQuantity()
    {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
    public int getPrice()
    {
        return price;
    }
    
    public Image getPicture()
    {
        return picture;
    }
    
    public int getType()
    {
        return type;
    }
    
    

    
}

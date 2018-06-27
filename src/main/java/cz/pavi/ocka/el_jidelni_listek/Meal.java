/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import javafx.scene.image.Image;

/**
 *
 * @author Langi
 */
public class Meal {
    
    private String mealName;
    private String description;
    private String allergeny;
    private String grams;
    private int type;
    private Image picture;
    private int price;
   
   

    public Meal()
    {
        
    }
    
    public Meal(String nazev, String popis, String alergeny, String gramy, int cena, int typ, Image obrazek) {
        this.mealName = nazev;
        this.description = popis;
        this.allergeny = alergeny;
        this.grams = gramy;
        this.picture = obrazek;
        this.type = typ;
        this.price = cena;
       
    }
    
    public Meal(String nazev, int cena)
    {
        this.mealName = nazev;
        this.price = cena;
    }
    
    public String getNazev()
    {
        return mealName;
    }
    
    public String getPopis()
    {
        return description;
    }
    
    public String getAlergeny()
    {
        return allergeny;
    }
    
    public String getGramy()
    {
        return grams;
    }
    
    public int getCena()
    {
        return price;
    }
    
    public Image getObrazek()
    {
        return picture;
    }
    
    public int getTyp()
    {
        return type;
    }
    
    

    
}

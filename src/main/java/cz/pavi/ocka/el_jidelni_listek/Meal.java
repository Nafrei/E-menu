/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Langi
 */
public class Meal {
    
    private String nazev;
    private String popis;
    private String alergeny;
    private String gramy;
    private int typ;
    private Image obrazek;
    private int cena;
   
   

    public Meal()
    {
        
    }
    
    public Meal(String nazev, String popis, String alergeny, String gramy, int cena, int typ, Image obrazek) {
        this.nazev = nazev;
        this.popis = popis;
        this.alergeny = alergeny;
        this.gramy = gramy;
        this.obrazek = obrazek;
        this.typ = typ;
        this.cena = cena;
    }
    
    public Meal(String nazev, int cena)
    {
        this.nazev = nazev;
        this.cena = cena;
    }
    
    public String getNazev()
    {
        return nazev;
    }
    
    public String getPopis()
    {
        return popis;
    }
    
    public String getAlergeny()
    {
        return alergeny;
    }
    
    public String getGramy()
    {
        return gramy;
    }
    
    public int getCena()
    {
        return cena;
    }
    
    public Image getObrazek()
    {
        return obrazek;
    }
    
    public int getTyp()
    {
        return typ;
    }
    
    

    
}

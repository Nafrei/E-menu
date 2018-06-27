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
    
    private String nazev;
    private String description;
    private String alergeny;
    private String gramy;
    private int type;
    private Image obrazek;
    private int cena;
   
   

    public Meal()
    {
        
    }
    
    public Meal(String nazev, String popis, String alergeny, String gramy, int cena, int typ, Image obrazek) {
        this.nazev = nazev;
        this.description = popis;
        this.alergeny = alergeny;
        this.gramy = gramy;
        this.obrazek = obrazek;
        this.type = typ;
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
        return description;
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
        return type;
    }
    
    

    
}

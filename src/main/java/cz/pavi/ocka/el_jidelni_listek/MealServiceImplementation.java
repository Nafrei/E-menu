/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public class MealServiceImplementation implements MealService {
    
    DatabaseHelper dt;
    
    int chosenTable = 0;
    
    int numberOfOrderedMeals = 0;
    
    private ObservableList<Meal> chosenMeals = null;
    
    private ObservableList<Meal> currentMeals = null;
    
    private ObservableList<String> sideDishes = null;
    
    /**
     * Konstruktor. Vytvoří novou instanci Databazovniku.
     */
    public MealServiceImplementation()
    {
        dt = new DatabaseHelper();
    }


    @Override
    public ObservableList<String> getSideDishes() {
        ArrayList<Meal> list_z_Databaze = dt.nactiDataZDatabaze(5);
        
        ArrayList<String> infoPrilohy = new ArrayList<>();
        for(Meal j: list_z_Databaze)
        {
            String nazev = j.getNazev();
            String cena = String.valueOf(j.getCena());
            infoPrilohy.add(nazev + " (" + cena + " Kč)");
        }
        sideDishes = FXCollections.observableArrayList (infoPrilohy);
        
        return sideDishes;
    }
    
    
    /**
     * Požádá DatabaseHelper o hodnoty z databáze k danému typu jídla a vrátí je jako ObservableList
     * @param type Typ jídla
     */
    @Override
    public ObservableList<Meal> getCurrentMeal(int type) {
        ArrayList<Meal> list_z_Databaze = dt.nactiDataZDatabaze(type);
        currentMeals = FXCollections.observableArrayList (list_z_Databaze);
        
        return currentMeals;
    }

    @Override
    public void addToOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void order() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChosenTable(int number) {
        chosenTable = number;
    }

    @Override
    public int getChosenTable() {
        return chosenTable;
    }

    @Override
    public ObservableList<Meal> getChosenMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumberOfOrderedMeals(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfOrderedMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

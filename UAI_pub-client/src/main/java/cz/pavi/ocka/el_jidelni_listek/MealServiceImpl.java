<<<<<<< HEAD:src/main/java/cz/pavi/ocka/el_jidelni_listek/MealServiceImplementation.java
<<<<<<< HEAD:UAI_pub-client/src/main/java/cz/pavi/ocka/el_jidelni_listek/MealServiceImpl.java
=======
>>>>>>> fb9a2342226dfb6daa9f07345f7b90f540defc38:UAI_pub-client/src/main/java/cz/pavi/ocka/el_jidelni_listek/MealServiceImpl.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public class MealServiceImpl implements MealService {
    
    DatabaseHelper dt;
    
    int chosenTable = 0;
    
    int numberOfOrderedMeals = 0;
    
    private List<Meal> chosenMeals = null;
    
    private List<Meal> currentMeals = null;
    
    private List<String> sideDishes = null;
    
    /**
     * Konstruktor. Vytvoří novou instanci Databazovniku.
     */
    public MealServiceImpl()
    {
        dt = new DatabaseHelper();
        chosenMeals = new ArrayList<Meal>();
    }


    @Override
    public List<String> getSideDishes() {
        ArrayList<Meal> databaseList = dt.nactiDataZDatabaze(5);
        
        ArrayList<String> infoSideDishes = new ArrayList<>();
        for(Meal j: databaseList)
        {
            String name = j.getName();
            String price = String.valueOf(j.getPrice());
            infoSideDishes.add(name + " (" + price + " Kč)");
        }
        sideDishes = FXCollections.observableArrayList (infoSideDishes);
        
        return sideDishes;
    }
    
    
    /**
     * Požádá DatabaseHelper o hodnoty z databáze k danému typu jídla a vrátí je jako ObservableList
     * @param type Typ jídla
     */
    @Override
    public List<Meal> getCurrentMeals(int type) {
        ArrayList<Meal> databaseList = dt.nactiDataZDatabaze(type);
        currentMeals = FXCollections.observableArrayList (databaseList);
        
        return currentMeals;
    }

    @Override
    public void addToOrder(Meal meal) {
        chosenMeals.add(meal);
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
    public List<Meal> getChosenMeals() {
        return chosenMeals;
    }


    @Override
    public int getNumberOfOrderedMeals() {
        return chosenMeals.size();
    }

    @Override
    public void deleteFromOrder(Meal meal) {
        chosenMeals.remove(meal);
    }

    @Override
    public int getPriceOfChosenMeals() {
        int sum = 0;
        for(Meal j: chosenMeals)
        {
            sum += j.getPrice();
        }
        
        return sum;
    }
    
}
<<<<<<< HEAD:src/main/java/cz/pavi/ocka/el_jidelni_listek/MealServiceImplementation.java
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.HashMap;
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
    
    private HashMap<Meal, Meal> chosenMeals = null;
    
    private ObservableList<Meal> currentMeals = null;
    
    private ObservableList<Meal> sideDishes = null;
    
    /**
     * Konstruktor. Vytvoří novou instanci Databazovniku.
     */
    public MealServiceImplementation()
    {
        dt = new DatabaseHelper();
        chosenMeals = new HashMap<Meal, Meal>();
    }


    @Override
    public ObservableList<Meal> getSideDishes() {
        ArrayList<Meal> databaseList = dt.nactiDataZDatabaze(5);
        
        ArrayList<String> infoSideDishes = new ArrayList<>();
        for(Meal j: databaseList)
        {
            String name = j.getName();
            String price = String.valueOf(j.getPrice());
            infoSideDishes.add(name + " (" + price + " Kč)");
        }
        sideDishes = FXCollections.observableArrayList (databaseList);
        
        return sideDishes;
    }
    
    
    /**
     * Požádá DatabaseHelper o hodnoty z databáze k danému typu jídla a vrátí je jako ObservableList
     * @param type Typ jídla
     */
    @Override
    public ObservableList<Meal> getCurrentMeal(int type) {
        ArrayList<Meal> databaseList = dt.nactiDataZDatabaze(type);
        currentMeals = FXCollections.observableArrayList (databaseList);
        
        return currentMeals;
    }

    @Override
    public void addToOrder(Meal meal, Meal sideDishes) {
        chosenMeals.put(meal, sideDishes);
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
    public HashMap<Meal, Meal> getChosenMeals() {
        return chosenMeals;
    }


    @Override
    public int getNumberOfOrderedMeals() {
        return chosenMeals.size();
    }

    @Override
    public void deleteFromOrder(Meal meal) {
        chosenMeals.remove(meal);
    }

    @Override
    public int getPriceOfChosenMeals() {
        int sum = 0;
        for(Meal j: chosenMeals.keySet())
        {
            sum += j.getPrice();
            if(chosenMeals.get(j) != null)
            {
                sum+= chosenMeals.get(j).getPrice();
            }
        }
        
        
        return sum;
    }
    
}
>>>>>>> parent of 4e5fc5a... Revert "Revert "Merge branch 'master' of https://github.com/Nafrei/E-menu"":src/main/java/cz/pavi/ocka/el_jidelni_listek/MealServiceImplementation.java
=======
>>>>>>> fb9a2342226dfb6daa9f07345f7b90f540defc38:UAI_pub-client/src/main/java/cz/pavi/ocka/el_jidelni_listek/MealServiceImpl.java

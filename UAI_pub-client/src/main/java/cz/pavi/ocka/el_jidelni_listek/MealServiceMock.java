<<<<<<< HEAD:src/main/java/cz/pavi/ocka/el_jidelni_listek/MealServiceMock.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public class MealServiceMock implements MealService {

    @Override
    public ObservableList<Meal> getSideDishes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*
        ArrayList<Meal> databaseList = {{"Bramboráky", "35"}{"Hranolky", "30"}}
        MealServicImplementation msi = new MealServiceImplementation();
        String[] result = msi.getSideDishes();
        assertEquals(ObservableList(new String[] {Bramboráky, "nazdar"}), result);
        */
    }

    @Override
    public ObservableList<Meal> getCurrentMeal(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void order() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChosenTable(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChosenTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public int getNumberOfOrderedMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFromOrder(Meal meal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public int getPriceOfChosenMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addToOrder(Meal meal, Meal sideDishes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Meal, Meal> getChosenMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Langi
 */
public class MealServiceMock implements MealService {

    @Override
    public List<String> getSideDishes() {    
       ArrayList<Meal> databaseList = new ArrayList<>();
        databaseList.add(new Meal("Bramborák", 35));
        MealServiceImpl msi = new MealServiceImpl();
        msi.getSideDishes();
	 
      /*  {{"Bramboráky", "35"},{"Hranolky", "30"}};
        MealServiceImplementation msi = new MealServiceImplementation();
        String[] result = msi.getSideDishes();
        assertEquals(ObservableList(new String[] {Bramboráky, "nazdar"}), result);
        */
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Meal> getCurrentMeals(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Meal> getChosenMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addToOrder(Meal meal) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //String name, String description, String allergens, String quantity, int price, int type, Image picture
     /*   
        ArrayList<Meal> databaseList = new ArrayList<>();
        databaseList.add(new Meal("Rajčatová polévka", "Aaaa", "1,2", "100mg", 0, 0, null));
        MealServiceImplementation msi = new MealServiceImplementation();
        msi.addToOrder(meal);
        assertEquals(databaseList, ArrayList<meal>);
        */
    }

    @Override
    public void order() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setChosenTable(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChosenTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    

    @Override
    public int getNumberOfOrderedMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFromOrder(Meal meal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public int getPriceOfChosenMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
>>>>>>> 49698c6e5a5d4938239da4a9ce93b074faf4d777:UAI_pub-client/src/main/java/cz/pavi/ocka/el_jidelni_listek/MealServiceMock.java

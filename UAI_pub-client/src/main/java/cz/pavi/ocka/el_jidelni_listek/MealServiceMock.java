package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MealServiceMock implements MealService {

    
    public List<Meal> getSideDishes() {
        List<Meal> databaseList = new ArrayList<>();
        databaseList.add(new Meal("Brambor�k", 35));
       
        return databaseList;
    }

    @Override
    public List<Meal> getCurrentMeals(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Meal, Meal> getChosenMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addToOrder(Meal meal, Meal sideDishes) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //String name, String description, String allergens, String quantity, int price, int type, Image picture
        /*   
        ArrayList<Meal> databaseList = new ArrayList<>();
        databaseList.add(new Meal("Raj�atov� pol�vka", "Aaaa", "1,2", "100mg", 0, 0, null));
        MealServiceImplementation msi = new MealServiceImplementation();
        msi.addToOrder(meal);
        assertEquals(databaseList, ArrayList<meal>);
         */
    }

    @Override
    public void deleteOrders(int tableID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeOrder(int tableID, List<Meal> orderedMeals) {
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
    public int getPriceOfChosenMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

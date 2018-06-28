package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.ObservableList;

public class MealServiceMock implements MealService {

    @Override
    public List<Meal> getSideDishes() {
        ArrayList<Meal> databaseList = new ArrayList<>();
        databaseList.add(new Meal("Bramborák", 35));
        MealServiceImplementation msi = new MealServiceImplementation();
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
    public HashMap<Meal, Meal> getChosenMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addToOrder(Meal meal, Meal sideDishes) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //String name, String description, String allergens, String quantity, int price, int type, Image picture
        /*   
        ArrayList<Meal> databaseList = new ArrayList<>();
        databaseList.add(new Meal("Rajèatová polévka", "Aaaa", "1,2", "100mg", 0, 0, null));
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

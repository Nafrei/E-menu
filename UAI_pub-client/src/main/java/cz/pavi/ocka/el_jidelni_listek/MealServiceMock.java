package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MealServiceMock implements MealService {

    public List<Meal> getSideDishes() {
        List<Meal> databaseList = new ArrayList<>();
        databaseList.add(new Meal("Bramborak", 35));
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

        ArrayList<Meal> databaseList = new ArrayList<>();
        databaseList.add(new Meal("Rajcatova polevka", "Aaaa", "1,2", "100ml", 0, 0, null));
        MealServiceImpl msi = new MealServiceImpl();
        msi.addToOrder(meal, sideDishes);
        //System.out.println("Add to order " + msi);

    }

    @Override
    public void deleteOrders(int tableId) {
        tableId = 1;
        MealServiceImpl msi = new MealServiceImpl();
        msi.deleteOrders(tableId);
        System.out.println("Delete orders " + msi);
    }

    @Override
    public void makeOrder() {

        //System.out.println("Make order " + orderedMeals);
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

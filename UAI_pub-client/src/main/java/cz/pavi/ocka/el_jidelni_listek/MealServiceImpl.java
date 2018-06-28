package cz.pavi.ocka.el_jidelni_listek;

import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;

public class MealServiceImpl implements MealService {

    DatabaseHelper dt;

    int chosenTable = 0;

    int numberOfOrderedMeals = 0;

    private HashMap<Meal, Meal> chosenMeals = null;

    private List<Meal> currentMeals = null;

    private List<Meal> sideDishes = null;

    /**
     * Constructor. Creates a new instance of Databazovnik.
     */
    public MealServiceImpl() {
        dt = new DatabaseHelper();
        chosenMeals = new HashMap<Meal, Meal>();
    }

    @Override
    public List<Meal> getSideDishes() {
        List<Meal> databaseList = dt.nactiDataZDatabaze(5);

        return databaseList;
    }

    
    @Override
    public List<Meal> getCurrentMeals(int type) {
        List<Meal> databaseList = dt.nactiDataZDatabaze(type);
        currentMeals = FXCollections.observableArrayList(databaseList);

        return currentMeals;
    }

    @Override
    public void addToOrder(Meal meal, Meal sideDishes) {
        chosenMeals.put(meal, sideDishes);
    }

    @Override
    public void makeOrder(int tableID, List<Meal> orderedMeals) {
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
    public void deleteOrders(int tableID) {

    }

    @Override
    public int getPriceOfChosenMeals() {
        int sum = 0;
        for (Meal j : chosenMeals.keySet()) {
            sum += j.getPrice();
            if (chosenMeals.get(j) != null) {
                sum += chosenMeals.get(j).getPrice();
            }
        }

        return sum;
    }

}
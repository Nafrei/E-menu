package cz.pavi.ocka.el_jidelni_listek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.util.Pair;

public class MealServiceImpl implements MealService {

    DatabaseHelper dt;

    int chosenTable = 0;

    private List<Pair<Meal, Meal>> chosenMeals;

    private List<Meal> currentMeals = null;

    private List<Meal> sideDishes = null;

    /**
     * Constructor. Creates a new instance of Databazovnik.
     */
    public MealServiceImpl() {
        this.chosenMeals = new ArrayList<Pair<Meal, Meal>>();
        dt = new DatabaseHelper();
        //chosenMeals = new Pair<Meal, Meal();
    }

    @Override
    public List<Meal> getSideDishes() {
        List<Meal> databaseList = dt.nactiDataZDatabaze(5);

        return databaseList;
    }

    @Override
    public List<Meal> getMealsByType(int type) {
        List<Meal> databaseList = dt.nactiDataZDatabaze(type);
        currentMeals = FXCollections.observableArrayList(databaseList);

        return currentMeals;
    }

    @Override
    public void addToCart(Meal meal, Meal sideDishes) {
        Pair<Meal, Meal> pair = new Pair<>(meal, sideDishes);
        chosenMeals.add(pair);
    }

    @Override
    public void makeOrder() {
        System.out.println(getNumberOfOrderedMeals());
        if (getNumberOfOrderedMeals() != 0) {
            dt.addOrderToDatabase(chosenTable, chosenMeals);
            chosenMeals.clear();

        }
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
    public List<Pair<Meal, Meal>> getMealsInCart() {
        return chosenMeals;
    }

    @Override
    public int getNumberOfOrderedMeals() {
        return chosenMeals.size();
    }

    @Override
    public void deleteOrders(int tableID) {
        chosenMeals.clear();
    }

    @Override
    public int getPriceOfChosenMeals() {
        int sum = 0;
        for (Pair<Meal, Meal> j : chosenMeals) {
            sum += j.getKey().getPrice();
            if (j.getValue() != null) {
                sum += j.getValue().getPrice();
            }
        }

        return sum;
    }

    @Override
    public List<Pair<Meal, Meal>> getOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pair<Meal, Meal>> getOrdersByTableId(int tableID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

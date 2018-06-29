package cz.pavi.ocka.el_jidelni_listek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

public interface MealService {

    List<Meal> getSideDishes();

    /**
     * Asks DatabaseHelper for values of given type of food from the database
     * and returns them as List.
     *
     * @param type type of food
     * @return
     */
    List<Meal> getMealsByType(int type);

    List<Pair<Meal, Meal>> getMealsInCart();

    //List<Order> getOrdersByTableId(int tableId);
    void addToCart(Meal meal, Meal sideDish);

    /**
     * The method which allows delete orders. This method serves for the next
     * order on the same table.
     *
     * @param tableId Number of the table where the order will be deleted.
     */
    void deleteOrders(int tableId);

    /**
     * The method which allows you to make an order.
     *
     * @param tableId Number of the table
     * @param orderedMeals List of ordered meals
     */
    void makeOrder();

    void setChosenTable(int number);

    int getChosenTable();

    /**
     * The method which is counting the number of your ordered items.
     *
     * @return Number
     */
    int getNumberOfOrderedMeals();

    /**
     * The method which returns price of meals which you added to your order.
     *
     * @return
     */
    int getPriceOfChosenMeals();
    
    List<Pair<Meal, Meal>>getOrders();
    
    List<Pair<Meal, Meal>>getOrdersByTableId(int tableID);
    

}

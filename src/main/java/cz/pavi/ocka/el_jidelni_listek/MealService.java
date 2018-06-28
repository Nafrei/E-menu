/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Langi
 */
public interface MealService 
{
    List<String> getSideDishes();
    
    /**
     * Požádá DatabaseHelper o hodnoty z databáze k danému typu jídla a vrátí je jako List.
     * @param type Typ jídla
     * @return Vrací list 
     */
    List<Meal> getCurrentMeals(int type);
    
    /**
     * Vrací vybraná jídla.
     * @return Vybraná jídla
     */
    List<Meal> getChosenMeals();
    
    /**
     * Metoda, která se stará o přidání jídla do objednávky.
     * @param meal Jídlo, které se přidá do objednávky.
     */
    void addToOrder(Meal meal);
    
    /**
     * Vezme vybrané jídlo a smaže je z objednávky. 
     * @param meal Jídlo, které chce uživatel smazat z objednávky.
     */
    void deleteFromOrder(Meal meal);
    
    /**
     * 
     */
    void order();
    
    
    /**
     * Pomocí vstupu se uloží k vybranému stolu číslo stolu.
     * @param number Číslo stolu
     */
    void setChosenTable(int number); 
    
    /**
     * Metoda, která vrací číslo vybraného stolu.
     * @return 
     */
    int getChosenTable();

    /**
     * Metoda, která vrací počet objednaných jídel.
     * @return 
     */
    int getNumberOfOrderedMeals();
    
    /**
     * Metoda, která vrací cenu za objednané jídla.
     * @return 
     */
    int getPriceOfChosenMeals();
}

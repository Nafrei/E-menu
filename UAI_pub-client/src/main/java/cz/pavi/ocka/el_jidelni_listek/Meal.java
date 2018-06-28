package cz.pavi.ocka.el_jidelni_listek;

import javafx.scene.image.Image;

public class Meal {

    private String mealName;
    private String description;
    private String allergens;
    private String quantity;
    private int type;
    private Image picture;
    private int price;

    public Meal(String name, String description, String allergens, String quantity, int price, int type, Image picture) {
        this.mealName = name;
        this.description = description;
        this.allergens = allergens;
        this.quantity = quantity;
        this.picture = picture;
        this.type = type;
        this.price = price;
    }

    public Meal(String name, String description, String allergens, String quantity, int price, int type) {
        this.mealName = name;
        this.description = description;
        this.allergens = allergens;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
    }

    public Meal(String name, int price) {
        this.mealName = name;
        this.price = price;
    }

    /**
     * Gets mealName atribute from Meal
     *
     * @return String mealName value
     */
    public String getName() {
        return mealName;
    }

    /**
     * Gets description atribute from Meal
     *
     * @return String description value
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets allergens atribute from Meal
     *
     * @return String allergens value
     */
    public String getAllergens() {
        return allergens;
    }

    /**
     * Gets quantity atribute from Meal
     *
     * @return String quantity value
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity atribute
     *
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets price atribute from Meal
     *
     * @return int price value
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets picture atribute from Meal
     *
     * @return Image picture value
     */
    public Image getPicture() {
        return picture;
    }

    /**
     * Gets type atribute from Meal
     *
     * @return int type value
     */
    public int getType() {
        return type;
    }

}

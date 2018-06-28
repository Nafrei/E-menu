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
     *
     * @return
     */
    public String getName() {
        return mealName;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    public String getAllergens() {
        return allergens;
    }

    /**
     *
     * @return
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @return
     */
    public Image getPicture() {
        return picture;
    }

    /**
     *
     * @return
     */
    public int getType() {
        return type;
    }

}

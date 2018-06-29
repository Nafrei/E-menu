package cz.pavi.ocka.el_jidelni_listek;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    private Tab soups;
    @FXML
    private Tab mainCourses;
    @FXML
    private Tab desserts;
    @FXML
    private Tab drinks;

    @FXML
    private Button confirm;

    @FXML
    private ChoiceBox sideDishesBox;

    @FXML
    private TabPane panel;

    @FXML
    private Spinner<Integer> table;

    @FXML
    private Text warning;

    @FXML
    private Label numberOfItems;

    @FXML
    private Label totalPrice;

    @FXML
    private Button order;

    @FXML
    private ImageView cart;

    private Scene scene;

    private MealService service;

    private int chosenType = 1;

    private SpinnerValueFactory<Integer> valueFactory;

    private final int SOUPS = 1;
    private final int MAIN_COURSES = 2;
    private final int DESSERTS = 3;
    private final int DRINKS = 4;

    ArrayList<Meal> meals;

    /**
     * Initialization method. Sets icons to tabs.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        soups.setGraphic(getImageFromLink("/images/polevka2_1.png"));
        mainCourses.setGraphic(getImageFromLink("/images/smazak1_4.png"));
        desserts.setGraphic(getImageFromLink("/images/dezerty_zmrzlina.png"));
        drinks.setGraphic(getImageFromLink("/images/napoj_cappuccino.png"));
        cart.setImage(new Image("/images/kosik.png"));

        cart.setOnMouseClicked((MouseEvent e) -> {
            openNewWindow();
        });

        cart.setOnMouseEntered(new EventHandler() {
            @Override
            public void handle(Event event) {
                scene.setCursor(Cursor.HAND); //Change cursor to hand
                cart.setFitWidth(44);
                cart.setFitHeight(42);
            }
        });

        cart.setOnMouseExited(new EventHandler() {
            @Override
            public void handle(Event event) {
                scene.setCursor(Cursor.DEFAULT); //Change cursor to hand
                cart.setFitWidth(41);
                cart.setFitHeight(39);
            }
        });

        sideDishesBox.setVisible(false);

        for (int i = 1; i < 5; i++) {
            Label allergensText = (Label) panel.lookup("#allergensText" + i);
            allergensText.setVisible(false);
            Button added = (Button) panel.lookup("#added" + i);
            added.setVisible(false);
        }

        fillSpinner();

        checkChangedTab();
    }

    void setEventHandlerOnAddOrderButtons() {
        for (int i = 1; i < 5; i++) {
            Button buttonAdd = (Button) panel.lookup("#added" + i);
            
            buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                        System.out.println("zdaaar");
                    Meal selectedSideDishes = null;

                    if (chosenType == 2) {
                        String selected = sideDishesBox.getSelectionModel().getSelectedItem().toString();
                        String name = selected.substring(0, selected.indexOf(" "));
                        if (!name.equals("Zadne")) {
                            for (Meal m : service.getSideDishes()) {
                                if (m.getName().equals(name)) {
                                    selectedSideDishes = m;
                                }
                            }

                        }
                    }
                    ListView list = (ListView) panel.lookup("#list" + chosenType);
                    Meal selectedMeal = (Meal) list.getSelectionModel().getSelectedItem();
                    service.addToCart(selectedMeal, selectedSideDishes);

                    numberOfItems.setText(String.valueOf(service.getNumberOfOrderedMeals()));
                    totalPrice.setText(String.valueOf(service.getPriceOfChosenMeals() + " CZK"));
                }

            });
        }
    }

    /**
     * Checks if a new tab has been clicked on. According to that asks for
     * filling the tab with appropriate values.
     */
    private void checkChangedTab() {
        panel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                if (newValue == soups) {
                    ListView soupsList = (ListView) panel.lookup("#list1");
                    nastavList(SOUPS, soupsList);
                } else if (newValue == mainCourses) {
                    ListView mainCoursesList = (ListView) panel.lookup("#list2");
                    nastavList(MAIN_COURSES, mainCoursesList);
                } else if (newValue == desserts) {
                    ListView dessertsList = (ListView) panel.lookup("#list3");
                    nastavList(DESSERTS, dessertsList);
                } else if (newValue == drinks) {
                    ListView drinksList = (ListView) panel.lookup("#list4");
                    nastavList(DRINKS, drinksList);
                }

            }
        });
    }

    /**
     * Sets up MealServiceImplementation and asks for filling the first tab.
     *
     * @param model MealServiceImplementation
     */
    public void setModel(MealService service, Scene scene) {
        this.service = service;

        nastavList(SOUPS, (ListView) panel.lookup("#list1"));

        setEventHandlerOnAddOrderButtons();

        this.scene = scene;
    }

    /**
     * Fills values (according to their type) to ListView.
     *
     * @param typ type of food
     * @param list Specific compomonent of ListView
     */
    private void nastavList(final int typ, ListView list) {

        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Meal>() {
            @Override
            public void changed(ObservableValue<? extends Meal> observable, Meal oldValue, Meal newValue) {
                ImageView picture = (ImageView) panel.lookup("#picture" + typ);
                Text named = (Text) panel.lookup("#name" + typ);
                Text quantity = (Text) panel.lookup("#quantity" + typ);
                Label allergens = (Label) panel.lookup("#allergens" + typ);
                Label description = (Label) panel.lookup("#description" + typ);
                Label allergensText = (Label) panel.lookup("#allergensText" + typ);
                Button added = (Button) panel.lookup("#added" + typ);

                if (newValue != null) {
                    chosenType = newValue.getType();

                    sideDishesBox.setVisible(false);

                    picture.setImage(newValue.getPicture());

                    named.setText(newValue.getName());

                    quantity.setText(newValue.getQuantity());

                    allergens.setText(newValue.getAllergens());

                    description.setText(newValue.getDescription());

                    allergensText.setVisible(true);
                    if (service.getChosenTable() == 0) {
                        added.setDisable(true);
                    }

                    added.setVisible(true);

                    if (sideDishesBox != null && typ == 2) {
                        ArrayList<String> infoSideDishes = new ArrayList<>();
                        for (Meal j : service.getSideDishes()) {
                            String name = j.getName();
                            String price = String.valueOf(j.getPrice());
                            infoSideDishes.add(name + " (" + price + " CZK)");
                        }

                        ObservableList<String> info = FXCollections.observableArrayList(infoSideDishes);
                        sideDishesBox.setVisible(true);
                        sideDishesBox.setItems(info);
                        sideDishesBox.getSelectionModel().selectFirst();
                    }
                } else {
                    picture.setImage(null);
                    named.setText("");
                    quantity.setText("");
                    description.setText("");
                    allergens.setText("");
                    allergensText.setVisible(false);
                    added.setVisible(false);
                    sideDishesBox.setVisible(false);
                }
            }
        });

        ObservableList currentMealsList = FXCollections.observableArrayList(service.getMealsByType(typ));
        list.setItems(currentMealsList);

        list.setCellFactory(param -> new ListCell<Meal>() {

            @Override
            public void updateItem(Meal meal, boolean empty) {
                super.updateItem(meal, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(meal.getName() + "\n" + meal.getPrice() + " CZK");
                    ImageView picture = new ImageView();
                    picture.setFitHeight(80);
                    picture.setFitWidth(80);
                    picture.setImage(meal.getPicture());
                    setGraphic(picture);
                }
            }
        });
    }

    /**
     * Returns ImageView according to the image's link.
     *
     * @param link link to the image
     */
    private ImageView getImageFromLink(String link) {
        Image i = new Image(link);
        ImageView imageView = new ImageView();
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        imageView.setImage(i);

        return imageView;
    }

    private void fillSpinner() {
        SpinnerValueFactory<Integer> valueFactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        table.setValueFactory(valueFactory);
    }

    @FXML
    public void onTableConfirm(ActionEvent actionEvent) {
        service.setChosenTable(Integer.valueOf(table.getValue()));
        table.setDisable(true);
        confirm.setDisable(true);
        warning.setVisible(false);
        for (int j = 1; j < 5; j++) {
            Button added = (Button) panel.lookup("#added" + j);
            added.setDisable(false);
        }
    }

    @FXML
    public void onOrderClicked(ActionEvent actionEvent) {
        service.makeOrder();
        numberOfItems.setText(String.valueOf(service.getNumberOfOrderedMeals()));
        totalPrice.setText(String.valueOf(service.getPriceOfChosenMeals() + " CZK"));
    }

    private void openNewWindow() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/OrderedMeals.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            OrderedMealsController controller = fxmlLoader.getController();
            controller.setService(service);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.setTitle("Ordered Meals");
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

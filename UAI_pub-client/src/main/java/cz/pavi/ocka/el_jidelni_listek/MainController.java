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
    private ChoiceBox sideDishesBox;

    @FXML
    private TabPane panel;

    @FXML
    private TextField table;

    @FXML
    private Text warning;

    @FXML
    private Label numberOfItems;

    @FXML
    private Label celkovaCena;

    @FXML
    private Button pay;

    @FXML
    private ImageView kosik;

    private Scene scene;

    private MealService service;

    private int vybranyTyp = 1;

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
        soups.setGraphic(getObrazekZOdkazu("file:images/polevka2_1.png"));
        mainCourses.setGraphic(getObrazekZOdkazu("file:images/smazak1_4.png"));
        desserts.setGraphic(getObrazekZOdkazu("file:images/dezerty_zmrzlina.png"));
        drinks.setGraphic(getObrazekZOdkazu("file:images/napoj_cappuccino.png"));
        kosik.setImage(new Image("file:images/kosik.png"));

        kosik.setOnMouseClicked((MouseEvent e) -> {
            openNewWindow();
        });

        kosik.setOnMouseEntered(new EventHandler() {
            @Override
            public void handle(Event event) {
                scene.setCursor(Cursor.HAND); //Change cursor to hand
                kosik.setFitWidth(44);
                kosik.setFitHeight(42);
            }
        });

        kosik.setOnMouseExited(new EventHandler() {
            @Override
            public void handle(Event event) {
                scene.setCursor(Cursor.DEFAULT); //Change cursor to hand
                kosik.setFitWidth(41);
                kosik.setFitHeight(39);
            }
        });

        sideDishesBox.setVisible(false);

        for (int i = 1; i < 5; i++) {
            Label alergenyText = (Label) panel.lookup("#alergenyText" + i);
            alergenyText.setVisible(false);
            Button pridat = (Button) panel.lookup("#pridat" + i);
            pridat.setVisible(false);
        }

        kontrolujZmenuTabu();
    }

    void setEventHandlerOnAddOrderButtons() {
        for (int i = 1; i < 5; i++) {
            Button buttonAdd = (Button) panel.lookup("#pridat" + i);

            buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    Meal selectedSideDishes = null;

                    if (vybranyTyp == 2) {
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
                    ListView list = (ListView) panel.lookup("#list" + vybranyTyp);
                    Meal selectedMeal = (Meal) list.getSelectionModel().getSelectedItem();
                    service.addToOrder(selectedMeal, selectedSideDishes);

                    numberOfItems.setText(String.valueOf(service.getNumberOfOrderedMeals()));
                    celkovaCena.setText(String.valueOf(service.getPriceOfChosenMeals() + " KÄ?"));
                }

            });
        }
    }

    /**
     * Checks if a new tab has been clicked on. According to that asks for
     * filling the tab with appropriate values.
     */
    private void kontrolujZmenuTabu() {
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
     * Sets up values (according to their type) to ListView.
     *
     * @param typ type of food
     * @param list Specific compomonent of ListView
     */
    private void nastavList(final int typ, ListView list) {

        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Meal>() {
            @Override
            public void changed(ObservableValue<? extends Meal> observable, Meal oldValue, Meal newValue) {
                ImageView obrazek = (ImageView) panel.lookup("#obrazek" + typ);
                Text nazev = (Text) panel.lookup("#nazev" + typ);
                Text gramy = (Text) panel.lookup("#gramy" + typ);
                Label alergeny = (Label) panel.lookup("#alergeny" + typ);
                Label popis = (Label) panel.lookup("#popis" + typ);
                Label alergenyText = (Label) panel.lookup("#alergenyText" + typ);
                Button pridat = (Button) panel.lookup("#pridat" + typ);

                if (newValue != null) {
                    System.out.println(list.getSelectionModel().getSelectedIndex());
                    vybranyTyp = newValue.getType();

                    sideDishesBox.setVisible(false);

                    obrazek.setImage(newValue.getPicture());

                    nazev.setText(newValue.getName());

                    gramy.setText(newValue.getQuantity());

                    alergeny.setText(newValue.getAllergens());

                    popis.setText(newValue.getDescription());

                    alergenyText.setVisible(true);
                    if (service.getChosenTable() == 0) {
                        pridat.setDisable(true);
                    }

                    pridat.setVisible(true);

                    if (sideDishesBox != null && typ == 2) {
                        ArrayList<String> infoSideDishes = new ArrayList<>();
                        for (Meal j : service.getSideDishes()) {
                            String name = j.getName();
                            String price = String.valueOf(j.getPrice());
                            infoSideDishes.add(name + " (" + price + " Kc)");
                        }

                        ObservableList<String> info = FXCollections.observableArrayList(infoSideDishes);
                        sideDishesBox.setVisible(true);
                        sideDishesBox.setItems(info);
                        sideDishesBox.getSelectionModel().selectFirst();
                    }
                } else {
                    obrazek.setImage(null);
                    nazev.setText("");
                    gramy.setText("");
                    popis.setText("");
                    alergeny.setText("");
                    alergenyText.setVisible(false);
                    pridat.setVisible(false);
                    sideDishesBox.setVisible(false);
                }
            }
        });

        ObservableList currentMealsList = FXCollections.observableArrayList(service.getCurrentMeals(typ));
        list.setItems(currentMealsList);

        list.setCellFactory(param -> new ListCell<Meal>() {

            @Override
            public void updateItem(Meal jidlo, boolean empty) {
                super.updateItem(jidlo, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(jidlo.getName() + "\n" + jidlo.getPrice() + " Kc");
                    ImageView obrazek = new ImageView();
                    obrazek.setFitHeight(80);
                    obrazek.setFitWidth(80);
                    obrazek.setImage(jidlo.getPicture());
                    setGraphic(obrazek);
                }
            }
        });
    }

    /**
     * Returns ImageView according to the image's link.
     *
     * @param link link to the image
     */
    private ImageView getObrazekZOdkazu(String link) {
        Image i = new Image(link);
        ImageView imageView = new ImageView();
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        imageView.setImage(i);

        return imageView;
    }

    @FXML
    public void onMysPrycStul(MouseEvent mouseEvent) {
        String[] stoly = {"1", "2", "3", "4", "5"};
        for (int i = 0; i < stoly.length; i++) {
            if (table.getText().equals(stoly[i])) {
                service.setChosenTable(Integer.valueOf(table.getText()));
                table.setDisable(true);
                warning.setVisible(false);
                for (int j = 1; j < 5; j++) {
                    Button pridat = (Button) panel.lookup("#pridat" + i);
                    pridat.setDisable(false);
                }
            }
        }
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

package cz.pavi.ocka.el_jidelni_listek;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 *
 */
public class OrderedMealsController implements Initializable {

    @FXML
    ListView listOfOrderedMeals;

    private MealService service;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setService(MealService service) {
        this.service = service;
        loadList();
    }

    private void loadList() {
        ArrayList<Meal> orderedMeals = new ArrayList<>(service.getChosenMeals().keySet());
        ObservableList<Meal> observableOrderedMeals = FXCollections.observableArrayList(orderedMeals);
        listOfOrderedMeals.setItems(observableOrderedMeals);

        listOfOrderedMeals.setCellFactory(param -> new ListCell<Meal>() {

            @Override
            public void updateItem(Meal jidlo, boolean empty) {
                super.updateItem(jidlo, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(jidlo.getName() + "\n" + jidlo.getPrice() + " KÄ?");
                    ImageView obrazek = new ImageView();
                    obrazek.setFitHeight(80);
                    obrazek.setFitWidth(80);
                    obrazek.setImage(jidlo.getPicture());
                    setGraphic(obrazek);
                }
            }
        });
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

/**
 *
 * @author Langi
 */
public class MainController implements Initializable {
    
    @FXML
    private Tab soups;
    @FXML
    private Tab mainCourses;
    
    @FXML
    private ListView soupsList;
    @FXML
    private ListView mainCoursesList;
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
    private Button pay;
    
    private MealService service;
        
    private final int SOUPS = 1;
    private final int MAIN_COURSES = 2;
    private final int DESSERTS = 3;
    private final int DRINKS = 4;
    
    ArrayList<Meal> meals;
    
    
    /**
     * Inicializační metoda. Nastaví ikony tabůmss
     * @param url 
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

        soups.setGraphic(getObrazekZOdkazu("file:images/polevka2_1.png"));
        mainCourses.setGraphic(getObrazekZOdkazu("file:images/smazak1_2.png"));
        sideDishesBox.setVisible(false);

        for(int i=1; i<5; i++)
        {
            Label alergenyText = (Label) panel.lookup("#alergenyText" + i);
            alergenyText.setVisible(false);
            Button pridat = (Button) panel.lookup("#pridat" + i);
            pridat.setVisible(false);
        }
        
        
        kontrolujZmenuTabu(); 
    }
    
    void setEventHandlerOnAddOrderButtons()
    {
        for(int i=1; i < 5 ; i++)
        {
            Button buttonAdd = (Button) panel.lookup("#pridat"+i);
        
            buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
            service.setNumberOfOrderedMeals(service.getNumberOfOrderedMeals() + 1);

                }
                
            });
    }
    }
    
    /**
     * Kontroluje, kdy je kliknuto na nový tab. Podle toho poté požádá o naplnění daného listu příslušnými hodnotami
     */
    private void kontrolujZmenuTabu()
    {
        panel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

        @Override
        public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) 
        {
            if(newValue == soups) 
            {
                nastavList(SOUPS, soupsList);
            }
            else if(newValue == mainCourses)
            {
                nastavList(MAIN_COURSES, mainCoursesList);
            }
        }
        });
    }
    
    /**
     * Nastaví MealServiceImplementation a požádá o naplnění prvního tabu
     * @param model MealServiceImplementation
     */
    public void setModel(MealService service)
    {
        this.service = service;

        nastavList(SOUPS, soupsList);


        setEventHandlerOnAddOrderButtons();

    }
        
    /**
     * Nastaví hodnoty (podle typu) do ListView
     * @param typ Typ jídla
     * @param list Konkrétní komponenta ListView
     */
    private void nastavList(final int typ, ListView list)
    {

        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Meal>() {
        @Override
        public void changed(ObservableValue<? extends Meal> observable, Meal oldValue, Meal newValue) 
        {
            //Label alergenyTextStary = (Label) panel.lookup("#alergenyText" + oldValue.getTyp());
            //alergenyTextStary.setVisible(false);
            if(newValue != null)
            {
                sideDishesBox.setVisible(false);
                ImageView obrazek = (ImageView) panel.lookup("#obrazek" + typ);
                obrazek.setImage(newValue.getPicture());
                
                Text nazev = (Text) panel.lookup("#nazev" + typ);
                nazev.setText(newValue.getName());
                
                Text gramy = (Text) panel.lookup("#gramy" + typ);
                gramy.setText(newValue.getQuantity());
                
                Label alergeny = (Label) panel.lookup("#alergeny" + typ);
                alergeny.setText(newValue.getAllergens());
                
                Label popis = (Label) panel.lookup("#popis" + typ);
                popis.setText(newValue.getDescription());
                
                Label alergenyText = (Label) panel.lookup("#alergenyText" + typ);
                Button pridat = (Button) panel.lookup("#pridat" + typ);
                alergenyText.setVisible(true);
                if(service.getChosenTable() == 0)
                {
                    pridat.setDisable(true);
                }
                
                pridat.setVisible(true);
                
                if(sideDishesBox != null && typ == 2)
                {
                    sideDishesBox.setVisible(true);
                    sideDishesBox.setItems(service.getSideDishes());
                    sideDishesBox.getSelectionModel().selectFirst();
                }
            }
        }
        });

        list.setItems(service.getCurrentMeal(typ));
        
        list.setCellFactory(param -> new ListCell<Meal>() {
            
            @Override
            public void updateItem(Meal jidlo, boolean empty) {
                super.updateItem(jidlo, empty);
                if (empty) 
                {
                    setText(null);
                    setGraphic(null);
                } 
                else 
                {
                    setText(jidlo.getName() + "\n" + jidlo.getPrice() + " Kč");
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
     * Vrátí ImageView podle odkazu na obrázek
     * @param odkaz Odkaz na obrázek
     */
    private ImageView getObrazekZOdkazu(String odkaz) 
    {
        Image i = new Image(odkaz);
        ImageView imageView = new ImageView();
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        imageView.setImage(i);
        
        return imageView;
    }
    
    @FXML
    public void onMysPrycStul(MouseEvent mouseEvent)
    {
        String[] stoly = {"1", "2", "3", "4", "5"};
        for(int i=0; i<stoly.length;i++)
        {
            if(table.getText().equals(stoly[i]))
            {
                service.setChosenTable(Integer.valueOf(table.getText()));
                table.setDisable(true);
                warning.setVisible(false);
                for(int j=1; j<5; j++)
                {
                    Button pridat = (Button) panel.lookup("#pridat" + i);
                    pridat.setDisable(false);
                }
            }
        }
    }
    
    
    
    /*
    Mám zde pro budoucí využití
    */
//    private class RichCarListCell extends ListCell<Jidlo> {
//        
//        private final GridPane gridPane = new GridPane(); 
//        
//        private final Label nazevJidla = new Label(); 
//        
//        //private final Rectangle colorRect = new Rectangle(10, 10); 
//        //private final Label descriptionLabel = new Label(); 
//        private final ImageView obrazek = new ImageView(); 
//        private final AnchorPane content = new AnchorPane(); 
//        
//        public RichCarListCell() { 
//            System.out.println("tady som");
//        //carIcon.setFitWidth(75); 
//        //carIcon.setPreserveRatio(true); 
//        //GridPane.setConstraints(carIcon, 0, 0, 1, 3); 
//        //GridPane.setValignment(carIcon, VPos.TOP); 
//        // 
//        nazevJidla.setStyle("-fx-font-weight: bold; -fx-font-size: 1.5em;"); 
//        GridPane.setConstraints(nazevJidla, 1, 0); 
//        // 
////        brandLabel.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
////        GridPane.setConstraints(brandLabel, 2, 0); 
////        // 
////        brandIcon.setFitWidth(22); 
////        brandIcon.setPreserveRatio(true); 
////        GridPane.setConstraints(brandIcon, 3, 0); 
////        GridPane.setValignment(brandIcon, VPos.CENTER); 
////        // 
////        colorRect.setStroke(Color.BLACK); 
////        descriptionLabel.setStyle("-fx-opacity: 0.75;"); 
////        descriptionLabel.setGraphic(colorRect); 
////        GridPane.setConstraints(descriptionLabel, 1, 1); 
////        GridPane.setColumnSpan(descriptionLabel, Integer.MAX_VALUE); 
//        //         
//        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
//        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, HPos.LEFT, true)); 
//        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
//        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
//        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
//        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
//        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true)); 
//        gridPane.setHgap(6); 
//        gridPane.setVgap(6); 
//        gridPane.getChildren().setAll(nazevJidla); 
//        AnchorPane.setTopAnchor(gridPane, 0d); 
//        AnchorPane.setLeftAnchor(gridPane, 0d); 
//        AnchorPane.setBottomAnchor(gridPane, 0d); 
//        AnchorPane.setRightAnchor(gridPane, 0d); 
//        content.getChildren().add(gridPane); 
//    } 
//        
//        
//        @Override 
//        protected void updateItem(Meal item, boolean empty) { 
//        super.updateItem(item, empty); 
//        setGraphic(null); 
//        setText(null); 
//        setContentDisplay(ContentDisplay.LEFT); 
//            
//        if (!empty && item != null) { 
//            nazevJidla.setText(item.vratNazev()); 
//            
//            //obrazek.setImage(item.vratObrazek()); 
//            
//            
//            setText(null); 
//            setGraphic(content); 
//            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
//        } 
//    } 
      
     
    }            
                
    
    
    
    
    
    
    


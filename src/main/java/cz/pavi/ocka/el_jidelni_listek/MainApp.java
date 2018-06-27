/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.pavi.ocka.el_jidelni_listek;

import cz.pavi.ocka.el_jidelni_listek.MealServiceImplementation;
import cz.pavi.ocka.el_jidelni_listek.DatabaseHelper;
import cz.pavi.ocka.el_jidelni_listek.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Langi
 */
public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Hlavni_okno.fxml"));
        BorderPane root = new BorderPane();
        //Scene scene = new Scene(root);
        //scene.getStylesheets().add("/jidelni_listek/HlavniOkno.css");
        
        MealServiceImplementation service = new MealServiceImplementation();
        
        DatabaseHelper dt = new DatabaseHelper();
        
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("/fxml/Hlavni_okno.fxml"));
        root.setCenter((Node) listLoader.load());
        MainController kontroler = listLoader.getController();
        kontroler.setModel(service);
         
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/HlavniOkno.css");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

package cz.pavi.ocka.el_jidelni_listek;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    /**
     * Starts the application, loads the window with stage set.
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Hlavni_okno.fxml"));
        BorderPane root = new BorderPane();
        //Scene scene = new Scene(root);
        //scene.getStylesheets().add("/jidelni_listek/HlavniOkno.css");

        MealServiceImpl service = new MealServiceImpl();

        DatabaseHelper dt = new DatabaseHelper();

        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("/fxml/Hlavni_okno.fxml"));
        root.setCenter((Node) listLoader.load());
        MainController kontroler = listLoader.getController();

        Scene scene = new Scene(root);
        kontroler.setModel(service, scene);
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

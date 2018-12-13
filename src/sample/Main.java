package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * String constant for title of Primary Stage.
     */
    private static final String PRIMARY_STAGE_TITLE = "Bee Simulator";
    /**
     * String constant for title of fxml file.
     */
    private static final String FXML_FILE_TITLE = "sample.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource(FXML_FILE_TITLE));
        primaryStage.setTitle(PRIMARY_STAGE_TITLE);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public Main() {
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Controller {
    private ImageView beeImage;             // image to draw on the panel
    private double beeX, beeY;              // drawn location of bee; this should be in a domain class

    @FXML
    private Pane gardenPane;                // capture the pane we are drawing on from JavaFX

    @FXML
    public void initialize() {              // executed after scene is loaded but before any methods
        // for fun, set up a gradient background; could probably do in SceneBuilder as well
        // note the label has a Z index of 2 so it is drawn above the panel, otherwise it may be displayed "under" the panel and not be visible
        gardenPane.setStyle("-fx-background-color: linear-gradient(to bottom right, derive(goldenrod, 20%), derive(goldenrod, -40%));");
        // load image from a file; the file needs to be in the top folder of the project
        beeImage = new ImageView(new Image("file:src/sample/bee-1.jpg"));
        beeImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
        beeImage.setFitWidth(50.0);         // scale bee to be a reasonable size
        beeX = beeY = 100;                  // initial location of bee; for your solution, capture this in an object
        beeImage.setFocusTraversable(true); // ensure garden pane will receive keypresses
        beeImage.requestFocus();
        gardenPane.getChildren().add(beeImage); // place bee on the panel
        displayBee();
    }

    // display the bee at the (beeX, beeY), ensuring bee does not leave the garden
    private void displayBee() {
        if ( beeX < 0 )
            beeX = 0;
        else if (gardenPane.getWidth() > 0 && beeX > gardenPane.getWidth() - 10)
            // note: getWidth() is 0 when first load the scene, so don't relocate the bee in that case
            beeX = gardenPane.getWidth() - 10;
        if (beeY < 0)
            beeY = 0;
        else if (gardenPane.getHeight() > 0 && beeY > gardenPane.getHeight() - 10)
            beeY = gardenPane.getHeight() - 10;
        beeImage.setLayoutX(beeX);
        beeImage.setLayoutY(beeY);
    }

    @FXML
    public void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            beeX += 10.0;
        } else if (keyEvent.getCode() == KeyCode.LEFT) {
            beeX -= 10.0;
        } else if (keyEvent.getCode() == KeyCode.DOWN) {
            beeY += 10.0;
        } else if (keyEvent.getCode() == KeyCode.UP) {
            beeY -= 10.0;
        }
        displayBee();
    }
}

package org.sunburn.solitairegui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.sunburn.solitairegui.solitaire.SolitaireGame;

import java.io.IOException;

public class GUIStarter extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        AnchorPane root = fxmlLoader.load();


        Controller  controller = fxmlLoader.getController();


        Scene scene = new Scene(root);
        scene.setFill(Color.RED);

        stage.setTitle("Solitaire");
        stage.setScene(scene);
        SolitaireGUI solg = new SolitaireGUI(root);

        controller.setSolg(solg);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}

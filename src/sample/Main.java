package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.Serializable;

public class Main extends Application implements Serializable {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("REAL ESTATE AGENCY");
        primaryStage.setScene(new Scene(root, 650, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

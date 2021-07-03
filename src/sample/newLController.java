package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class newLController {

    OwnerDatabase od = null;

    @FXML
    TextField text1 , text2 , text3 , text4 , text5;

    @FXML
    Text text;

    @FXML
    AnchorPane AnchorPane2;


    @FXML
    public void back(ActionEvent event) {
        Node node = (Node) event.getSource();
        Parent pane ;
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("sample.fxml"));
            stage.setUserData(od);
            Scene scene = new Scene(pane);
            // Stage curStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void add(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        od = (OwnerDatabase) stage.getUserData();
        HashMap<Integer , Owner> map = od.getData();
        String t1 = text1.getText();
        String t2 = text2.getText();
        String t3 = text3.getText();
        String t4 = text4.getText();
        String t5 = text5.getText();
        if (map.containsKey(Integer.parseInt(t3))) {
            stage = (Stage) AnchorPane2.getScene().getWindow();
            Alert.AlertType type = Alert.AlertType.ERROR;
            Alert alert = new Alert(type , "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.getDialogPane().setContentText("Enter Different Unique Owner ID !!!");

            alert.showAndWait();

        }else{
            text.setText("Saved");
            od.addl(t1 , t2 , Integer.parseInt(t3) , t4 , Double.parseDouble(t5));
        }

    }
}

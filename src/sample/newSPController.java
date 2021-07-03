package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class newSPController {



    @FXML
    TextField text1 , text2 , text3, text4  , text5 , text6 ;

    @FXML
    Text text;

    @FXML
    AnchorPane AnchorPane3;

    PropertiesDatabase pd = null;



    @FXML
    public void back(ActionEvent event) {
        Node node = (Node) event.getSource();
        Parent pane ;
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("sample.fxml"));
            stage.setUserData(pd);
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
        pd = (PropertiesDatabase) stage.getUserData();
        HashMap<Integer , Property> map = pd.get();
        OwnerDatabase od = pd.getOD();
        HashMap<String , Owner> map1 = od.getNameS();
        System.out.println(map1.size());
        for (String name : map1.keySet())
            System.out.println("key: " + name);


        for (Owner url : map1.values())
            System.out.println("value: " + url.getName());

        String t1 = text1.getText();
        String t2 = text2.getText();
        String t3 = text3.getText();
        String t4 = text4.getText();
        String t5 = text5.getText();
        String t6 = text6.getText();
        if (map.containsKey(Integer.parseInt(t3))) {
            stage = (Stage) AnchorPane3.getScene().getWindow();
            Alert.AlertType type = Alert.AlertType.ERROR;
            Alert alert = new Alert(type , "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.getDialogPane().setContentText("Enter Different Unique Owner ID !!!");

            alert.showAndWait();

        }else if (!map1.containsKey(t4)){
            stage = (Stage) AnchorPane3.getScene().getWindow();
            Alert.AlertType type = Alert.AlertType.ERROR;
            Alert alert = new Alert(type , "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.getDialogPane().setContentText("Enter Correct Name of Owner !!!");

            alert.showAndWait();
        }else{
            text.setText("Saved");
            Owner own = map1.get(t4);
            pd.adds(t1 , t2 , Integer.parseInt(t3) , own , Integer.parseInt(t5) , Double.parseDouble(t6));
        }


    }




}

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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class reportSaleController {

    @FXML
    TextField text1 , text2;

    PropertiesDatabase pd = null;

    @FXML
    AnchorPane AnchorPane5;

    @FXML
    Text text;

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
    public void done(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        pd = (PropertiesDatabase) stage.getUserData();
        String t1= text1.getText();
        String t2 = text2.getText();
        HashSet<SaleProperty> temp= pd.helpS(Integer.parseInt(t1));

        try {
            String str = "..\\Project_Vishal\\src\\sample\\Files\\"+t2  +".txt";
            File myObj = new File(str);
            if(myObj.createNewFile()){
                System.out.println("File created: "+myObj.getName());
                FileWriter myWriter = new FileWriter(str);
                myWriter.write("Report on Property For Sale \n");
                for(SaleProperty p:temp){
                    myWriter.write(p.getAddress()+"\t\t"+p.getTown()+"\t\t"+p.getPropertyOwner().getName()+"\t\t"+p.getIndoorArea()+"\t\t"+p.getPrice()+"\n");
                }
                myWriter.close();
                text.setText("Saved");
            }else{
                stage = (Stage) AnchorPane5.getScene().getWindow();
                Alert.AlertType type = Alert.AlertType.ERROR;
                Alert alert = new Alert(type , "");

                alert.initModality(Modality.APPLICATION_MODAL);
                alert.initOwner(stage);
                alert.getDialogPane().setContentText("Enter Different File Name  !!!");

                alert.showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

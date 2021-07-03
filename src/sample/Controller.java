package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

//import static org.graalvm.compiler.options.OptionType.User;

public class Controller implements Serializable {
    private static final long serialVersionUID = 5230549922091722630L;
    OwnerDatabase od = new OwnerDatabase();
    OwnerDatabase od1 = null;
    PropertiesDatabase pd = new PropertiesDatabase();
    PropertiesDatabase pd1 = null;
    HashMap<Integer , Owner> map = new HashMap<>();

    @FXML
    AnchorPane myAnchorPane;

    public void initialize(){


            String fileName = "..\\Project_Vishal\\src\\sample\\Initial\\fileOD.txt";
            try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
                od = (OwnerDatabase) ois.readObject();

            } catch (FileNotFoundException e) {
              //  e.printStackTrace();
            } catch (IOException e) {

              //  e.printStackTrace();
            } catch (ClassNotFoundException e) {

              //  e.printStackTrace();
            }
//
            String fileName1 = "..\\Project_Vishal\\src\\sample\\Initial\\filePD.txt";
            try (FileInputStream fis = new FileInputStream(fileName1); ObjectInputStream ois = new ObjectInputStream(fis);) {
                pd = (PropertiesDatabase) ois.readObject();

            } catch (FileNotFoundException e) {
                // Error in accessing the file

                // e.printStackTrace();
            } catch (IOException e) {

//                System.out.println("error in converting");
//                e.printStackTrace();
            } catch (ClassNotFoundException e) {

//                System.out.println("Invalid Stream");
//                e.printStackTrace();
            }

            System.out.println("intiall :-" + od.map.size() + "      " + pd.map.size());

            try {
                Files.deleteIfExists(Paths.get("..\\Project_Vishal\\src\\sample\\Initial\\fileOD.txt"));
                Files.deleteIfExists(Paths.get("..\\Project_Vishal\\src\\sample\\Initial\\filePD.txt"));
            } catch (IOException e) {
                //e.printStackTrace();

            }

    }




    @FXML
    public void reset(ActionEvent actionEvent) {
         od.getOD();
         map = od.getData();
    }

    @FXML
    public void reset1(ActionEvent actionEvent) {
        if(od.isDone() == true){
            pd.getPD(od);

        }else{
            Stage stage = (Stage) myAnchorPane.getScene().getWindow();
            Alert.AlertType type = Alert.AlertType.ERROR;
            Alert alert = new Alert(type , "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.getDialogPane().setContentText("Perform RESET OF OWNERS OPTION first!!!");

            alert.showAndWait();
        }
        od.setPD(pd);
    }

    @FXML
    public void reset2(ActionEvent actionEvent) {
        od.getOD();
        pd.getPD(od);
        od.setPD(pd);
    }

    @FXML
    public void newSeller(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();


        try {
            od1 = (OwnerDatabase) stage.getUserData();
            if(od1!=null) {
                od = od1;
                pd = od.getPd();
            }

        }catch(ClassCastException e ){
            pd = (PropertiesDatabase) stage.getUserData();
            od = pd.getOD();
            od.setPD(pd);
        }

        node = (Node) event.getSource();
        Parent pane ;
         stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("newS.fxml"));
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
    public void newSaleProperty(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try {
            pd1 = (PropertiesDatabase) stage.getUserData();
            if (pd1 != null) {
                pd = pd1;
                od = pd.getOD();
            }
        }catch(ClassCastException e ){
            od = (OwnerDatabase) stage.getUserData();
            pd = od.getPd();
            pd.setOD(od);
        }
        pd.update(od);
        node = (Node) event.getSource();
         Parent pane ;
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        System.out.println(od.getData().size()+"   "+pd.get().size()+"   "+od.getPd().get().size());


        try {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("newSP.fxml"));
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
    public void reportSale(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try {
            pd1 = (PropertiesDatabase) stage.getUserData();
            if (pd1 != null) {
                pd = pd1;
                od = pd.getOD();
            }
        }catch(ClassCastException e ){
            od = (OwnerDatabase) stage.getUserData();
            pd = od.getPd();
            pd.setOD(od);
        }
        pd.update(od);
        node = (Node) event.getSource();
        Parent pane ;
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        System.out.println(od.getData().size()+"   "+pd.get().size()+"   "+od.getPd().get().size());
        try {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("reportSale.fxml"));
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
    public void newLeaseProperty(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try {
            pd1 = (PropertiesDatabase) stage.getUserData();
            if (pd1 != null) {
                pd = pd1;
                od = pd.getOD();
            }
            }catch(ClassCastException e ){
            od = (OwnerDatabase) stage.getUserData();
            pd = od.getPd();
            pd.setOD(od);
        }
        pd.update(od);
        node = (Node) event.getSource();
        Parent pane ;
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        System.out.println(od.getData().size()+"   "+pd.get().size()+"   "+od.getPd().get().size());
        try {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("newLP.fxml"));
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
    public void newLandlord(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        try {
            od1 = (OwnerDatabase) stage.getUserData();
            if(od1!=null) {
                od = od1;
                pd = od.getPd();
            }

        }catch(ClassCastException e ){
            pd = (PropertiesDatabase) stage.getUserData();
            od = pd.getOD();
            od.setPD(pd);
        }

        node = (Node) event.getSource();
        Parent pane ;
        stage = (Stage) node.getScene().getWindow();
        stage.close();

        try {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("newL.fxml"));
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
    public void reportLease(ActionEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try {
            pd1 = (PropertiesDatabase) stage.getUserData();
            if (pd1 != null) {
                pd = pd1;
                od = pd.getOD();
            }
        }catch(ClassCastException e ){
            od = (OwnerDatabase) stage.getUserData();
            pd = od.getPd();
            pd.setOD(od);
        }
        pd.update(od);
        node = (Node) event.getSource();
        Parent pane ;
        stage = (Stage) node.getScene().getWindow();
        stage.close();
        System.out.println(od.getData().size()+"   "+pd.get().size()+"   "+od.getPd().get().size());
        try {
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("reportLease.fxml"));
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
    public void exit(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        try {
            pd1 = (PropertiesDatabase) stage.getUserData();
            if (pd1 != null) {
                pd = pd1;
                od = pd.getOD();
            }
        }catch(ClassCastException e ){
            od = (OwnerDatabase) stage.getUserData();
            pd = od.getPd();
            pd.setOD(od);
        }
        // method 1 of saving binary file
        byte[] stream = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos);) {
            oos.writeObject(pd);
            stream = baos.toByteArray();
        } catch (IOException e) {
            // Error in serialization
            e.printStackTrace();
        }
       // System.out.println(Arrays.toString(stream));
        Path path = Paths.get("..\\Project_Vishal\\src\\sample\\Initial\\filePD.txt");
        System.out.println(pd.map.size()+"    "+od.map.size());


        try {
            Files.write(path, stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // method 2 of saving binary file

        try (FileOutputStream fos = new FileOutputStream("..\\Project_Vishal\\src\\sample\\Initial\\fileOD.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(od);
        } catch (FileNotFoundException e) {
            // Error in accessing the file
            e.printStackTrace();
        } catch (IOException e) {
            // Error in converting the Student
            e.printStackTrace();
        }



        System.exit(0);
    }

}

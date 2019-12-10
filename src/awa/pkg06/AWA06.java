/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awa.pkg06;

import awa.pkg06.fr.awa.awajaba.entites.EvaluationConvive;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author etudiant
 */
public class AWA06 extends Application {
   
  public TextArea textAreaCom= new TextArea();
  double height = 200; //making a variable called height with a value 400  
  double width = 150;  //making a variable called height with a value 300
  
    @Override
  public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(10);
        root.setVgap(10);
        
        textAreaCom.setPrefHeight(height);
        textAreaCom.setPrefWidth(width); 

        Label Evaluer = new Label("Evaluer votre Convive :");
        Label Commentaire = new Label("Commentaire :");
        Label Note= new Label("Note :");
       
        CheckBox cBlock = new CheckBox("Bloquer le convive?");
        cBlock.setIndeterminate(false);
        
        Spinner<Integer> noteSpinner = new Spinner<Integer>();
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory( 0 ,5, 2);
        valueFactory.setValue(2);
        
        noteSpinner.setValueFactory(valueFactory);
       

        Button Valider = new Button("Valider");
        Button Annuler = new Button("Annuler");
        Annuler.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                textAreaCom.setText("");
                cBlock.setSelected(false);
            }
        });
        Valider.setOnAction(new EventHandler<ActionEvent>() {
           
           
            @Override
            public void handle(ActionEvent event) {
                EvaluationConvive leConvive= new EvaluationConvive(noteSpinner.getValue(),textAreaCom.getText(),cBlock.isSelected());
                Alert dlgNok = new Alert (Alert.AlertType.INFORMATION);
                dlgNok.setTitle("Comfirmation");
                dlgNok.setHeaderText("Evaluation validée !!!");
                dlgNok.setContentText("Note:"+leConvive.getNote()+" Commentaire:"+leConvive.getCommentaire()+"Bloqué : " + leConvive.isBloque());
                dlgNok.showAndWait();
            }
               
               
        });
       
 
        GridPane.setHalignment(Evaluer, HPos.RIGHT);
        root.add(Evaluer, 0, 0);
        GridPane.setHalignment(Commentaire, HPos.LEFT);
        root.add(Commentaire, 0, 2);
        root.add(textAreaCom, 1,2);
        root.add(Note, 0,1);
        root.add(noteSpinner, 1, 1);
        root.add(cBlock, 2 , 5);


        root.add(Valider, 1, 5);
        root.add(Annuler, 0, 5);
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("AWA_06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
   
}

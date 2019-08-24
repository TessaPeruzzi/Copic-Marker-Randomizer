/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copic.randomizer;


import javafx.scene.image.Image ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Tessa
 */
public class CopicRandomizer extends Application {
 
    Text color=new Text("");
    Text colortwo=new Text("");
    Text colorthree=new Text("");
    Rectangle r1=new Rectangle(30,10,50,50);
    Rectangle r2=new Rectangle(31,10,50,50);
    Rectangle r3=new Rectangle(32,10,50,50);
    Group grp1=new Group(r1,color);
    Group grp2=new Group(r2,colortwo);
    Group grp3=new Group (r3,colorthree);
    
    Color rectcolor1;
    Color rectcolor2;
    Color rectcolor3;
    
    String [] colorlist=new String[309];
    String [] hexcode=new String[309];
    String thecolor;
    String hexname;
    
    static int colornumber=-1;
  
    
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
    Text title=new Text("Copic Color Randomizer"); 
    Scanner scan=new Scanner(new File("copic list.txt"));
    
    while(scan.hasNext()){
     colornumber++;
     thecolor=scan.nextLine();
     hexname=scan.nextLine();
     colorlist[colornumber]=thecolor;
     hexcode[colornumber]=hexname;
     
    }

    GridPane gridpane = new GridPane();
    
    gridpane.add(grp1,0,10,2,1);
    gridpane.add(grp2,2,10,2,1);
    gridpane.add(grp3,4,10,2,1);
    gridpane.setAlignment(Pos.CENTER);
    gridpane.setMinSize(500, 500); 
   
    gridpane.setHgap(10); 
    gridpane.setVgap(10); 
   
    Button button1 = new Button("Change Color");
    button1.setStyle("-fx-background-color: #46EAF9;");
    gridpane.add(button1,0,10,2,10);
    button1.setOnAction(this::buttonClick1);
    
    Button button2 = new Button("Change Color");
    button2.setStyle("-fx-background-color: #46EAF9;");
    gridpane.add(button2,2,10,2,10);
    button2.setOnAction(this::buttonClick2);
     
    Button button3 = new Button("Change Color");
    button3.setStyle("-fx-background-color: #46EAF9;");
    gridpane.add(button3,4,10,2,10);
    button3.setOnAction(this::buttonClick3);
    
    Image background=new Image("file:copic randomizer.png");
    ImageView view=new ImageView(background);
    view.setFitHeight(500);
    view.setFitWidth(500);
    
    Group finalgrp=new Group(view,gridpane);
    
     
        Scene scene=new Scene(finalgrp);
        primaryStage.setTitle("Copic Color Randomizer");
        primaryStage.setScene(scene);
        primaryStage.setHeight(547);
        primaryStage.setWidth(515);
        primaryStage.show();
    }
 private void buttonClick1(ActionEvent event)
    {
        Random rand = new Random();
        int random1=rand.nextInt(colorlist.length);
        color.setText(colorlist[random1]);
        rectcolor1=Color.web(hexcode[random1]);
        r1.setFill(rectcolor1);
    }
  private void buttonClick2(ActionEvent event)
    {
        Random rand = new Random();
        int random2=rand.nextInt(colorlist.length);
        colortwo.setText(colorlist[random2]);
        rectcolor2=Color.web(hexcode[random2]);
        r2.setFill(rectcolor2);
    }
  private void buttonClick3(ActionEvent event)
    {
        Random rand = new Random();
        int random3=rand.nextInt(colorlist.length);
        colorthree.setText(colorlist[random3]);
        rectcolor3=Color.web(hexcode[random3]);
        r3.setFill(rectcolor3);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

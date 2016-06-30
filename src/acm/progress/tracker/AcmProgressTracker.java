/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker;

import acm.progress.tracker.user_id.* ;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class is first class where our application start.
 * It extends Application class 
 */
public class AcmProgressTracker extends Application {
    
    Stage window ;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage ;
        window.setTitle("Acm Progress Tracker");
        window.setMinWidth(500);
        window.setMinHeight(300);
        
        Button oj[] = new Button[6] ;
        
        /**
         * Here we create five button for our five different online judge 
         * One user should use one of them .
         */
        
        oj[0] = new Button("Uva");
        oj[1] = new Button("HDU");
        oj[2] = new Button("Codeforce");
        oj[3] = new Button("Poj");
        oj[4] = new Button("Timus/Ural");
        
        HBox hb = new HBox(20);
        hb.setAlignment(Pos.CENTER);
        
        /**
         * Set hight and width of oj(online judge) Button
         */
        
        for(int i=0 ; i<5 ; i++)
        {
            oj[i].setMinWidth(50);
            oj[i].setMinHeight(50);
            hb.getChildren().add(oj[i]);
        }
        
        /**
         * Here we set position of button in scene and set label
         */
        
        VBox vb = new VBox(20);
        
        Label lbl = new Label("Please Select a Judge ");
        
        vb.getChildren().addAll(lbl,hb);
        vb.setAlignment(Pos.CENTER);
        
        StackPane stk = new StackPane();
        stk.getChildren().add(vb);
        stk.setAlignment(Pos.CENTER);
        
        /**
         * In this section we set oj button action
         */
        
        /**
         *  this is for uva online judge button 
         *  when we click here it create a Uva class and show user name input window
         */
        
        oj[0].setOnAction(e -> {
            Uva uv = new Uva();
            
            uv.showAll();
        });
        
        /**
         *  this is for HDU online judge button 
         *  when we click here it create a Hdu class and show user name input window
         */
        
        oj[1].setOnAction(e -> {
            Hdu hd = new Hdu();
            
            hd.showAll();
        });
        
        /**
         *  this is for CODEFORCES online judge button 
         *  when we click here it create a Cf class and show user name input window
         */
        
        oj[2].setOnAction(e -> {
            Cf cdf = new Cf();
            
            cdf.showAll();
        });
        
        /**
         *  this is for POJ online judge button 
         *  when we click here it create a Poj class and show user name input window
         */
        
        oj[3].setOnAction(e -> {
            Poj pj = new Poj();
            
            pj.showAll();
        });
        
        /**
         *  this is for Timus online judge button 
         *  when we click here it create a Timus class and show user name input window
         */
        
        oj[4].setOnAction(e -> { 
            Timus tm = new Timus();
            
            tm.showAll();
        });
        
        /**
         * here we set scene in our stage
         */    
        
        Scene scn = new Scene(stk,500,300);
        window.setScene(scn);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

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
 *
 * @author RONIN-47
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
        
        oj[0] = new Button("Uva");
        oj[1] = new Button("HDU");
        oj[2] = new Button("Codeforce");
        oj[3] = new Button("Poj");
        oj[4] = new Button("Timus/Ural");
        
        HBox hb = new HBox(20);
        hb.setAlignment(Pos.CENTER);
        
        for(int i=0 ; i<5 ; i++)
        {
            oj[i].setMinWidth(50);
            oj[i].setMinHeight(50);
            hb.getChildren().add(oj[i]);
        }
        
        VBox vb = new VBox(20);
        
        Label lbl = new Label("Please Select a Judge ");
        
        vb.getChildren().addAll(lbl,hb);
        vb.setAlignment(Pos.CENTER);
        
        StackPane stk = new StackPane();
        stk.getChildren().add(vb);
        stk.setAlignment(Pos.CENTER);
        
        oj[0].setOnAction(e -> {
            Uva uv = new Uva();
            
            uv.showAll();
        });
        
        oj[1].setOnAction(e -> {
            Hdu hd = new Hdu();
            
            hd.showAll();
        });
        
        oj[2].setOnAction(e -> {
            Cf cdf = new Cf();
            
            cdf.showAll();
        });
        
        oj[3].setOnAction(e -> {
            Poj pj = new Poj();
            
            pj.showAll();
        });
        
        oj[4].setOnAction(e -> { 
            Timus tm = new Timus();
            
            tm.showAll();
        });
        
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

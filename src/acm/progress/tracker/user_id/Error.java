/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * this class show error message 
 * @author RONIN-47
 */
public class Error 
{

    /**
     *  show method create scene with error message
     */
    public void show()
    {
        Stage window = new Stage();
        window.setTitle("Error !!");
        Image ico = new Image("images/acm.png");
        window.getIcons().add(ico);
        
        window.setMinWidth(400);
        window.setMinHeight(130);
        window.setMaxHeight(130);
        window.setMaxWidth(400);
        
        Label lb = new Label("Problem with user name or Internet Connection.");
        Button bt = new Button("OK");
        lb.setTextFill(Color.RED);
        
        VBox vb = new VBox(20);
        vb.getChildren().addAll(lb,bt);
        vb.setAlignment(Pos.CENTER);
        
        bt.setOnAction(e -> {
            window.close();
        });
        
        window.initModality(Modality.APPLICATION_MODAL);
        vb.setStyle("-fx-background: black;");
        Scene scn = new Scene(vb,300,100);
        scn.getStylesheets().add("stylesheet/mainwindow.css");
        window.setScene(scn);
        window.show();
    }
}

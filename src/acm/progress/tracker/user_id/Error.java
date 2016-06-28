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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author RONIN-47
 */
public class Error 
{
    public void show()
    {
        Stage window = new Stage();
        
        window.setMinWidth(310);
        window.setMinHeight(110);
        window.setMaxHeight(110);
        window.setMaxWidth(310);
        
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
        
        Scene scn = new Scene(vb,300,100);
        window.setScene(scn);
        window.show();
    }
}

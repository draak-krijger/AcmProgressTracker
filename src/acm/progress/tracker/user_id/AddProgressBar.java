/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author RONIN-47
 */
public class AddProgressBar 
{
    Stage window = new Stage() ;
    
    void show()
    {
        ProgressIndicator pb = new ProgressIndicator();
        pb.setPrefSize(200, 50);
        pb.setProgress(-1.0);
        Label lb = new Label("Progressing . . .");
        VBox vb = new VBox();
        vb.getChildren().addAll(lb,pb);
        vb.setPadding(new Insets(10,10,10,10));
        vb.setAlignment(Pos.CENTER);
        
        window.initModality(Modality.APPLICATION_MODAL);
        
        Scene scn = new Scene(vb,250,70);
        window.setScene(scn);
        window.show();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author RONIN-47
 */
public class CreateScene 
{
    ArrayList list = new ArrayList();
    ListView<Integer> userlist = new ListView<>() ;
    Button btn1 , btn2 , btn3 ;
    HBox hb;
    VBox vb ;
    Scene scn ;
    
    public CreateScene(ArrayList a) 
    {
        this.list = a ;
    }
    
    public void make_scene()
    {
        btn1 = new Button("My");
        btn2 = new Button("Friend");
        btn3 = new Button("Differences");
        
        hb = new HBox(10) ;
        hb.getChildren().addAll(btn1,btn2,btn3);
        userlist.getItems().addAll(list);
        
        vb = new VBox(20) ;
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.getChildren().addAll(userlist,hb);
        scn = new Scene(vb,790,490);
    }
}

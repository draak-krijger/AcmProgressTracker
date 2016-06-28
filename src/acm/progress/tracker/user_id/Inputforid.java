/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.net.URL;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.stream.XMLInputFactory;

/**
 *
 * @author RONIN-47
 */
public abstract class Inputforid 
{
    Stage window = new Stage();
    
    Label name = new Label("User Id  :");
    Label comp = new Label("Compare With :");
    
    VBox lb = new VBox(25);
    
    TextField user_id = new TextField();
    TextField compared_id = new TextField();
    Button submit = new Button("Submit");
    Text txt  = new Text() ;
    
    VBox id_valu = new VBox(20);
    
    HBox hb = new HBox(30);
    
    String us , cp , str = "*Please Input Valid Username" ;
    URL us_u , cp_u ;
    
    public void showAll()
    {
        lb.getChildren().addAll(name,comp);
        id_valu.getChildren().addAll(user_id,compared_id,submit,txt);
        
        txt.setFill(Color.FIREBRICK);
        
        hb.getChildren().addAll(lb,id_valu);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(50, 0, 0, 0));
        
        StackPane st = new StackPane();
        st.getChildren().addAll(hb);
        st.setAlignment(Pos.CENTER);
        
        Scene scn = new Scene(st);
        
        window.setTitle("User Name Input");
        window.setMaxHeight(250);
        window.setMaxWidth(400);
        window.setMinHeight(250);
        window.setMinWidth(400);
        
        submit.setOnAction(e -> { 
            check();
        });
        
        window.initModality(Modality.APPLICATION_MODAL);
        
        window.setScene(scn);
        window.show();
    }
    
    static boolean is_empty(String str)
    {
        if(str.length() == 0)
            return true ;
        
        return false ;
    }
    
    abstract boolean is_valid(String st);
    abstract void next_window();
    
    void check()
    {
        us = user_id.getText();
        cp = compared_id.getText();
        txt.setText("");
        
        if(is_empty(us) || is_empty(cp))
        {
            Error er = new Error();
            er.show();
        }
        
        else
        {
            if(is_valid(us) & is_valid(cp))
                next_window();
            
            else
            {
                Error er = new Error();
                er.show();
            }
        }
    }
}
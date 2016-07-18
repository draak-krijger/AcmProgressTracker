/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
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
 * This is an abstract class . 
 * In this class we create a new window which help us to take input from user user name .
 * 
 */
public abstract class Input 
{
    /**
     * here we create a new stage object. 
     */
    
    Stage window = new Stage();
    
    Label name = new Label("User Name    :");
    Label comp = new Label("Compare With :");
    
    VBox lb = new VBox(25);
    
    TextField user_id = new TextField();
    TextField compared_id = new TextField();
    Button submit = new Button("Submit");
    Text txt  = new Text() ;
    
    VBox id_valu = new VBox(20);
    
    HBox hb = new HBox(30);
    
    String us , cp , str = "*Please wait while parsing data ...." ;
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
        
        window.initModality(Modality.APPLICATION_MODAL);
        
       /*
        Label prog = new Label("Please wait while parshing data ..");
        ProgressIndicator pg = new ProgressIndicator();
        pg.setPrefSize(0,200);
        pg.setProgress(-1.0);
        
        VBox pvb = new VBox(20);
        pvb.getChildren().addAll(prog,pg);
        pvb.setAlignment(Pos.CENTER);
        Scene scn2 = new Scene(pvb,390,210);
        */
        submit.setOnAction(e -> {
            //window.setScene(scn2);
            //window.close();
            check();
            //System.out.println("ok pass");
            //window.setScene(scn);
            //window.show();
        });
        
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

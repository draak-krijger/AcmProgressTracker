/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.net.URL;
import java.util.ArrayList;
import javafx.concurrent.Task;
import javafx.event.Event;
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
 *  this class is same as input but its for id ;
 * @author RONIN-47 
 */
public abstract class Inputforid 
{   
    String us , cp , str = "*Please Input Valid Username" ;
    URL us_u , cp_u ;
    CollectingDatafromServer cds ;
    boolean isk ;
    
    /**
     *
     * @param judge
     */
    public void showAll(int judge)
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
    
        lb.getChildren().addAll(name,comp);
        id_valu.getChildren().addAll(user_id,compared_id,submit,txt);
        
        txt.setFill(Color.FIREBRICK);
        
        hb.getChildren().addAll(lb,id_valu);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(50, 0, 0, 0));
        
        StackPane st = new StackPane();
        st.getChildren().addAll(hb);
        st.setAlignment(Pos.CENTER);
        st.setStyle("-fx-background: black;");
        Scene scn = new Scene(st);
        
        window.setTitle("User Name Input");
        window.setMaxHeight(250);
        window.setMaxWidth(400);
        window.setMinHeight(250);
        window.setMinWidth(400);
        
        submit.setOnAction(e -> { 
            us = user_id.getText();
            cp = compared_id.getText();
            txt.setText("");
            check(judge);
        });
        
        window.initModality(Modality.APPLICATION_MODAL);
        scn.getStylesheets().add("stylesheet/mainwindow.css");
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
    abstract void next_window(ArrayList v1,ArrayList v2);
    
    void check(int judge)
    {
        if(is_empty(us) || is_empty(cp))
        {
            Error er = new Error();
            er.show();
        }
        
        else
        {
            cds = new CollectingDatafromServer(judge, us, cp);
            AddProgressBar pb = new AddProgressBar();
            isk = false ;
            
            pb.window.setOnCloseRequest(e -> {
                cds.stop();
                isk = true; 
                return ;
            });
            
            tsk.setOnSucceeded((Event event) -> {
                
                pb.window.close();
                
                if(isk)
                    return ;
                
                if(cds.is_valid == 1)
                    next_window(cds.v1,cds.v2);
            
                else
                {
                    Error er = new Error();
                    er.show();
                }
            });
            
            pb.show();
            
            Thread th = new Thread(tsk);
            th.start();
        }
    }
    
    Task tsk = new Task<Void>()
    {   
        @Override
        protected Void call() 
        {
            cds.start();
            
            try
            {
                cds.join();
            }
            
            catch(Exception ex)
            {
                // 
            }
            
            return null ;
        } 
    };
}

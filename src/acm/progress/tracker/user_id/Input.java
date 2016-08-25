/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.net.URL;
import java.util.ArrayList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    
    
    
    public String us , cp , str = "*Please wait while parsing data ...." ;
    URL us_u , cp_u ;

    /**
     *  create new thread 
     */
    public CollectingDatafromServer cds ;

    /**
     *  if isk is false then its first time 
     */
    public boolean isk ;
    public ArrayList fv1 = new ArrayList() ,

    /**
     *  
     */
    fv2 = new ArrayList() ,

    /**
     *
     */
    fd = new ArrayList() ;

    /**
     *
     */
    public ArrayList dif = new ArrayList();

    /**
     *
     */
    public AddProgressBar pb ;
    
    /**
     *
     * @param judge judge id 
     */
    public void showAll(int judge)
    {
        Stage window = new Stage();
        Image ico = new Image("images/acm.png");
        window.getIcons().add(ico);
    
        Label name = new Label("User Name    :");
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
        
        window.initModality(Modality.APPLICATION_MODAL);
        
        submit.setOnAction(e -> {
            us = user_id.getText();
            cp = compared_id.getText();
            txt.setText("");
        
            check(judge);
        });
        
        scn.getStylesheets().add("stylesheet/mainwindow.css");
        window.setScene(scn);
        window.show();
    }
    
    /**
     *
     * @param str user name 
     * @return is it empty or not 
     */
    public boolean is_empty(String str)
    {
        if(str.length() == 0)
            return true ;
        
        return false ;
    }
    
    abstract boolean is_valid(String st);
    abstract void next_window(ArrayList v1,ArrayList v2);
   
    /**
     *
     * @param judge judge id 
     */
    public void check(int judge)
    {
        if(is_empty(us) || is_empty(cp))
        {
            Error er = new Error();
            er.show();
        }
        
        else
        {
            isk = false ;
            cds = new CollectingDatafromServer(judge, us, cp);
            pb = new AddProgressBar();
            
            pb.window.setOnCloseRequest(e -> {
                cds.stop();
                isk = true ;
                return ;
            });
            
            pb.show();
            
            Thread th = new Thread(tsk);
            th.start();
        }
    }
    
    /**
     * Task for collecting data form judge  
     */
    public Task tsk = new Task<Void>()
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

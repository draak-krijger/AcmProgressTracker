/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author RONIN-47
 */
public class ShowWindow 
{
    Stage window ;
    ArrayList us1 = new ArrayList() , us2 = new ArrayList() , df = new ArrayList() ;
    
    public ShowWindow(ArrayList us1,ArrayList us2,ArrayList df)
    {
        this.us1 = us1 ;
        this.us2 = us2 ;
        this.df = df ;
    }
    
    public void show(boolean flag)
    {
        window = new Stage();
        
        Image ico = new Image("images/acm.png");
        window.getIcons().add(ico);
        
        window.setTitle("Differences");
        window.setMinHeight(500);
        window.setMaxHeight(500);
        window.setMinWidth(800);
        window.setMaxWidth(800);
        
        if(flag)
        {
            Createsceneforstring scn1 = new Createsceneforstring(us1);
            Createsceneforstring scn2 = new Createsceneforstring(us2);
            Createsceneforstring scn3 = new Createsceneforstring(df);
            
            scn1.make_scene();
            scn2.make_scene();
            scn3.make_scene();

            scn1.btn1.setOnAction(e -> {
                scn1.btn1.setDefaultButton(true);
                window.setScene(scn1.scn);
            });

            scn2.btn1.setOnAction(e -> {
                scn1.btn1.setDefaultButton(true);
                window.setScene(scn1.scn);
            });

            scn3.btn1.setOnAction(e -> {
                scn1.btn1.setDefaultButton(true);
                window.setScene(scn1.scn);
            });

            scn1.btn2.setOnAction(e -> {
                scn2.btn2.setDefaultButton(true);
                window.setScene(scn2.scn);
            });

            scn2.btn2.setOnAction(e -> {
                scn2.btn2.setDefaultButton(true);
                window.setScene(scn2.scn);
            });

            scn3.btn2.setOnAction(e -> {
                scn2.btn2.setDefaultButton(true);
                window.setScene(scn2.scn);
            });

            scn1.btn3.setOnAction(e -> {
                scn3.btn3.setDefaultButton(true);
                window.setScene(scn3.scn);
            });

            scn2.btn3.setOnAction(e -> {
                scn3.btn3.setDefaultButton(true);
                window.setScene(scn3.scn);
            });

            scn3.btn3.setOnAction(e -> {
                scn3.btn3.setDefaultButton(true);
                window.setScene(scn3.scn);
            });

            window.setScene(scn3.scn);
        }
        
        else
        {
            CreateScene scn1 = new CreateScene(us1);
            CreateScene scn2 = new CreateScene(us2);
            CreateScene scn3 = new CreateScene(df);
            
            scn1.make_scene();
            scn2.make_scene();
            scn3.make_scene();

            scn1.btn1.setOnAction(e -> {
                scn1.btn1.setDefaultButton(true);
                window.setScene(scn1.scn);
            });

            scn2.btn1.setOnAction(e -> {
                scn1.btn1.setDefaultButton(true);
                window.setScene(scn1.scn);
            });

            scn3.btn1.setOnAction(e -> {
                scn1.btn1.setDefaultButton(true);
                window.setScene(scn1.scn);
            });

            scn1.btn2.setOnAction(e -> {
                scn2.btn2.setDefaultButton(true);
                window.setScene(scn2.scn);
            });

            scn2.btn2.setOnAction(e -> {
                scn2.btn2.setDefaultButton(true);
                window.setScene(scn2.scn);
            });

            scn3.btn2.setOnAction(e -> {
                scn2.btn2.setDefaultButton(true);
                window.setScene(scn2.scn);
            });

            scn1.btn3.setOnAction(e -> {
                scn3.btn3.setDefaultButton(true);
                window.setScene(scn3.scn);
            });

            scn2.btn3.setOnAction(e -> {
                scn3.btn3.setDefaultButton(true);
                window.setScene(scn3.scn);
            });

            scn3.btn3.setOnAction(e -> {
                scn3.btn3.setDefaultButton(true);
                window.setScene(scn3.scn);
            });

            window.setScene(scn3.scn);
        }
       
        window.show();
    }
}

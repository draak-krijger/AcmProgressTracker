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
public class Createsceneforstring 
{
    ArrayList list = new ArrayList() , list2 = new ArrayList() ;
    ListView<String> userlist = new ListView<>() ;
    Button btn1 , btn2 , btn3 ;
    HBox hb;
    VBox vb ;
    Scene scn ;
    
    public Createsceneforstring(ArrayList a) 
    {
        this.list = a ;
    }
    
    public void make_scene()
    {
        int valu , ch ;
        String str ;
        
        for(int i=0 ; i<list.size() ; i++)
        {
            valu = (int)list.get(i);
            
            if(i>0 && (int)list.get(i) == (int)list.get(i-1))
                continue ;
            
            //System.out.println(valu);
            ch = valu%10 ;
            valu /= 10 ;
            str = Integer.toString(valu);
            str += " " ;
            str += Character.toString((char) ('A'+ch));
            //System.out.println(str);
            list2.add(str);
        }
            
        btn1 = new Button("My");
        btn2 = new Button("Friend");
        btn3 = new Button("Differences");
        
        hb = new HBox(10) ;
        hb.getChildren().addAll(btn1,btn2,btn3);
        userlist.getItems().addAll(list2);
        
        vb = new VBox(20) ;
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.getChildren().addAll(userlist,hb);
        scn = new Scene(vb,790,490);
    }
}

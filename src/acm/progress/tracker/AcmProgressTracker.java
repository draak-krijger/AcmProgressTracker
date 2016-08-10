/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker;

import acm.progress.tracker.user_id.* ;
import acm.progress.tracker.user_id.Error ;
import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class is first class where our application start.
 * It extends Application class 
 */
public class AcmProgressTracker extends Application {
    
    Stage window ;
    private TableView<TableRow>table = new TableView<TableRow>() ;
    private final ObservableList<TableRow>list = FXCollections.observableArrayList() ;
    String us , cp ;
    TextField user_name_input = new TextField();
    TextField compare_id_input = new TextField();
    int judge_id ;
    ArrayList differn = new ArrayList();
    work th ;
    
    @Override
    public void start(Stage primaryStage) {
        th = new work();
        window = primaryStage ;
        window.setTitle("Acm Progress Tracker");
        window.setMinWidth(1080);
        window.setMinHeight(500);
        Image ico = new Image("images/acm.png");
        window.getIcons().add(ico);
        
        Button oj[] = new Button[6] ;
        Label user_name = new Label("User  Name/Id :");
        Label compare_id = new Label("Compare With :");
        
        HBox hb1 = new HBox(10);
        hb1.getChildren().addAll(user_name,user_name_input);
        
        HBox hb2 = new HBox(10);
        hb2.getChildren().addAll(compare_id,compare_id_input);
        hb2.setPadding(new Insets(0, 0, 20, 0));
        
        
        /**
         * Here we create five button for our five different online judge 
         * One user should use one of them .
         */
        
        oj[0] = new Button("Uva");
        oj[1] = new Button("HDU");
        oj[2] = new Button("Codeforce");
        oj[3] = new Button("Poj");
        oj[4] = new Button("Timus/Ural");
        
        VBox Vb1 = new VBox(20);
        Vb1.setPadding(new Insets(0, 5, 10, 5));
        Vb1.getChildren().add(hb1);
        Vb1.getChildren().add(hb2);
        Vb1.setAlignment(Pos.CENTER);
        
        /**
         * Set hight and width of oj(online judge) Button
         */
        
        for(int i=0 ; i<5 ; i++)
        {
//            oj[i].setMinWidth(50);
//            oj[i].setMinHeight(50);
            oj[i].setAlignment(Pos.CENTER);
            oj[i].setPrefWidth(100);
            Vb1.getChildren().add(oj[i]);
        }
        
        Label table_head = new Label("Differences");
        
        TableColumn Me = new TableColumn("Me");
        Me.setPrefWidth(50);
        Me.setCellValueFactory(new PropertyValueFactory<TableRow,String>("Me"));
        
        TableColumn Friend = new TableColumn("Friend");
        Friend.setPrefWidth(50);
        Friend.setCellValueFactory(new PropertyValueFactory<TableRow,String>("Friend"));
        
        TableColumn Difference = new TableColumn("Difference");
        Difference.setPrefWidth(50);
        Difference.setCellValueFactory(new PropertyValueFactory<TableRow,String>("Difference"));
        
        TableColumn problem_name = new TableColumn("Problem Name");
        problem_name.setMinWidth(200);
        problem_name.setCellValueFactory(new PropertyValueFactory<TableRow,String>("ProblemName"));
        
        Button save = new Button("SAVE");
        save.setAlignment(Pos.CENTER);
        
        table.setItems(list);
        table.getColumns().addAll(Me,Friend,Difference,problem_name);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        VBox vb2 = new VBox(10);
        vb2.setMinWidth(800);
        vb2.getChildren().addAll(table_head,table,save);
        vb2.setAlignment(Pos.CENTER);
        /**
         * Here we set position of button in scene and set label
         */
        
        HBox hb = new HBox(10);
        hb.getChildren().addAll(Vb1,vb2);
        hb.setMinWidth(1100);
        hb.setMinHeight(1100);
        
        /**
         * In this section we set oj button action
         */
        
        /**
         *  this is for uva online judge button 
         *  when we click here it create a Uva class and show user name input window
         */
        
        oj[0].setOnAction(e -> {
//            System.out.println(th.isAlive());
            if(th.isAlive())
            {
                try
                {
                    th.stop();
                }
                
                catch(Exception ex)
                {
                    
                }
            }
            list.clear();
            table.refresh();
            uva();
            judge_id = 0 ;
        });
        
        /**
         *  this is for HDU online judge button 
         *  when we click here it create a Hdu class and show user name input window
         */
        
        oj[1].setOnAction(e -> {
            
            if(th.isAlive())
            {
                try
                {
                    th.stop();
                }
                
                catch(Exception ex)
                {
                    
                }
            }
            
            list.clear();
            table.refresh();
            
            hdu();
            judge_id = 1 ;
        });
        
        /**
         *  this is for CODEFORCES online judge button 
         *  when we click here it create a Cf class and show user name input window
         */
        
        oj[2].setOnAction(e -> {
            if(th.isAlive())
            {
                try
                {
                    th.stop();
                }
                
                catch(Exception ex)
                {
                    
                }
            }
            
            list.clear();
            table.refresh();
            
            codeforces();
            judge_id = 2 ;
        });
        
        /**
         *  this is for POJ online judge button 
         *  when we click here it create a Poj class and show user name input window
         */
        
        oj[3].setOnAction(e -> {
            
            if(th.isAlive())
            {
                try
                {
                    th.stop();
                }
                
                catch(Exception ex)
                {
                    
                }
            }
            
            list.clear();
            table.refresh();
            
            poj();
            judge_id = 3 ;
        });
        
        /**
         *  this is for Timus online judge button 
         *  when we click here it create a Timus class and show user name input window
         */
        
        oj[4].setOnAction(e -> {
            
            if(th.isAlive())
            {
                try
                {
                    th.stop();
                }
                
                catch(Exception ex)
                {
                    
                }
            }
            
            list.clear();
            table.refresh();
            
            timus();
            judge_id = 4 ;
        });
        
        /**
         * here we set scene in our stage
         */    
//        hb.setStyle("-fx-background: black;");
        
//        GridPane gd = new GridPane();
//        gd.getChildren().addAll(hb);
        Scene scn = new Scene(hb,700,450);
//        scn.getStylesheets().add("stylesheet/mainwindow.css");
        window.setResizable(false);
        window.setScene(scn);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    void uva()
    {
        us = user_name_input.getText() ;
        cp = compare_id_input.getText();
        Uva uv = new Uva();
        uv.us = us ;
        uv.cp = cp ;
        uv.check(0);
        
        uv.tsk.setOnSucceeded(event -> {
                
                uv.pb.window.close();
                
                if(uv.isk)
                    return ;
                
                if(uv.cds.is_valid == 1)
                {
                    uv.next_window(uv.cds.v1,uv.cds.v2);
                    
                    list.clear();
                    
                    int mx = max((int)uv.fv1.size(),(int)uv.fv2.size());
                    
                    String me , fnd , differ ,wait ;
                    
                    differn.clear();
                    
                    for(int i=0 ; i<mx ; i++)
                    {
                        me = "NULL" ;
                        fnd = "NULL" ;
                        differ = "NULL" ;
                        wait = "NULL" ;
                        
                        if(i<uv.fv1.size())
                            me = (String)uv.fv1.get(i);
                        
                        if(i<uv.fv2.size())
                            fnd = (String)uv.fv2.get(i);
                        
                        if(i<uv.fd.size()){
                            differ = (String)uv.fd.get(i);
                            differn.add(Integer.parseInt(differ));
                            wait = "wait" ;
                        }
                        list.add(new TableRow(me,fnd,differ,wait));
                    }
                    
                    table.refresh();
                    
                    th = new work();
                    th.start();
                }
                else if(uv.cds.is_valid == 0)
                {
                    Error er = new Error();
                    er.show();
                }
            });
    }
    
    void hdu()
    {
        us = user_name_input.getText() ;
        cp = compare_id_input.getText();
        Hdu uv = new Hdu();
        uv.us = us ;
        uv.cp = cp ;
        uv.check(1);
        
        uv.tsk.setOnSucceeded(event -> {
                
                uv.pb.window.close();
                
                if(uv.isk)
                    return ;
                
                if(uv.cds.is_valid == 1)
                {
                    uv.next_window(uv.cds.v1,uv.cds.v2);
                    
                    list.clear();
                    
                    int mx = max((int)uv.fv1.size(),(int)uv.fv2.size());
                    
                    String me , fnd , differ , wait ;
                    
                    differn.clear();
                    
                    for(int i=0 ; i<mx ; i++)
                    {
                        me = "NULL" ;
                        fnd = "NULL" ;
                        differ = "NULL" ;
                        wait = "NULL" ;
                        
                        
                        if(i<uv.fv1.size())
                            me = (String)uv.fv1.get(i);
                        
                        if(i<uv.fv2.size())
                            fnd = (String)uv.fv2.get(i);
                        
                        if(i<uv.fd.size()){
                            differ = (String)uv.fd.get(i);
                            differn.add(Integer.parseInt(differ));
                            wait = "wait";
                        }
                        
                        list.add(new TableRow(me,fnd,differ,wait));
                    }
                    
                    table.refresh();
                    
                    th = new work();
                    th.start();
                }
                else if(uv.cds.is_valid == 0)
                {
                    Error er = new Error();
                    er.show();
                }
            });
    }
    
    void codeforces()
    {
        us = user_name_input.getText() ;
        cp = compare_id_input.getText();
        Cf uv = new Cf();
        uv.us = us ;
        uv.cp = cp ;
        uv.check(2);
        
        uv.tsk.setOnSucceeded(event -> {
                
                uv.pb.window.close();
                
                if(uv.isk)
                    return ;
                
                if(uv.cds.is_valid == 1)
                {
                    uv.save_data(uv.cds.v3, uv.cds.v4);
                    uv.next_window(uv.cds.v1,uv.cds.v2);
                    
                    list.clear();
//                    System.out.println(uv.fd.size() + " " + uv.fpname.size());
                    int mx = max((int)uv.fv1.size(),(int)uv.fv2.size());
                    
                    String me , fnd , differ , wait ;
                    
                    for(int i=0 ; i<mx ; i++)
                    {
                        me = "NULL" ;
                        fnd = "NULL" ;
                        differ = "NULL" ;
                        wait = "NULL" ;
                        
                        if(i<uv.fv1.size())
                            me = (String)uv.fv1.get(i);
                        
                        if(i<uv.fv2.size())
                            fnd = (String)uv.fv2.get(i);
                        
                        if(i<uv.fd.size()){
                            differ = (String)uv.fd.get(i);
                            wait = (String)uv.fpname.get(i) ;
                        }
                        
                        list.add(new TableRow(me,fnd,differ,wait));
                    }
                    
                    table.refresh();
                }
                else if(uv.cds.is_valid == 0)
                {
                    Error er = new Error();
                    er.show();
                }
            });
    }
    
    void poj()
    {
        us = user_name_input.getText() ;
        cp = compare_id_input.getText();
        Poj uv = new Poj();
        uv.us = us ;
        uv.cp = cp ;
        uv.check(3);
        
        uv.tsk.setOnSucceeded(event -> {
                
                uv.pb.window.close();
                
                if(uv.isk)
                    return ;
                
                if(uv.cds.is_valid == 1)
                {
                    uv.next_window(uv.cds.v1,uv.cds.v2);
                    
                    list.clear();
                    
                    int mx = max((int)uv.fv1.size(),(int)uv.fv2.size());
                    
                    String me , fnd , differ , wait ;
                    
                    differn.clear();
                    
                    for(int i=0 ; i<mx ; i++)
                    {
                        me = "NULL" ;
                        fnd = "NULL" ;
                        differ = "NULL" ;
                        wait = "NULL" ;
                        
                        if(i<uv.fv1.size())
                            me = (String)uv.fv1.get(i);
                        
                        if(i<uv.fv2.size())
                            fnd = (String)uv.fv2.get(i);
                        
                        if(i<uv.fd.size()){
                            differ = (String)uv.fd.get(i);
                            differn.add(Integer.parseInt(differ));
                            wait = "wait";
                        }
                        list.add(new TableRow(me,fnd,differ,wait));
                    }
                    
                    table.refresh();
                    
                    th = new work();
                    th.start();
                }
                else if(uv.cds.is_valid == 0)
                {
                    Error er = new Error();
                    er.show();
                }
            });
    }
    
    void timus()
    {
        us = user_name_input.getText() ;
        cp = compare_id_input.getText();
        Timus uv = new Timus();
        uv.us = us ;
        uv.cp = cp ;
        uv.check(4);
        
        uv.tsk.setOnSucceeded(event -> {
                
                uv.pb.window.close();
                
                if(uv.isk)
                    return ;
                
                if(uv.cds.is_valid == 1)
                {
                    uv.next_window(uv.cds.v1,uv.cds.v2);
                    
                    list.clear();
                    
                    int mx = max((int)uv.fv1.size(),(int)uv.fv2.size());
                    
                    String me , fnd , differ , wait ;
                    
                    differn.clear();
                    
                    for(int i=0 ; i<mx ; i++)
                    {
                        me = "NULL" ;
                        fnd = "NULL" ;
                        differ = "NULL" ;
                        wait = "NULL" ;
                        
                        if(i<uv.fv1.size())
                            me = (String)uv.fv1.get(i);
                        
                        if(i<uv.fv2.size())
                            fnd = (String)uv.fv2.get(i);
                        
                        if(i<uv.fd.size()){
                            differ = (String)uv.fd.get(i);
                            differn.add(Integer.parseInt(differ));
                            wait = "wait" ;
                        }
                        
                        list.add(new TableRow(me,fnd,differ,wait));
                    }
                    
                    table.refresh();
                    
                    th = new work();
                    th.start();
                }
                else if(uv.cds.is_valid == 0)
                {
                    Error er = new Error();
                    er.show();
                }
            });
    }
    
    void uva_update()
    {
        int a ;
        String str ;
        System.out.println("uva update "+differn.size());
        for(int i=0 ; i<differn.size() ; i++)
        {
            a = (int)differn.get(i);
            Id_Uva tp = new Id_Uva(Integer.toString(a)) ;
            str = tp.get_name();
            list.get(i).setProblemName(str);
            table.refresh();
        }
    }
    
    void poj_update()
    {
        int a ;
        String str ;
        
        for(int i=0 ; i<differn.size() ; i++)
        {
            a = (int)differn.get(i);
            
            Id_Poj tp = new Id_Poj(Integer.toString(a)) ;
            str = tp.get_name();
            list.get(i).setProblemName(str);
            table.refresh();
        }
    }
    
    void hdu_update()
    {
        int a ;
        String str ;
        
        for(int i=0 ; i<differn.size() ; i++)
        {
            a = (int)differn.get(i);
            
            Id_Hdu tp = new Id_Hdu(Integer.toString(a)) ;
            str = tp.get_name();
            list.get(i).setProblemName(str);
            table.refresh();
        }
    }
    
    void timus_update()
    {
        int a ;
        String str ;
        
        for(int i=0 ; i<differn.size() ; i++)
        {
            a = (int)differn.get(i);
            
            Id_Timus tp = new Id_Timus(Integer.toString(a)) ;
            str = tp.get_name();
            list.get(i).setProblemName(str);
            table.refresh();
        }
    }
    
    Task task = new Task<Void>()
    {   
        @Override
        protected Void call() 
        {
            System.out.println("Task");
            try
            {
                if(judge_id == 0)
                    uva_update();
                
                else if(judge_id == 1)
                    hdu_update();
                
                else if(judge_id == 3)
                    poj_update();
                
                else
                    timus_update();
            }
            
            catch(Exception ex)
            {
                //  
            }
            
            return null ;
        } 
    };
    
    class work extends Thread
    {
        public void run()
        {
            if(judge_id == 0)
                uva_update();

            else if(judge_id == 1)
                hdu_update();

            else if(judge_id == 3)
                poj_update();

            else
                timus_update();
        }
    }
}
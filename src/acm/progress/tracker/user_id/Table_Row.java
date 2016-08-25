/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import javafx.beans.property.SimpleStringProperty;

/**
 * we create object of TableRow only for our tableview row .
 * @author RONIN-47
 */
public class Table_Row
{
        private final SimpleStringProperty Me ;
        private final SimpleStringProperty Friend ;
        private final SimpleStringProperty ProblemName ;
        
        public Table_Row(String Me,String Friend,String pn)
        {
            this.Me = new SimpleStringProperty(Me) ;
            this.Friend = new SimpleStringProperty(Friend) ;
            this.ProblemName = new SimpleStringProperty(pn);
        }
        
        public void setProblemName(String problem_name)
        {
            ProblemName.set(problem_name);
        }
        
        public void setMe(String _Me)
        {
            Me.set(_Me);
        }
        
        public void setFriend(String f)
        {
            Friend.set(f);
        }
        
        
        public String getProblemName()
        {
            return ProblemName.get();
        }
        
        public String getMe()
        {
            return Me.get();
        }
        
        public String getFriend()
        {
            return Friend.get();
        }
        
}
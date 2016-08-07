/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

/**
 *
 * @author RONIN-47
 */

import java.util.* ;
import java.lang.* ;

public class Calculation 
{
    ArrayList user1 = new ArrayList();
    ArrayList user2 = new ArrayList();
    public ArrayList difference_with_second = new ArrayList();

    public Calculation(ArrayList user1,ArrayList user2) 
    {
        this.user1 = user1 ;
        this.user2 = user2 ;
    }
    
    public void make_difference()
    {
        Collections.sort(user1);
        Collections.sort(user2);
        
        int i=0 , j = 0 ;
        
        for(;i<user2.size(); i++)
        {
            while(j<user1.size() && (int)user2.get(i) > (int)user1.get(j))
                j++;
            
            if(j>=user1.size())
            {
                difference_with_second.add(user2.get(i));
                continue ;
            }
            
            if(j<user1.size() && (int)user2.get(i) != (int)user1.get(j))
                difference_with_second.add(user2.get(i));
        }
    }
}

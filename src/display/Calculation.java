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

/**
 * it finds differences between first and second user
 * @author RONIN-47
 */
public class Calculation 
{
    ArrayList user1 = new ArrayList();
    ArrayList user2 = new ArrayList();

    /**
     *  difference will keep in this list 
     */
    public ArrayList difference_with_second = new ArrayList();

    /**
     *
     * @param user1 solved list of user1
     * @param user2 solved list of user2
     */
    public Calculation(ArrayList user1,ArrayList user2) 
    {
        this.user1 = user1 ;
        this.user2 = user2 ;
    }
    
    /**
     *  create difference 
     */
    public void make_difference()
    {
        Collections.sort(user1);
        Collections.sort(user2);
        
        int a ;
        
        for(int i=0 ; i<user1.size() ; i++)
            difference_with_second.add(user1.get(i));
        
        
        for(int i=0  ; i<user2.size() ; i++)
        {
            a = (int)user2.get(i);
            
            if(!difference_with_second.contains(a))
                difference_with_second.add(a);
        }
    }
}

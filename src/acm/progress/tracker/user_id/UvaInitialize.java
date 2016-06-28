/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.io.* ;
import java.util.* ;

/**
 *
 * @author RONIN-47
 */
public class UvaInitialize
{
    public Map <Integer,Integer> mymap = new HashMap<Integer, Integer>() ;
    
    void input() throws Exception
    {
        Scanner cin = new Scanner(new File("pre_data/data.txt"));
        int a = 0 , b = 0 , cont = 0 ;
        
        while(cin.hasNextInt())
        {
            b = cin.nextInt();
            
            if((int)(cont&1) != 0)
            {
                mymap.put(a, b);
            }
            
            else
                a = b ;
            
            cont++;
        }
    }
}

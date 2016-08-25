/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.* ;

/**
 *  convert user name to id  
 * @author RONIN-47
 */
public class Uva_id 
{
    String get_id(String name)
    {
        int id = 0 ;
        
        try
        {
            URL ur = new URL("http://uhunt.felix-halim.net/api/uname2uid/"+name);
            InputStreamReader is = new InputStreamReader(ur.openStream());
            BufferedReader bf = new BufferedReader(is);
            
            String line = bf.readLine();
            
           return line;
        }
        
        catch(Exception ex)
        {
            return null ;
        }
    }
}

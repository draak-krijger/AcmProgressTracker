/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *  collect problem name from poj 
 * @author RONIN-47
 */
public class Id_Poj 
{
    String ur = "http://poj.org/problem?id=" , problem_id , name = "Failed" , tstr ;
    boolean ok1 = false , ok2 = false ;
    
    URL tm ;
    InputStreamReader is ;
    BufferedReader bf ;
     
    /**
     *
     * @param problem_id id number of problem which we want
     */
    public Id_Poj(String problem_id)
    {
        this.problem_id = problem_id ;
    }
     
    /**
     *
     * @return problem name 
     */
    public String get_name()
    {
        tstr = "" ;
        try
        {
            tm = new URL(ur+problem_id);
            is = new InputStreamReader(tm.openStream());
        }
        
        catch(Exception ex)
        {
            return name ;
        }
        
        bf = new BufferedReader(is);
        
        try
        {
            String line ;
            int len ;
            
            while((line = bf.readLine()) != null)
            {
                len = line.length();
                
                for(int i=0 ; i<len ; i++)
                {
                    tstr += line.charAt(i);
                    
                    if(ok1)
                    {
                        if(ok2)
                        {
                            if(line.charAt(i) == '<' && line.charAt(i+1) == '/')
                                return name ;
                            
                            name += line.charAt(i);
                        }
                        
                        else if(line.charAt(i) == '-' && line.charAt(i-1) == '-')
                        {
                            ok2 = true ;
                            name = "" ;
                        }
                    }
                    
                    else
                    {
                        if(tstr.length() > 5)
                            tstr = tstr.substring(1);
                        
                        if(tstr.equals("title"))
                            ok1 = true ;
                    }
                }
            }
            return name ;
        }
        
        catch(Exception ex)
        {
            return name ;
        }
    }
}

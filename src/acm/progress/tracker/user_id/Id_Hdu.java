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
 * this class is for collecting problem name from judge 
 * @author RONIN-47
 */
public class Id_Hdu 
{
    String ur = "http://acm.split.hdu.edu.cn/showproblem.php?pid=" , problem_id , name = "Failed" , tstr ;
    boolean ok1 = false , ok2 = false ;
    
    URL tm ;
    InputStreamReader is ;
    BufferedReader bf ;
     
    /**
     *
     * @param problem_id means id number of problem
     */
    public Id_Hdu(String problem_id)
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
                            if(line.charAt(i) == '<')
                                return name ;
                            
                            name += line.charAt(i);
                        }
                        
                        else if(line.charAt(i) == '>')
                        {
                            ok2 = true ;
                            name = "" ;
                        }
                    }
                    
                    else
                    {
                        if(tstr.length() > 2)
                            tstr = tstr.substring(1);
                        
                        if(tstr.equals("h1"))
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

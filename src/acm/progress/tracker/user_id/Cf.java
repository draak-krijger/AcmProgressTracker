/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import display.*;
import java.util.* ;
import java.net.* ;
import java.io.* ;

/**
 *
 * @author RONIN-47
 */
public class Cf extends Input
{
    String ur = "http://codeforces.com/api/user.status?handle=" , ur2 = "&from=1&count=100000" , pat = "\"problem\":{\"contestId\":" , pat2 = "\"verdict\":\"" ;
    String c_p1 , c_p2 , c_p3 ;
    URL tm  ;
    InputStreamReader is ;
    BufferedReader bf  ;
    boolean fok = false , tok = false , tok1 = false , tok2 = false , num_ok = false ;
    
    ArrayList v1 = new ArrayList() , v2 = new ArrayList();
    
    @Override
    boolean is_valid(String str) 
    {
        tok = tok1 = tok2 = num_ok = false ;
        
        c_p1 = "" ;
        c_p2 = "" ;
        c_p3 = "" ;
        
        try
        {
            tm = new URL(ur+str+ur2);
            is = new InputStreamReader(tm.openStream());
        }
        
        catch(Exception ex)
        {
            return false ;
        }
        
        bf = new BufferedReader(is);
        String line ;
        
        try
        {
            int len , num = 0  ;
            boolean kk = true ;
            
            while((line = bf.readLine()) != null)
            {
                if(kk)
                {
                    if(line.charAt(12) != 'K')
                        return false ;
                    
                    kk = false ;
                }
                
                len = line.length() ;
                
                for(int i=0 ; i<len ; i++)
                {
                    if(tok)
                    {
                        c_p1 += line.charAt(i) ;
                        
                        if(c_p1.length() > 2)
                        {
                            tok = false ;
                            tok2 = false ;
                            tok1 = false ;
                            c_p3 = "" ;
                        }
                        
                        if(c_p1.equals("OK"))
                        {
                            if(fok)
                            {
                                if(!v2.contains(num))
                                    v2.add(num);
                            }
                            
                            else
                            {
                                if(!v1.contains(num))
                                    v1.add(num);
                            }
                        }
                    }
                    
                    else if(tok1)
                    {
                        c_p2 += line.charAt(i) ;
                        
                        if(c_p2.length() > pat2.length())
                            c_p2 = c_p2.substring(1);
                        
                        if(c_p2.equals(pat2))
                        {
                            c_p1 = "";
                            tok = true ;
                        }
                    }
                    
                    else if(tok2)
                    {
                        if(num_ok)
                        {
                            if(line.charAt(i) >= 'A' && line.charAt(i) <= 'Z')
                            {
                                num = num*10 + (line.charAt(i) - 'A') ;
                                c_p2 = "" ;
                                tok1 = true ;
                            }
                        }
                        
                        else
                        {
                            if(line.charAt(i) >= '0' && line.charAt(i) <= '9')
                                num = num*10 + (line.charAt(i) - '0');
                            
                            else if(num>0)
                                num_ok = true ;
                        }
                    }
                    
                    else
                    {
                        c_p3 += line.charAt(i) ;
                        
                        if(c_p3.length() > pat.length())
                            c_p3 = c_p3.substring(1);
                        
                        if(c_p3.equals(pat))
                        {
                            tok2 =true ;
                            num_ok = false ;
                            num = 0 ;
                        }
                    }
                }
            }
        }
        
        catch(Exception ex)
        {
            return false ;
        }
        
        fok = true ;
        return true ;
    }

    @Override
    void next_window() 
    {
        ShowDifference diff = new ShowDifference(v1, v2);
        diff.find_differences();
        diff.show(true);
    }
}

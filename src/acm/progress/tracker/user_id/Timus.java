/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.io.*;
import java.net.*;
import java.lang.* ;
import java.util.* ;
import display.* ;

/**
 *
 * @author RONIN-47
 */
public class Timus extends Inputforid
{
    String ur = "http://acm.timus.ru/author.aspx?id=" ;
    String pat1 = "author.aspx?id=" , cal_pat_1 = null , id1 = null , id2 = "Author not found" , cal_pt = null ;
    boolean fok = false ;
    URL tm ;
    InputStreamReader is;
    
    ArrayList v1 = new ArrayList() , v2 = new ArrayList();
    
    @Override
    boolean is_valid(String str)
    {
        pat1 = "CLASS=\"accepted\"" ;
        String pat2 = "num=" ;
        int num = 0 ;
        cal_pat_1 = "" ;
        cal_pt = "" ;
        id1 = "" ;
        boolean tok = false , tok2 = false ;
        
        try
        {
            tm = new URL(ur+str);
		
            is = new InputStreamReader(tm.openStream()); 
        }
    
        catch(Exception ex)
        {
            return false ;
        }
    
        BufferedReader bf = new BufferedReader(is);
		
        String line ;
        
        try
        {
            while((line = bf.readLine()) != null)
            {
                int len = line.length();
                
                for(int i=0 ; i<len ; i++)
                {
                    cal_pt += line.charAt(i);
                    id1 += line.charAt(i);
                    
                    if(id1.length() > id2.length())
                        id1 = id1.substring(1);
                    
                    if(id1.equals(id2))
                        return false ;
                    
                    if(cal_pt.length() > pat1.length())
                        cal_pt = cal_pt.substring(1);
                    
                    if(tok)
                    {
                        cal_pat_1 += line.charAt(i);
                        
                        if(cal_pat_1.length() > pat2.length())
                            cal_pat_1 = cal_pat_1.substring(1);
                        
                        if(tok2)
                        {
                            if(line.charAt(i) >= '0' && line.charAt(i) <= '9')
                                num = num*10 + (line.charAt(i) - '0');
                            
                            else
                            {
                                tok2 = false ;
                                tok = false ;
                                
                                if(fok && num>0)
                                    v2.add(num);
                                
                                else if(num > 0)
                                    v1.add(num);
                            }
                        }
                        
                        if(cal_pat_1.equals(pat2))
                        {
                            tok2 = true ;
                            num = 0 ;
                        }
                    }
                    
                    else if(cal_pt.equals(pat1))
                    {
                        cal_pat_1 = "";
                        tok = true ;
                        tok2 = false ;
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
        diff.show(false);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import display.* ;
import java.net.* ;
import java.io.* ;
import java.util.* ;

/**
 *
 * @author RONIN-47
 */
public class Hdu extends Input
{
    String ur = "http://acm.hdu.edu.cn/userstatus.php?user=" , pat = "No such user" , cal_pat , pt2 = "unsolved" , cal_pt2 ;
    URL tm  ;
    InputStreamReader is ;
    BufferedReader bf , id1 , id2 ;
    boolean fok = false , tok = true ;
    
    ArrayList v1 = new ArrayList() , v2 = new ArrayList();
    
    @Override
    boolean is_valid(String str) 
    {
        cal_pat = "" ;
        cal_pt2 = "" ;
        tok = true ;
        
        try
        {
            tm = new URL(ur+str);
            is = new InputStreamReader(tm.openStream());
        }
        
        catch(Exception ex)
        {
            return false ;
        }
        
        bf = new BufferedReader(is);
        boolean kk = false ;
        
        String line ;
        
        try
        {
            int ln ;
            int num = 0;
            
            while((line = bf.readLine()) != null)
            {
                int len = line.length();
                
                for(int i=0 ; i<len ; i++)
                {
                    cal_pat += line.charAt(i);
                    cal_pt2 += line.charAt(i);
                    
                    if(cal_pt2.length() > pt2.length())
                        cal_pt2 = cal_pt2.substring(1);
                    
                    if(cal_pt2.equals(pt2))
                        tok = false ;
                    
                    ln = cal_pt2.length();
                    
                    if(tok && ln>3)
                    {
                        if(cal_pt2.charAt(ln-1) == '(' && cal_pt2.charAt(ln-2) == 'p')
                        {
                            kk = true ;
                            num = 0 ;
                        }
                        
                        else if(kk)
                        {
                            if(line.charAt(i) >= '0' && line.charAt(i) <= '9')
                                num = num*10 +  (line.charAt(i) - '0');
                            
                            else
                            {
                                if(fok && num>0)
                                    v2.add(num) ;
                                
                                    else if(num>0)
                                    v1.add(num) ;

                                kk = false ;
                            }
                        }
                    }
                    
                    if(cal_pat.length() > pat.length())
                        cal_pat = cal_pat.substring(1);
                    
                    if(cal_pat.equals(pat))
                    {
                        return false ;
                    }
                }
            }
        }
        
        catch(Exception ex)
        {
            //System.out.println("PASS "+str);
            return false ;
        }
        
//        if(fok)
//            id2 = new BufferedReader(is);
//            
//        else
//            id1 = new BufferedReader(is);
            
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

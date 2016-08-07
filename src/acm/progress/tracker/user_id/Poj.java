/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;
import display.*;
import java.net.* ;
import java.io.* ;
import java.util.* ;

/**
 *
 * @author RONIN-47
 */
public class Poj extends Input
{
    String ur = "http://poj.org/userstatus?user_id=" , pat = "doesn't exist" , cal_pat ;
    URL tm  ;
    InputStreamReader is ;
    BufferedReader bf , id1 , id2 ;
    boolean fok = false , tok = true ;
    
    public ArrayList v1 = new ArrayList() , v2 = new ArrayList();
    
    @Override
    public boolean is_valid(String str) 
    {
        cal_pat = "" ;
        tok = false ;
        
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
                    
                    if(cal_pat.length() > pat.length())
                        cal_pat = cal_pat.substring(1);
                    
                    if(cal_pat.equals(pat))
                    {
                        return false ;
                    }
                    
                    ln = cal_pat.length();
                    
                    if(ln>3)
                    {
                        if(cal_pat.charAt(ln-1) == '(' && cal_pat.charAt(ln-2) == 'p')
                        {
                            if(tok)
                                kk = true ;
                            
                            tok = true ;
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
                }
            }
        }
        
        catch(Exception ex)
        {
            //System.out.println("PASS "+str);
            return false ;
        }
            
        fok = true ;
        
        return true ;
    }
    @Override
    public void next_window(ArrayList v1,ArrayList v2) 
    {
        ShowDifference diff = new ShowDifference(v1, v2);
        diff.find_differences();
        dif = diff.list.difference_with_second ;
        
        int a , ch ;
        String nm ;
        
        for(int i=0 ; i<v1.size() ; i++)
        {
            a = (int)v1.get(i);
            nm = Integer.toString(a);
            fv1.add(nm);
        }
        
        for(int i=0 ; i<v2.size() ; i++)
        {
            a = (int)v2.get(i);
            nm = Integer.toString(a);
            fv2.add(nm);
        }
        
        for(int i=0 ; i<dif.size() ; i++)
        {
            a = (int)dif.get(i);
            nm = Integer.toString(a);
            fd.add(nm);
        }
    }
    
}

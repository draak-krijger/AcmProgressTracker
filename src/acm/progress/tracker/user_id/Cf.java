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
    String c_p1 , c_p2 , c_p3 , name , problem_name ;
    URL tm  ;
    InputStreamReader is ;
    BufferedReader bf  ;
    boolean fok = false , tok = false , tok1 = false , tok2 = false , num_ok = false , bln1 = true , bln2 = false , bln3 = false ;
    
    public ArrayList v1 = new ArrayList() ,

    /**
     * user2 solved list
     */
    v2 = new ArrayList() ,

    /**
     *  problem name with repetition 
     */
    pname = new ArrayList() ,

    /**
     * difference 
     */
    drf = new ArrayList() ,

    /**
     *  final problem name without repetition
     */
    fpname = new ArrayList();
    
    /**
     *
     * @param str is user name which we check
     * @return is it exist ? 
     * if exist then it collect solve list of this user
     */
    @Override
    public boolean is_valid(String str) 
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
//                    if(fok)
//                    {
                        if(bln1)
                        {
                            name += line.charAt(i) ;
                            
                            if(name.length() >= 4)
                            {
                                if(name.length() > 4)
                                    name = name.substring(1);
                                
                                if(bln2)
                                {    
                                    if(bln3)
                                    {
                                        if(line.charAt(i) == '"' && line.charAt(i+1) == ',')
                                        {
                                            bln1 = false ;
                                            bln2 = false ;
                                            bln3 = false ;
                                        }
                                        
                                        else
                                            problem_name += line.charAt(i);
                                    }
                                    
                                    else if((line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') || (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') )
                                    {
                                        problem_name += line.charAt(i) ;
                                        bln3 = true ;
                                    }
                                }
                                
                                else if(name.equals("name"))
                                {
                                    bln2 = true ;
                                    problem_name = "" ;
                                } 
                            }
                        }
//                    }
                    
                    if(tok)
                    {
                        c_p1 += line.charAt(i) ;
                        
                        if(c_p1.length() > 2)
                        {
                            tok = false ;
                            tok2 = false ;
                            tok1 = false ;
                            c_p3 = "" ;
                            bln1 = true ;
                        }
                        
                        if(c_p1.equals("OK"))
                        {
                            if(fok)
                            {
                                bln1 = true ;
                                
                                if(!v2.contains(num)){
                                    v2.add(num);
                                }

                                if(!drf.contains(num))
                                {
                                    drf.add(num);
                                    pname.add(problem_name);
                                }
                            }
                            
                            else
                            {
                                if(!v1.contains(num)){
                                    v1.add(num);
                                    drf.add(num);
                                    pname.add(problem_name);
                                }
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
    
    /**
     *
     * @param v1 difference 
     * @param v2 problem name
     */
    public void save_data(ArrayList v1,ArrayList v2)
    {
        drf = v1 ;
        pname = v2 ;
    }

    /**
     *
     * @param v1 user1 solved list
     * @param v2 user2 solved list
     */
    @Override
    public void next_window(ArrayList v1,ArrayList v2) 
    {
        dif = drf ;
        
        Collections.sort(v1);
        Collections.sort(v2);
        
        int a , ch ;
        
        String str ;

        for(int i=0 ; i<dif.size() ; i++)
        {
            a = (int)dif.get(i);
            
            if(i>0 && (int)dif.get(i) == (int)dif.get(i-1))
                continue ;
            
            fpname.add(pname.get(i));
            //System.out.println(valu);
            ch = a%10 ;
            a /= 10 ;
            str = Integer.toString(a);
            str += "-" ;
            str += Character.toString((char) ('A'+ch));
            //System.out.println(str);
            fd.add(str);
        }
        
        for(int i=0 ; i<v1.size() ; i++)
        {
            a = (int)v1.get(i);
            
            if(i>0 && (int)v1.get(i) == (int)v1.get(i-1))
                continue ;
            
            //System.out.println(valu);
            ch = a%10 ;
            a /= 10 ;
            str = Integer.toString(a);
            str += "-" ;
            str += Character.toString((char) ('A'+ch));
            //System.out.println(str);
            fv1.add(str);
        }
        
        for(int i=0 ; i<v2.size() ; i++)
        {
            a = (int)v2.get(i);
            
            if(i>0 && (int)v2.get(i) == (int)v2.get(i-1))
                continue ;
            
            //System.out.println(valu);
            ch = a%10 ;
            a /= 10 ;
            str = Integer.toString(a);
            str += "-" ;
            str += Character.toString((char) ('A'+ch));
            //System.out.println(str);
            fv2.add(str);
        }
    }
}

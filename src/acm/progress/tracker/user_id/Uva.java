/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.util.* ;
import java.io.* ;
import java.lang.* ;
import display.* ;

/**
 *
 * @author RONIN-47
 */
public class Uva extends Input
{
    public ArrayList v1 = new ArrayList() , v2 = new ArrayList();
    boolean fok = false ;
    
    UvaInitialize mp ; 
    
    {
        mp = new UvaInitialize();
        
        try
        {
            mp.input();
        }
        
        catch(Exception ex)
        {
            Error er = new Error();
                er.show();
        }
    }
    
    @Override
    boolean is_valid(String str) 
    {
        Uva_id id_col = new Uva_id();
        
        String id = id_col.get_id(str);
        //System.out.println(id);
        if("0".equals(id))
            return false ;
        
        UvaSolvedProblem solved = new UvaSolvedProblem(mp.mymap);
        
        if(!solved.generate_arr(id))
            return false ;
        
        if(fok)
            v2 = solved.arr ;
        
        else
            v1 = solved.arr ;
        
        fok = true ;
        
        return true ;
    }

    @Override
    public void next_window(ArrayList v1,ArrayList v2) 
    {
        ShowDifference diff = new ShowDifference(v1, v2);
        diff.find_differences();
        dif = diff.list.difference_with_second ;
//        System.out.println(v1.size()+" "+v2.size());
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
//        System.out.println(fv1.size()+" "+fv2.size()+" "+fd.size());
    }
    
}

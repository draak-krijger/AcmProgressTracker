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
    ArrayList v1 = new ArrayList() , v2 = new ArrayList();
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
    void next_window(ArrayList v1,ArrayList v2) 
    {//System.out.println("ok");
        ShowDifference diff = new ShowDifference(v1, v2);
        diff.find_differences();
        diff.show(false);
    }
    
}

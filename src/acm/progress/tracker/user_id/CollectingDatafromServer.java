/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.util.*;

/**
 *  its collect data from online judge
 * @author RONIN-47
 */
public class CollectingDatafromServer extends Thread
{
    public int judge = 0 ,

    /**
     * is_valid is for checking validity
     * us means user1 user name 
     * cp means user2 user name 
     */
            
    is_valid = 0 ;
    String us , cp ;

    /**
     *  
     */
    public ArrayList v1 = new ArrayList() ;

    /**
     *
     */
    public ArrayList v2 = new ArrayList() ;

    /**
     *
     */
    public ArrayList v3 = new ArrayList() ;

    /**
     *
     */
    public ArrayList v4 = new ArrayList();

    /**
     *
     * @param judge judge id 
     * @param us user1 user name
     * @param cp user2 user name
     */
    public CollectingDatafromServer(int judge,String us,String cp) 
    {
        this.judge = judge ;
        this.us = us ;
        this.cp = cp ;
    }
    
    @Override
    public void run()
    {
        if(judge == 0)
        {
            Uva uv = new Uva();
            
            if(uv.is_valid(us))
            {
                if(uv.is_valid(cp))
                {
                    v1 = uv.v1 ;
                    v2 = uv.v2 ;
                    is_valid = 1 ;
                }
            }
        }
        
        else if(judge == 1)
        {
            Hdu hd = new Hdu();
            
            if(hd.is_valid(us))
            {
                if(hd.is_valid(cp))
                {
                    v1 = hd.v1 ;
                    v2 = hd.v2 ;
                    is_valid = 1 ;
                }
            }
        }
        
        else if(judge == 2)
        {
            Cf cdf = new Cf() ;
        
            if(cdf.is_valid(us))
            {
                if(cdf.is_valid(cp))
                {
                    v1 = cdf.v1 ;
                    v2 = cdf.v2 ;
                    v3 = cdf.drf ;
                    v4 = cdf.pname ;
                    is_valid = 1 ;
                }
            }
        }
        
        else if(judge == 3)
        {
            Poj pj = new Poj();
            
            if(pj.is_valid(us))
            {
                if(pj.is_valid(cp))
                {
                    v1 = pj.v1 ;
                    v2 = pj.v2 ;
                    is_valid = 1 ;
                }
            }
        }
        
        else if(judge == 4)
        {
            Timus tm = new Timus();
            
            if(tm.is_valid(us))
            {
                if(tm.is_valid(cp))
                {
                    v1 = tm.v1 ;
                    v2 = tm.v2 ;
                    is_valid = 1 ;
                }
            }
        }
    }
}

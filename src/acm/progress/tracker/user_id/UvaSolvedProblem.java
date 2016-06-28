/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.lang.* ;
import java.io.* ;
import java.util.* ;
import java.net.* ;

/**
 *
 * @author RONIN-47
 */
public class UvaSolvedProblem 
{
    Map<Integer,Integer> mymap = new HashMap<Integer,Integer>();
    
    public UvaSolvedProblem(Map<Integer,Integer> mp)
    {
        mymap = mp ;
    }
    
    ArrayList arr = new ArrayList() ;
    
    boolean generate_arr(String id)
    {
        try
        {
            URL ur = new URL("http://uhunt.felix-halim.net/api/solved-bits/"+id);
            InputStreamReader is = new InputStreamReader(ur.openStream());
            BufferedReader bf = new BufferedReader(is);
            long num = 0 , len , cont = 0 , k = 0 ;
            int temp ;
            boolean ok = false ;
            String str , binary ;
            
            while((str = bf.readLine()) != null)
            {
                len = str.length();
                
                for(int i=0 ; i<len ; i++)
                {
                    if(cont>1)
                    {
                        if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
                            num = num*10 + (str.charAt(i) - '0');
                        
                        else
                        {
                            binary = Long.toString(num,2);
                            
                            int lg = binary.length();
                            
                            int p = 0 ;
                            for(int j=lg-1 ; j>=0 ; j--)
                            {
                                if(binary.charAt(j) == '1')
                                {
                                    temp = (int)(k+p);
                                    arr.add(mymap.get(temp));
                                }
                                
                                p++;
                            }
                            num = 0 ;
                            k += 32 ;
                        }
                    }
                    
                    else if(str.charAt(i) == '[')
                        cont++;
                }
            }
            
            return true ;
        }
        
        catch(Exception ex)
        {
            return false ;
        }
    }
}

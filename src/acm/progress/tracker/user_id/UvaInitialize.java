/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm.progress.tracker.user_id;

import java.io.* ;
import java.util.* ;

/**
 *  maping with problem id and problem number 
 * @author RONIN-47
 */
public class UvaInitialize
{

    /**
     * problem number with problem id 
     */
    public Map <Integer,Integer> mymap = new HashMap<Integer, Integer>() ;
    
    void input() throws Exception
    {
        InputStream in = getClass().getResourceAsStream("/data.txt");
        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        //Scanner cin = new Scanner(new File("resources/data.txt"));
        int a = 0 , b = 0 , cont = 0 , tp ;
        
        String line ;
        int len ;
        
        while((line = input.readLine()) != null)
        {
            line += " " ;
            len = line.length() ;

            b = 0 ;
            a = 0 ;
            cont = 0 ;

            for(int i=0 ;len-1>0 && i<len ; i++)
            {
                if(line.charAt(i) == ' ')
                {
                    if(a>0 && b>0)
                    {
                        mymap.put(a, b);
                        a = 0 ;
                        b = 0 ;
                        continue;
                    }
                    
                    if(a>0)
                        cont++;
                }
                
                if((int)(cont&1) != 0 && line.charAt(i) != ' ')
                {
                    tp = (int)(line.charAt(i) - '0') ;
                    b = b*10 + tp ;
                }
                
                else if(line.charAt(i) != ' ')
                {
                    tp = (int)(line.charAt(i) - '0') ;
                    a = a*10 + tp ;
                }    
            }
        }
        
//        while(cin.hasNextInt())
//        {
//            b = cin.nextInt();
//            
//            if((int)(cont&1) != 0)
//            {
//                mymap.put(a, b);
//            }
//            
//            else
//                a = b ;
//            
//            cont++;
//        }
    }
}

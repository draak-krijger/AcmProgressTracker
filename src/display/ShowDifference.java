/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import java.util.ArrayList;

/**
 * this class find differences 
 * @author RONIN-47
 */
public class ShowDifference 
{
    ArrayList user = new ArrayList() , compare_with = new ArrayList() , difference ;

    /**
     * 
     */
    public Calculation list ;
    
    /**
     *
     * @param user user1 solved list
     * @param compre_with user2 solved list
     */
    public ShowDifference(ArrayList user , ArrayList compre_with)
    {
        this.user = user ;
        this.compare_with = compre_with ;
    }
    
    /**
     * it create calculation object and call make_difference 
     */
    public void find_differences()
    {
        list = new Calculation(user, compare_with);
        list.make_difference();
    }
    
    /**
     *
     * @param flag
     */
    public void show(boolean flag)
    {
        ShowWindow ob1 = new ShowWindow(list.user1, list.user2, list.difference_with_second);
        
        ob1.show(flag);
    }
}

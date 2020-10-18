package com.fusioncharts.util;

public class ValidateAttributes 
{
	
	public static boolean isANumber(String numberString)
	{
		try 
        { 
            Integer.parseInt(numberString); 
            return true; 
        }  
        catch (NumberFormatException e)  
        { 
            return false;
        } 
	}

}

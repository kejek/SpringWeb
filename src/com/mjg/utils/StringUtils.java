package com.mjg.utils;

public final class StringUtils {
	public static int[] StringArrayToIntArray(String[] array) throws NumberFormatException{
		int[] ints = new int[array.length];
		for(int i=0; i<array.length; i++)
		{
		   
		        ints[i] = Integer.parseInt(array[i]);           
		   
		}
		return ints;
	}
}

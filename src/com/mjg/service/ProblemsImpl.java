package com.mjg.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
@Service("Problems")
public class ProblemsImpl implements Problems {

	@Override
	public int SumItUp(int[] array) throws Exception {
		int size = array.length;
		int max = array[size-1];		
		double a = 0;
		int b = 0;
		
		a = size *(size-1)/2;
		if(a % 1 == 0){
			//a is a whole number
			b = Arrays.stream(array).sum();
			return (int) (b-a);
		}
		else{
			throw  new Exception();
		}
	}

}

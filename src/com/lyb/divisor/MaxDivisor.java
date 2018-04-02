package com.lyb.divisor;


public class MaxDivisor { 
	public static void main(String[] args) {  
		int num1 = 32652;
		int num2 = 28116;
//		int maxMultiple = calcMaxSubmultiple(num1, num2);  
//		System.out.println(maxMultiple);
		
		getAllDivisor(28116);
	} 
	
	/**
	 * 求两个数的最大公约数
	 * */
	private static int calcMaxSubmultiple(int num1, int num2) {    
		int min = Math.min(num1, num2);    
		int maxSubmultiple = 1;    
		for(int i = min; i >= 1; i--){
			{   
				if(num1 % i == 0 && num2 % i == 0){    
					maxSubmultiple = i;    
					break;   
				}  
			}    
		}    
		return maxSubmultiple; 
	}
	
	/**
	 * 求一个数的所有约数
	 * */
	public static void getAllDivisor(int a){
		for(int i=1; i<a; i++){
			if(a%i==0){
				System.out.print(i+" ");
			}
		}
	}
}
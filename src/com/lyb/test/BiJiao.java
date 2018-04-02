package com.lyb.test;

public class BiJiao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 11;
		int b = 11;
		if(a==b){
			System.out.println(" a == b");
		}else{
			System.out.println(" a != b");
		}
		
		Customer Customer1 = new Customer();
		Customer1.setUsername("liyubo");
		Customer1.setPassword("liyubo0000");
		Customer Customer2 = new Customer();
		Customer2.setUsername("liyubo");
		Customer2.setPassword("liyubo0000");
		
		if(Customer1==Customer2){
			System.out.println(" Customer1 == Customer2");
		}else{
			System.out.println(" Customer1 != Customer2");
		}
		
		if(Customer1.equals(Customer2)){
			System.out.println(" Customer1 equals Customer2");
		}else{
			System.out.println(" Customer1 not equals Customer2");
		}
		
		String str1 = new String("liyubo");
		String str2 = new String("liyubo");
		
		if(str1 == str2){
			System.out.println(" str1 == str2");
		}else{
			System.out.println(" str1 != str2");
		}
		
		
		if(str1.equals(str2)){
			System.out.println(" str1 equals str2");
		}else{
			System.out.println(" str1 not equals str2");
		}
	}
}

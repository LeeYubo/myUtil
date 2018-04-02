package com.lyb.examples;

public class Joseph {

	public static int peoplesNumber=5;
	public static int countNumber=4;
	
	public static void throwHandChife(){
		int [] arrays = new int [peoplesNumber];
		System.out.println("数组的长度==="+arrays.length);
		for(int i=1;i<=peoplesNumber;i++){
			arrays[i-1] = i;
		}
		for(int i=1;i<=peoplesNumber;i++){
			System.out.println("array["+i+"]="+arrays[i-1]);
		}
		
		int [] arrays2 = arrays;
		System.out.println("数组二的长度="+arrays2.length);
		
		System.out.println("A000001");
//		while(arrays.length>1){
			for(int j=0;j<peoplesNumber;j++){
				if((j+1)%countNumber==0){
					arrays[j]=arrays[j+1];
				}
			}
		//}
		System.out.println("A000002");
		for(int i=1;i<arrays.length;i++){
			System.out.println("array["+i+"]="+arrays[i]);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Joseph.throwHandChife();
	}

}

package com.lyb.random;

import java.util.Random;

public class RandomMain {

	public static void main(String[] args) {
//		System.out.println(getRandomByInterval(11,22));
		System.out.println(Math.random());
		Random random = new Random(47);
		System.out.println("Random.class = "+Random.class);
		System.out.println("random.getClass() = "+random.getClass());
		for(int i=0;i<10;i++){
			System.out.println("random = "+random.nextInt());
		}
	}
	
	/**
	 * 根据给定的最大值和最小值，取之间的随机数
	 * @param max
	 * @param min
	 * @return
	 */
	public static int getRandomByInterval(int max, int min){
		return (int)(Math.random()*(max-min+1)+min);
	}
}

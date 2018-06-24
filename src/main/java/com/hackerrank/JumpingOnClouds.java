package com.hackerrank;

public class JumpingOnClouds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] clouds = {0, 0, 1, 0, 0, 1, 1, 0};
		
		System.out.println(jumpingOnClouds(clouds, 2));
	}
	
	static int jumpingOnClouds(int[] c, int k) {
        int pos=0;
        int energy = 100;
        do{
           pos = (pos+k)%c.length;
           System.out.println("pos: " + pos);
            if(c[pos]==1){
                energy -= 3;
            }else {
                energy -= 1;
            }
        }while(pos!=0);
        return energy;

    }

}

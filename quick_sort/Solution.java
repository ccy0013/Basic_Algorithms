/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Sep 15 14:50:14 2015
 ************************************************************************/

import java.util.Arrays;

public class Solution{

	public static void quickSort( int[] nums ){
		quickSortHelper( nums, 0, nums.length-1 );
	}

	public static void quickSortHelper( int[] nums, int start, int end ){

		if( start >= end )
			return;

		int i=start, j=end, key=start;

		while( i<=j ){
			if( j>=key ){
				if( nums[j] <= nums[key] ){
					switchTwoNumsInArray( nums, key, j );
					key = j--;
				}
				else
					j--;
			}

			if( i<=key ){
				if( nums[i] > nums[key] ){
					switchTwoNumsInArray( nums, i, key );
					key = i++;
				}
				else
					i++;
			}
		}

		//if( j>key && nums[j]<=nums[key )
			

		quickSortHelper( nums, start, key-1 );
		quickSortHelper( nums, key+1, end );
	}

	public static void switchTwoNumsInArray( int[] nums, int a, int b ){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args){
		int[] nums = {3, 5, 9, -1, 5, 2, 8, 1};

		System.out.println( Arrays.toString(nums) );
		quickSort(nums);
		System.out.println( Arrays.toString(nums) );
	}
}

package edu.bu.met.cs566.Knapsack_Problems;


import java.util.Scanner;

public class Knapsack_0_1 
	{

	public static void main(String[] args) 
		{
		
		Scanner inp = new Scanner(System.in);
		
		System.out.println("Please enter the total number of items");
		int n = inp.nextInt();
		
		int [] values = new int[n];
		int [] weights = new int[n];
		
		for (int a = 0; a < n; a++)
			{
			System.out.println("Please enter the weight for item #" + (a+1));
			weights[a] = inp.nextInt();
			
			System.out.println("Please enter the value for item #" + (a+1));
			values[a] = inp.nextInt();
			}
		
		System.out.println("Please enter the maximum capacity of the knapsack");
		int W = inp.nextInt();
		
		
		int [][] knowledge = new int [n+1][W+1];
		//initializing the memoization array to all -1's
		for (int c = 0; c <= n; c++)
			{
			for (int j = 0; j <= W; j++)
				{						
				knowledge[c][j] = -1;
				} 
			}
		
		System.out.println("The maximum value for this configuration is " + knap(values, weights, 1, n, W, knowledge));
		
		inp.close();
		}//end of main
	
	
	
	public static int knap (int [] values, int [] weights, int i, int n, int W, int [][] knowledge)
		{
		
		//Conditional returns and stopping criteria
		if (i >= n) 
			{
			return 0;
			}
		if (weights[i] > W)
			{
			return 0;
			}
		
		if (knowledge[i][W] > 0)
			{
			return knowledge[i][W];
			}
		
		//Recursive calls 
		int first = values[i] + knap(values, weights, (i+1), n, (W-weights[i]), knowledge);
		
		int second = knap(values, weights,(i+1), n, W, knowledge);
		
		//Memoization element 
		knowledge[i][W] = (first > second) ? first: second;
		
		//compare the two numbers calculated, and return the larger of the two
		return knowledge[i][W];
		
		}//end of method

	}//end of class

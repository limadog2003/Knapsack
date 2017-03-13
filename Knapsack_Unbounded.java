package edu.bu.met.cs566.Knapsack_Problems;

import java.util.Scanner;

public class Knapsack_Unbounded {

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
		
		
		int [] knowledge = new int [W+1];
		
		
		//initializing the memoization array to all -1's
		for (int j = 0; j <= W; j++)
			{						
			knowledge[j] = -1;
			} 
			
		
		System.out.println("The maximum value for this configuration is " + knap(values, weights, n, W, knowledge));
		
		for (int j = 0; j <= W; j++)
			{						
			System.out.println(knowledge[j]); 
			} 
		inp.close();
		}//end of main
	
	
	
	public static int knap (int [] values, int [] weights, int n, int W, int [] knowledge)
		{
		//Conditional returns and stopping criteria
		if (W <= 0)
			{
			knowledge[W] = 0;
			return knowledge[W];
			}
		
		//memoization to return the value if we've already calculated it
		if (knowledge[W] > 0)
			{
			return knowledge[W];
			}
		
		//Recurssive top-down method to determine the maximum value 
		int max = 0;
		for (int i = 0; i < n; i++)
			{
			if (weights[i] <= W)
				{
				int val = values[i] + knap(values, weights, n, (W-weights[i]), knowledge);	
				max = (max > val) ? max:val;

				}
			
			knowledge[W] = max;
			}
		
		return knowledge[W];
				
		}//end of method

	}//end of class

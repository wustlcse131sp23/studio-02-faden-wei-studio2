package studio2;

import java.util.Scanner;

public class ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Start amount: ");
		int startAmount = in.nextInt();
		
		System.out.print("Win chance: ");
		double winChance = in.nextDouble();
		
		System.out.print("Win limit: ");
		int winLimit = in.nextInt();
		
		System.out.print("Total simulations: ");
		int totalSimulations = in.nextInt();
		
		double expectedRuinRate;
		double a = (1 - winChance) / winChance;
		
		if (winChance == 0.5)
		{
			expectedRuinRate = 1 - ((double) startAmount / winLimit);
		}
		else
		{
			expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		}
		
		System.out.println();
		int losses = 0;
		int plays = 0;
		
		for (int I = 0; I <totalSimulations; I++ ) // repeat for each day
		{
			int totalAmount = startAmount;
			plays = 0;

			
			while (totalAmount > 0 && totalAmount < winLimit) // one day simulation
			{
				if (Math.random() < winChance)
				{
					totalAmount++;
				}
				else
				{
					totalAmount--;
				}	
				plays++;
			}

			if (totalAmount == 0)
			{	
				System.out.println("Simulation " + (I+1) + ": " + plays + " LOSE");
				losses++;
			}
			else if (totalAmount >= winLimit)
			{	
				System.out.println("Simulation " + (I+1) + ": " + plays + " WIN");
			}
			
		}
		
		System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
		
		double ruinRate = (double) losses / totalSimulations;
		System.out.println("Ruin rate: " + ruinRate);
		System.out.println("Expected ruin rate: " + expectedRuinRate);
		
		}
	}

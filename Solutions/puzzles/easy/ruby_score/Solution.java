package puzzles.easy.ruby_score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * 
 * https://www.codingame.com/ide/puzzle/rugby-score
 * 
 **/
class Solution {

    private static ArrayList<Combinations> solutions = null; 

	
	private static class Combinations{
		private int tries;
		private int transformations;
		private int penalties;
		
		// ctors
		public Combinations(int y, int z) {
			this.transformations = y;
			this.penalties = z;
		}
		
		
		public Combinations(int x, int y, int z) {
			this.tries = x;
			this.transformations = y;
			this.penalties = z;
		}
		
		// getters
		public int getTries() {
			return tries;
		}
		public int getTransformations() {
			return transformations;
		}
		public int getPenalties() {
			return penalties;
		}

	}
	
	
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        try {

            int N = in.nextInt();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            solutions = new ArrayList<Combinations>();
            
            // Set all the possible number of transformations and penalties depending of N
            ArrayList<Integer> transformations = new ArrayList<Integer>();
            ArrayList<Integer> penalties = new ArrayList<Integer>();        
            int transformation = 0;
            int penalty = 0;        
            
            while ( 2*transformation <= N ) {        	
    			transformations.add(transformation);
    			transformation++;
    		}
            
            while ( 3*penalty <= N ) {        	
    			penalties.add(penalty);
    			penalty++;
    		}
            
            // Construct the array of all possible combinations of transformations and penalties
            ArrayList<Combinations> combinations = new ArrayList<Combinations>();
            Combinations c = null;
            for (Integer t : transformations) {
                for (Integer p : penalties) {
                	c = new Combinations( t, p );
                	combinations.add( c );
        		}
    		}            
            
            // Call the methods to obtain the solution(s) using all the possible combinaisons of transformations and penalties
            for (Combinations combination : combinations) {
            	numberOfTries(combination.getTransformations(), combination.getPenalties(), N);
    		}
            
            // The combinations must be ordered by increasing order of tries, then transformations, then penalties/drops            
            orderedSolution( solutions );
			
		} finally {
			in.close();			
		}
        

    }

    private static List<Combinations> orderedSolution( ArrayList<Combinations> sol ) {
        // Ordered by increasing tries
        Comparator<Combinations> comparatorTries = new Comparator<Solution.Combinations>() {
			@Override
			public int compare(Combinations left, Combinations right) {
				return left.getTries() - right.getTries();
			}
		};
        
		Collections.sort( sol, comparatorTries );    	
    	displayOrderedSolution( sol);
		
		return sol;		
	}

	
    private static void displayOrderedSolution(ArrayList<Combinations> sol) {
		for (Combinations c : sol) {
			System.out.println( c.getTries() + " " + c.getTransformations() + " " + c.getPenalties() );
		}
		
        // Display the solution(s)
        for (Combinations solution : sol) {        	
            displayResult( solution );
		}
		
	}

	
	/**
     * Display the result of the linear equation with a good combination 
     * @param c The good combination of tries, transformations and penalties
     */
	private static void displayResult(Combinations c) {
		int tries = c.getTries();
		int transformations = c.getTransformations();
		int penalties = c.getPenalties();
		int result = 5*tries + 2*transformations + 3*penalties;
		System.err.println( "5*" + tries + " + 2*" + transformations + " + 3*" + penalties + " = " + result  );
	}


	/** Calculate the number of tries with values given in parameters.<BR>
	 * If the value of tries is an integer value (no decimals), call a method which verify the linear equation
	 * @param transformations Number of transformations
	 * @param penalties	Number of penalties
	 * @param N	Given rugby score
	 */
	public static void numberOfTries( int transformations, int penalties, int N ) {
		// Cast all int parameters into double to have the result (number of tries) in double format
		double transformations_d = (double) transformations;
		double penalties_d = (double) penalties;
		double N_d = (double) N;		
		final double TRIES_SCORE_D = 5;
		double tries = ( ( N_d - ( 2 * transformations_d ) - ( 3 * penalties_d ) ) / TRIES_SCORE_D );	
		
		// Number of tries must be an integer value (no decimal)
		int int_tries = (int)tries;;
		if( int_tries == tries ) {
			if( tries >= 0 ) {
				verifyEquation( int_tries, transformations, penalties, N );				
			}
		}
	}
	

	/**
	 * Verify the linear equation: 5*tries + 2*transformations + 3*penalties == N. <BR>
	 * If the equation is verified, the combination (tries, transformations, penalties) is added to the list of solutions
	 * @param tries Number of tries
	 * @param transformations Number of transformations
	 * @param penalties	Number of penalties
	 * @param N	Given rugby score
	 */
	private static void verifyEquation(int tries, int transformations, int penalties, int N) {
		Combinations combination = null;
		boolean result = ( 5*tries + 2*transformations + 3*penalties == N );
		if( result ) {
			combination = new Combinations( tries, transformations, penalties );
			solutions.add( combination );
		}
	}
	
	
}

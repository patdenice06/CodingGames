import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

	/**
	 * Return an array of string the optimal directions Thor can move to join his light of power 
	 * @param LX The X position of the light of power
	 * @param LY The Y position of the light of power
	 * @param TX Thor's starting X position
	 * @param TY Thor's starting Y position
	 * @return The optimal directions Thor can move 
	 */
    public static String[] directions( int LX, int LY, int TX, int TY  ) {
    	String[] d = null;
    	int stepsX = 0;
    	int stepsY = 0;
    	String dirX = null;
    	String dirY = null;
    	
    	// Thor moves along the X axis (Straight line)
    	if( LY == TY ) {
    		System.err.println( "Thor moves along the X axis (Straight line)" );
    		stepsX = Math.abs( TX - LX );
    		if( LX < TX ) {
    			dirX = "W";    			
    		}
    		else {
    			dirX = "E";    			
    		}
    		
	    	// Return directions
	    	d = new String[ stepsX ];
	    	for (int i = 0; i < d.length; i++) {
	    		d[i] = dirX;
			}	
	    	
	    	System.err.println( "Steps and directions along the X axis: " + stepsX + dirX );
	    	
	    	return d;
    	}
    	
    	// Thor moves along the Y axis (Up)
    	if( LX == TX ) {
    		System.err.println( "Thor moves along the Y axis (Up)" );
    		stepsY = Math.abs( TY - LY );
    		if( LY < TY )    			
    			dirY = "N";
    		else
    			dirY = "S";
    		
	    	// Return directions
	    	d = new String[ stepsY ];
	    	for (int i = 0; i < d.length; i++) {
	    		d[i] = dirY;
			}	

	    	System.err.println( "Steps and directions along the Y axis: " + stepsY + dirY );	    	
	    	
	    	return d;    		
    	}
    	
    	
    	// TODO Thor moves along an optimal angular path
    	if( LX != TX && LY != TY ) {
    		stepsX = Math.abs( TX - LX );
    		stepsY = Math.abs( TY - LY );
    		
    		// X axis moves
    		if( LX < TX  ) {
    			dirX = "W";
    		}
    		else {
    			dirX = "E";
    		}
    		
    		// Y axis moves
    		if( LY < TY ) {
    			dirY = "N";
    		}
    		else {
    			dirY = "S";
    		}
    		
    		// Calculate the optimal moves
    		int minSteps = Math.min( stepsX, stepsY );
    		int maxSteps = Math.max( stepsX, stepsY );
    		int diff = maxSteps - minSteps;
    		
    		d = new String[ minSteps + diff ];
    		int i;
    		
    		for (i = 0; i < minSteps; i++) {
				d[i] = dirY + dirX;
			}
    		
    		int remainXsteps = minSteps + diff;
    		for (int j = i; j < remainXsteps; j++) {
    			d[j] = dirX;
			}
    		
	    	System.err.println( "Steps and directions along an optimal angular path: " + minSteps + dirY + dirX + diff + dirX );	    	
	    	
	    	return d;    		
    		
    	}
    	

    	return d;
    }
    

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        try {
            int lightX = in.nextInt(); // the X position of the light of power
            int lightY = in.nextInt(); // the Y position of the light of power
            int initialTX = in.nextInt(); // Thor's starting X position
            int initialTY = in.nextInt(); // Thor's starting Y position

            // Initial positions
        	System.err.println( "Thor position = (" + initialTX + "," + initialTY + "). Light position = (" + lightX + ","+ lightY + ")." );
            // game loop
            while (true) { 
                int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
                String[] d = directions( lightX, lightY, initialTX, initialTY  );

                // Write an action using System.out.println()
                // To debug: System.err.println("Debug messages...");


                // A single line providing the move to be made: N NE E SE S SW W or NW
                for (int i=0; i<d.length; i++) {
                	System.out.println( d[i] );
                }
            }
		} finally {
			in.close();
		}

    }
}

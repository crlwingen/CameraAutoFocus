/*============================================================================
* Title	      :	Auto-Zoom Function Of A Digital Camera Using Fuzzy Logic
* Description : An auto-zoom function for a digital camera that uses Fuzzy
*					Logic to decide on the level of zoom the camera must use in a
*           	    certain distance between the camera and the object to be
*           	    photographed.
* Filename    : FuzzifyDistance.java
* Version     : v1.0
* Author      : Group 1
* Yr&Sec      : 3-3
* Subject     : Computational Intelligence
*============================================================================*/

public class FuzzifyDistance {

/*============================================================================*
*  Function   : FuzzifyDistance
*  Params     : fltDistance   -> The value of distance.
*				strMembership -> 
*  Returns    : dblFuzzyDistance
*  Description: This is the function where the necessary methods will be 
*    			executed.
*============================================================================*/

	public double FuzzifyDistance(float fltDistance, String strMembership) {

		//======================== Initialization ========================//

		double dblFuzzyDistance = 0;
		
		//================================================================//

		//========================== Code Body ===========================//
		
		/* Distance: Too Near */
 		if(strMembership.equals("TooNear")) { 

			if(fltDistance > 5)
				dblFuzzyDistance = 0;

			// Right-side slope of Distance: Too Near
			else if(fltDistance < 5 && fltDistance > 0)
				dblFuzzyDistance = (double) -0.2 * fltDistance + 1;

			// Peak of trapmf
			else if(fltDistance <= 0)
				dblFuzzyDistance = 1;

		}

		/* Distance: Near */
		else if(strMembership.equals("Near")) { 

			if(fltDistance < 4)
				dblFuzzyDistance = 0;

			// Left-side slope of Distance: Near
			else if(fltDistance < 10 && fltDistance >= 4)
				dblFuzzyDistance = (double) 0.16666666666666666666666666666667 * 
											fltDistance - 0.66666666666666666666666666666667;
			
			// Peak of trimf
			else if(fltDistance == 10) 
				dblFuzzyDistance = 1;

			// Right-side slope of Distance: Near
			else if(fltDistance < 12 && fltDistance > 10) 
				dblFuzzyDistance = (double) -0.5 * fltDistance + 6;
			
			else if(fltDistance >= 12)
				dblFuzzyDistance = 0;
		
		} 

		/* Distance: Medium */
		else if(strMembership.equals("Medium")) { 

			if(fltDistance < 10)
				dblFuzzyDistance = 0;

			// Left-side slope  of Distance: Medium
			else if(fltDistance < 13 && fltDistance >= 10) 
				dblFuzzyDistance = (double) 0.33333333333333333333333333333333 * 
											fltDistance - 3.3333333333333333333333333333333;

			// Peak of trimf
			else if(fltDistance == 13)
				dblFuzzyDistance = 1;

			// Right-side slope of Distance: Medium
			else if(fltDistance < 25 && fltDistance > 13)
				dblFuzzyDistance = (double) -0.08333333333333333333333333333333 * 
											fltDistance + 2.0833333333333333333333333333333;

			else if(fltDistance >= 25)
				dblFuzzyDistance = 0;
		
		} 

		/* Distance: Far */
		else if(strMembership.equals("Far")) { 

			if(fltDistance <= 20)
				dblFuzzyDistance = 0;

			// Left-side slope of Distance: Far
			else if(fltDistance < 30 && fltDistance > 20)
				dblFuzzyDistance = (double) 0.1 * fltDistance - 2;

			else if(fltDistance == 30)
				dblFuzzyDistance = 1;

			// Right-side slope of Distance: Far
			else if(fltDistance < 45 && fltDistance > 30)
				dblFuzzyDistance = (double) -0.06666666666666666666666666666667 * 
			                                fltDistance + 3;

			else if(fltDistance >= 45)
				dblFuzzyDistance = 0;
		
		} 

		/* Distance: Too Far */
		else if(strMembership.equals("TooFar")) { 

			if(fltDistance <= 40)
				dblFuzzyDistance = 0;

			// Left-side slope of Distance: Too Far
			else if(fltDistance < 45 && fltDistance > 40)
				dblFuzzyDistance = (double) .2 * fltDistance - 8;

			// Peak of trapmf
			else if(fltDistance >= 45)
				dblFuzzyDistance = 1;

		}

		return dblFuzzyDistance;

		//================================================================//

	}
	
}
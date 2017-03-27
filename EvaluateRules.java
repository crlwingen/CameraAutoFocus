/*============================================================================
* Title	      :	Auto-Zoom Function Of A Digital Camera Using Fuzzy Logic
* Description : An auto-zoom function for a digital camera that uses Fuzzy
*					Logic to decide on the level of zoom the camera must use in a
*           	    certain distance between the camera and the object to be
*           	    photographed.
* Filename    : EvaluateRules.java
* Version     : v1.0
* Author      : Group 1
* Yr&Sec      : 3-3
* Subject     : Computational Intelligence
*============================================================================*/

public class EvaluateRules {

/*============================================================================*
*  Function   : EvaluateRules
*  Params     : fltDistance -> Distance inputted by the user. 
*  Returns    : arrRule     -> Matrix containing rules with values indicating 
*					           the result after evaluating each rule.
*  Description: This function evaluates each rule of the Fuzzy Control System
*				and puts the result in the matrix.
*============================================================================*/

	public double[][] EvaluateRules(Float fltDistance) {


		//======================== Initialization ========================//

		double[][] arrRule          = new double[5][5];
		FuzzifyDistance fuzzDist    = new FuzzifyDistance();

		// Initialize the 2D array for the rule evaluation.
		for(int intRow = 0; intRow < 5; intRow++) {
			for(int intCol = 0; intCol < 5; intCol++) {
				arrRule[intRow][intCol] = 0;
			}
		}

		//================================================================//

		//========================== Code Body ===========================//
		
		// Rule 1 # DISTANCE: Too Near -> ZOOM: Maximum Zoom Out
		if(fltDistance >= 0 && fltDistance <= 5) {
			arrRule[0][0] = fuzzDist.FuzzifyDistance(fltDistance, "TooNear");
			arrRule[0][1] = 0;
			arrRule[0][2] = 0;
			arrRule[0][3] = 0;
			arrRule[0][4] = 0;
		}

		// Rule 2 # Distance: Near -> ZOOM: Minimum Zoom Out
		if(fltDistance >= 4 && fltDistance <= 12) {
			arrRule[1][0] = 0;
			arrRule[1][1] = fuzzDist.FuzzifyDistance(fltDistance, "Near");
			arrRule[1][2] = 0;
			arrRule[1][3] = 0;
			arrRule[1][4] = 0;
		}

		// Rule 3 # DISTANCE: Medium -> ZOOM: Default
		if(fltDistance >= 10  && fltDistance <= 25) {
			arrRule[2][0] = 0;
			arrRule[2][1] = 0;
			arrRule[2][2] = fuzzDist.FuzzifyDistance(fltDistance, "Medium");
			arrRule[2][3] = 0;
			arrRule[2][4] = 0;
		}

		// Rule 4 # DISTANCE: Far -> ZOOM: Minimum Zoom In
		if(fltDistance >= 20 && fltDistance <= 45) {
			arrRule[3][0] = 0;
			arrRule[3][1] = 0;
			arrRule[3][2] = 0;
			arrRule[3][3] = fuzzDist.FuzzifyDistance(fltDistance, "Far");
			arrRule[3][4] = 0;
		}

		// Rule 5 # DISTANCE: Too Far -> ZOOM: Maximum Zoom In
		if(fltDistance >= 40 && fltDistance <= 50) {
			arrRule[4][0] = 0;
			arrRule[4][1] = 0;
			arrRule[4][2] = 0;
			arrRule[4][3] = 0;
			arrRule[4][4] = fuzzDist.FuzzifyDistance(fltDistance, "TooFar");
		}
		
		return arrRule;

		//================================================================//
	}
} 
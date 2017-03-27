/*============================================================================
* Title	      :	Auto-Zoom Function Of A Digital Camera Using Fuzzy Logic
* Description : An auto-zoom function for a digital camera that uses Fuzzy
*					Logic to decide on the level of zoom the camera must use in a
*             	  	certain distance between the camera and the object to be
*             		photographed.
* Filename    : Aggregation.java
* Version     : v1.0
* Author      : Group 1
* Yr&Sec      : 3-3
* Subject     : Computational Intelligence
*============================================================================*/

import java.lang.*;

public class Aggregation {

/*============================================================================*
*  Function   : AggregatedValues
*  Params     : arrRules  -> Array of the computed DOMs of the input as evaluated 
*                            in the rule.
*               arrZoom   -> List of all the DOMs of the points at the output.
*  Returns    : dblAggVal -> Contains the aggregated values computed.
*  Description: Gets the aggregated values from the output after evaluating it with 
*				the given rules.
*============================================================================*/
	
	public double[] AggregatedValues(double[][] arrRules, double[][] arrZoom) {

		//======================== Initialization ========================//

		double[] dblAggVal  = new double[201];
		double[][] dblFuzzy = new double[9][201];

		// Assigns 0 values to the dblAggVal array.
		for(int intCtr = 0; intCtr < 201; intCtr++) 
			dblAggVal[intCtr] = 0;

		//================================================================//

		//========================== Code Body ===========================//	

		for(int intRuleCtr = 0; intRuleCtr < 5; intRuleCtr++) {
			for(int intValCtr = 0; intValCtr < 201; intValCtr++) {

				// For Maximum Zoom Out membership
				if(arrRules[intRuleCtr][0] > 0) {
					if(intValCtr >= 0 && intValCtr <= 61)
						dblFuzzy[intRuleCtr][intValCtr] = Math.min(arrRules[intRuleCtr][0], arrZoom[0][intValCtr]);
					else
						dblFuzzy[intRuleCtr][intValCtr] = 0;
				}

				// For Minimum Zoom Out membership
				if(arrRules[intRuleCtr][1] > 0) {
					if(intValCtr >= 41 && intValCtr <= 101)
						dblFuzzy[intRuleCtr][intValCtr] = Math.min(arrRules[intRuleCtr][1], arrZoom[1][intValCtr]);
					 else
						dblFuzzy[intRuleCtr][intValCtr] = 0;
				}

				// For Default Zoom membership
				if(arrRules[intRuleCtr][2] > 0) {
					if(intValCtr >= 81 && intValCtr <= 121)
						dblFuzzy[intRuleCtr][intValCtr] = Math.min(arrRules[intRuleCtr][2], arrZoom[2][intValCtr]);
					else
						dblFuzzy[intRuleCtr][intValCtr] = 0;
				}

				// For Minimum Zoom In membership
				if(arrRules[intRuleCtr][3] > 0) {
					if(intValCtr >= 101 && intValCtr <= 161)
						dblFuzzy[intRuleCtr][intValCtr] = Math.min(arrRules[intRuleCtr][3], arrZoom[3][intValCtr]);
					else
						dblFuzzy[intRuleCtr][intValCtr] = 0;
				}

				// For Maximum Zoom In membership
				if(arrRules[intRuleCtr][4] > 0) {
					if(intValCtr >= 141 && intValCtr < 201)
						dblFuzzy[intRuleCtr][intValCtr] = Math.min(arrRules[intRuleCtr][4], arrZoom[4][intValCtr]);
					else 
						dblFuzzy[intRuleCtr][intValCtr] = 0;
				}

			}
		}

		// Puts fuzzified values into the aggregated values array.
		for(int intValCtr = 0; intValCtr < 201; intValCtr++) {
			for(int intRuleCtr = 0; intRuleCtr < 9; intRuleCtr++) {
				if(dblAggVal[intValCtr] < dblFuzzy[intRuleCtr][intValCtr])
					dblAggVal[intValCtr] = dblFuzzy[intRuleCtr][intValCtr];
			}
		}
		
		return dblAggVal;

		//================================================================//

	}
}
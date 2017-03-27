/*============================================================================
* Title	      :	Auto-Zoom Function Of A Digital Camera Using Fuzzy Logic
* Description : An auto-zoom function for a digital camera that uses Fuzzy
*					Logic to decide on the level of zoom the camera must use in a
*               	certain distance between the camera and the object to be
*               	photographed.
* Filename    : ComputeCentroid.java
* Version     : v1.0
* Author      : Group 1
* Yr&Sec      : 3-3
* Subject     : Computational Intelligence
*============================================================================*/

public class ComputeCentroid {

/*============================================================================*
*  Function   : ComputeCentroid
*  Params     : arrAggVal    -> List of the aggregated values.
*  Returns    : dblCentroid  -> Returns the value of the computed centroid.
*  Description: The method computes for the centroid using the aggregated values given.
*============================================================================*/

	public double ComputeCentroid(double[] arrAggVal) {

		//======================== Initialization ========================//

		double dblCentroid, dblCentroidNum = 0, dblCentroidDenum = 0, dblStart = -10;

		//================================================================//

		//========================== Code Body ===========================//

		for(int intCtr = 0; intCtr < 201; intCtr++, dblStart += .1) {
			dblCentroidNum    = (arrAggVal[intCtr] * (Math.round(dblStart * 100.0) / 100.0)) + dblCentroidNum;
			dblCentroidDenum  = arrAggVal[intCtr] + dblCentroidDenum; 
		}

		dblCentroid = dblCentroidNum / dblCentroidDenum;
		System.out.println("Magnification Level: " + dblCentroid);
		
		return dblCentroid;

		//================================================================//
		
	}
}
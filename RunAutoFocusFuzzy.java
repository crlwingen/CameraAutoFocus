/*============================================================================*
* Title	      :	Auto-Zoom Function Of A Digital Camera Using Fuzzy Logic
* Description : An auto-zoom function for a digital camera that uses Fuzzy
*				Logic to decide on the level of zoom the camera must use in a
*               certain distance between the camera and the object to be
*               photographed.
* Filename    : RunAutoFocusFuzzy.java
* Version     : v1.0
* Author      : Group 1
* Yr&Sec      : 3-3
* Subject     : Computational Intelligence
*============================================================================*/

public class RunAutoFocusFuzzy {

/*============================================================================*
*  Function   : RunAutoFocusFuzzy
*  Params     : None 
*  Returns    : Void
*  Description: This is the function where the necessary methods will be 
*    			executed.
*============================================================================*/

	public static void main(String[] args) {

		//======================== Initialization ========================//

		GetDistance GetDist   		  = new GetDistance();
		EvaluateRules EvalRule        = new EvaluateRules();
		FuzzifyZoom FuzZoom 		  = new FuzzifyZoom();
		Aggregation Aggregate		  = new Aggregation();
		ComputeCentroid Centroid      = new ComputeCentroid();

		//================================================================//

		//========================== Code Body ===========================//

		float fltInput      		  = GetDist.GetDistance();			 
		double[][] arrRules 		  = EvalRule.EvaluateRules(fltInput); 										   
		double[][] arrZoom  		  = FuzZoom.FuzzifyZoom();			
		double[] arrAggVal			  = Aggregate.AggregatedValues(arrRules, arrZoom);
		double dblCentroid 			  = Centroid.ComputeCentroid(arrAggVal);

		//================================================================//

	}
}
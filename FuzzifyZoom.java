/*============================================================================
* Title	      :	Auto-Zoom Function Of A Digital Camera Using Fuzzy Logic
* Description : An auto-zoom function for a digital camera that uses Fuzzy
*					Logic to decide on the level of zoom the camera must use in a
*           	    certain distance between the camera and the object to be
*           	    photographed.
* Filename    : FuzzifyZoom.java
* Version     : v1.0
* Author      : Group 1
* Yr&Sec      : 3-3
* Subject     : Computational Intelligence
*============================================================================*/

public class FuzzifyZoom {

/*============================================================================*
*  Function   : FuzzifyZoom
*  Params     : None
*  Returns    : arrZoom -> Array of the DOMs off all the points in the output.
*  Description: Returns list of aggregated values for each membership functions.
*============================================================================*/
	
	public double[][] FuzzifyZoom() {

		//======================== Initialization ========================//

		double[][] arrZoom = new double[5][201];
		int intValCtr;
		
		//================================================================//

		//========================== Code Body ===========================//

		/* Zoom: Maximum Zoom Out */
		for(intValCtr = 0; intValCtr < 21; intValCtr++)
			arrZoom[0][intValCtr] = 1;

		// Right-side slope of Zoom: Maximum Zoom Out
		double dblMaxZOutR = -8;
		for(intValCtr = 21; intValCtr < 61; intValCtr++, dblMaxZOutR += .1)
			arrZoom[0][intValCtr] = -0.25 * (Math.round(dblMaxZOutR * 100.0) / 100.0) - 1;

		for(intValCtr = 61; intValCtr < 201; intValCtr++)
			arrZoom[0][intValCtr] = 0;


		/* Zoom: Minimum Zoom Out */
		for(intValCtr = 0; intValCtr < 41; intValCtr++)
			arrZoom[1][intValCtr] = 0;

		// Left-side slope of Zoom: Minimum Zoom Out
		double dblMinZOutL = -6;
		for(intValCtr = 41; intValCtr < 81; intValCtr++, dblMinZOutL += .1)
			arrZoom[1][intValCtr] = .25 * (Math.round(dblMinZOutL * 100.0) / 100.0) + 1.5;

		// Right-side slope of Zoom: Minimum Zoom Out
		double dblMinZOutR = -2;
		for(intValCtr = 81; intValCtr < 101; intValCtr++, dblMinZOutR += .1)
			arrZoom[1][intValCtr] = -0.5 * (Math.round(dblMinZOutR * 100.0) / 100.0);

		for(intValCtr = 101; intValCtr < 201; intValCtr++) 
			arrZoom[1][intValCtr] = 0;


		/* Zoom: Default Zoom */
		for(intValCtr = 0; intValCtr < 81; intValCtr++)
			arrZoom[2][intValCtr] = 0;

		// Left-side slope of Zoom: Default
		double dblDefL = -2;
		for(intValCtr = 81; intValCtr < 101; intValCtr++, dblDefL += .1) 
			arrZoom[2][intValCtr] = .5 * (Math.round(dblDefL * 100.0) / 100.0) + 1;

		// Right-side slope of Zoom: Default
		double dblDefR = 0;
		for(intValCtr = 101; intValCtr < 121; intValCtr++, dblDefR += .1) // -.5, 1
			arrZoom[2][intValCtr] = -.5 * (Math.round(dblDefR * 100.0) / 100.0) + 1;

		for(intValCtr = 121; intValCtr < 201; intValCtr++)
			arrZoom[2][intValCtr] = 0;


		/* Zoom: Minimum Zoom In */
		for(intValCtr = 0; intValCtr < 101; intValCtr++)
			arrZoom[3][intValCtr] = 0;

		// Left-side slope of Zoom: Minimum Zoom In
		double dblMinZInL = 0;
		for(intValCtr = 101; intValCtr < 121; intValCtr++, dblMinZInL += .1)
			arrZoom[3][intValCtr] = .5 * (Math.round(dblMinZInL * 100.0) / 100.0);

		// Right-side slope of Zoom: Minimum Zoom In
		double dblMinZInR = 2;
		for(intValCtr = 121; intValCtr < 161; intValCtr++, dblMinZInR += .1)
			arrZoom[3][intValCtr] = -0.25 * (Math.round(dblMinZInR * 100.0) / 100.0) + 1.5;

		for(intValCtr = 161; intValCtr < 201; intValCtr++)
			arrZoom[3][intValCtr] = 0;


		/* Zoom: Maximum Zoom In */
		for(intValCtr = 0; intValCtr < 141; intValCtr++)
			arrZoom[4][intValCtr] = 0;

		// Left-side slope of Zoom: Maximum Zoom In
		double dblMaxZInL = 4;
		for(intValCtr = 141; intValCtr < 161; intValCtr++, dblMaxZInL += .1)
			arrZoom[4][intValCtr] = .5 * (Math.round(dblMaxZInL * 100.0) / 100.0) - 2;

		for(intValCtr = 161; intValCtr < 201; intValCtr++)
			arrZoom[4][intValCtr] = 1;


		return arrZoom;

		//================================================================//

	}
}
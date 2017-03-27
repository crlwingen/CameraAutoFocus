/*============================================================================
* Title	      :	Auto-Zoom Function Of A Digital Camera Using Fuzzy Logic
* Description : An auto-zoom function for a digital camera that uses Fuzzy
*					Logic to decide on the level of zoom the camera must use in a
*           	    certain distance between the camera and the object to be
*           	    photographed.
* Filename    : GetDistance.java
* Version     : v1.0
* Author      : Group 1
* Yr&Sec      : 3-3
* Subject     : Computational Intelligence
*============================================================================*/

import java.util.Scanner;

public class GetDistance {

/*============================================================================*
*  Function   : GetDistance
*  Params     : None
*  Returns    : fltDistance -> The value of distance.
*  Description: Obtain the distance to be evaluated as input.
*============================================================================*/

	public float GetDistance() {

		//======================== Initialization ========================//

		Scanner scnInput = new Scanner(System.in);

		//================================================================//

		//========================== Code Body ===========================//

		System.out.print("Enter camera distance: ");
		float fltDistance = scnInput.nextFloat();

		if(fltDistance > 50)
			fltDistance = 50;
		else if(fltDistance < 0)
			fltDistance = 0;

		return fltDistance;

		//================================================================//

	}
}
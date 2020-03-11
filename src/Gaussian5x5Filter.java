/**
 * @author Anthony Asp, Emily Lott
 *
 *Filter the image using Gaussian Blur. 5x5
 */

public class Gaussian5x5Filter implements Filter {
	int[][] weights = {{1,2,3,2,1},
			   		   {2,4,6,4,2},
			   		   {3,6,9,6,3},
			   		   {2,4,6,4,2},
			   		   {1,2,3,2,1}};
	int scaleFactor = 81;

	public void filter(PixelImage pi) {
		pi.computeFilter(weights, scaleFactor);
	}
}

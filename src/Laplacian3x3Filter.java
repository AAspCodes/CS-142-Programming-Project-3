/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that converts image using Laplacian filter technique.
 */

public class Laplacian3x3Filter implements Filter {
	int[][] weights = {{-1,-1,-1},
			   		   {-1,8,-1},
			   		   {-1,-1,-1}};
	int scaleFactor = 1;

	public void filter(PixelImage theImage) {
		theImage.computeFilter(weights, scaleFactor);
	}
}

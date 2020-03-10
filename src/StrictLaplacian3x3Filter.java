/**
 * 
 * @author Anthony Asp, Emily Plott
 * 
 * This Filter is a more strict version of laplacian that only takes
 * the values directly above and beside the central pixel.
 * It ignore the pixels diagonal from the center.
 */

public class StrictLaplacian3x3Filter implements Filter {
	int[][] weights = {{0,-1,0},
					   {-1,4,-1},
					   {0,-1,0}};
	int scaleFactor = 1;

	public void filter(PixelImage theImage) {
		theImage.computeSummingFilter(weights, scaleFactor);
	}
}

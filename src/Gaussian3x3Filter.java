/**
 * @author Anthony Asp, Emily Lott
 *
 *Filter the image using Gaussian Blur. 3x3
 */

public class Gaussian3x3Filter implements Filter {
	int[][] weights = {{1,2,1},
					   {2,4,2},
					   {1,2,1}};
	int scaleFactor = 16;
	
	public void filter(PixelImage theImage) {
		theImage.computeFilter(weights, scaleFactor);
	}
}

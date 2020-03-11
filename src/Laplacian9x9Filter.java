/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that converts image using Laplacian filter technique. but with 9x9.
 */

public class Laplacian9x9Filter implements Filter {
	int[][] weights = {{-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,80,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1}};
	int scaleFactor = 1;

	public void filter(PixelImage theImage) {
		theImage.computeFilter(weights, scaleFactor);
	}
}

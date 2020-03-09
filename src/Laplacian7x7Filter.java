/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that converts image using Laplacian filter technique. but with 7x7
 */

public class Laplacian7x7Filter implements Filter {
	int[][] weights = {{-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1},
			   		   {-1,-1,-1,48,-1,-1,-1},
			   		   {-1,-1,-1,-1,-1,-1,-1},
			   		   {-1,-1,-1,-1,-1,-1,-1},
			   		   {-1,-1,-1,-1,-1,-1,-1}};
	int scaleFactor = 1;

	public void filter(PixelImage theImage) {
		theImage.computeSummingFilter(weights, scaleFactor);
	}
}

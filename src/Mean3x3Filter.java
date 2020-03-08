/**
 * @author Anthony Asp, Emily Plott
 * 
 * 3x3 Mean filter
 */

public class Mean3x3Filter implements Filter {
	int[][] weights = {{1,1,1},
			   		   {1,1,1},
			   		   {1,1,1}};
	int scaleFactor = 9;
	
	public void filter(PixelImage theImage) {
		theImage.computeSummingFilter(weights, scaleFactor);
	}
}

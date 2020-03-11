/**
 * @author Anthony Asp, Emily Plott
 * 
 * 5x5 Mean filter
 */

public class Mean5x5Filter implements Filter {
	int[][] weights = {{1,1,1,1,1},
					   {1,1,1,1,1},
					   {1,1,1,1,1},
					   {1,1,1,1,1},
					   {1,1,1,1,1}};
	int scaleFactor = 25;

	public void filter(PixelImage theImage) {
			theImage.computeFilter(weights, scaleFactor);
	}	
}

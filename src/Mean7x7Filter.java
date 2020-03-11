/**
 * @author Anthony Asp, Emily Plott
 * 
 * 7x7 Mean filter
 */

public class Mean7x7Filter implements Filter {
	int[][] weights = {{1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1}};
	int scaleFactor = 49;

	public void filter(PixelImage theImage) {
		theImage.computeFilter(weights, scaleFactor);
	}
}

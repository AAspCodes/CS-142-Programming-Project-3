/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that implements "edgy Filter".
 */

public class Edgy3x3Filter implements Filter {
	int[][] weights = {{-1,-1,-1},
	   		   		   {-1,9,-1},
	   		   		   {-1,-1,-1}};
	int scaleFactor = 1;

	public void filter(PixelImage theImage) {
		theImage.computeSummingFilter(weights, scaleFactor);
	}
}

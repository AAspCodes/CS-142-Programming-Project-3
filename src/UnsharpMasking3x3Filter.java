/**
 * @author Anthony Asp, Emily Lott
 *
 *Implements the "Unsharp Masking Filter.
 */

public class UnsharpMasking3x3Filter implements Filter {
	int[][] weights = {{-1,-2,-1},
	   		   		   {-2,28,-2},
	   		   		   {-1,-2,-1}};
	int scaleFactor = 16;
	
	public void filter(PixelImage theImage) {
		theImage.computeSummingFilter(weights, scaleFactor);
	}
}

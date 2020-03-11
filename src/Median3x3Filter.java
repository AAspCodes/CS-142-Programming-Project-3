/**
 * @author Anthony Asp, Emily Plott
 * 
 * 3x3 Median filter
 */

public class Median3x3Filter implements Filter {
	int borderWidth = 1;
	int filterWidth = 3;
	
	public void filter(PixelImage theImage) {
		theImage.computeFilter(borderWidth, filterWidth);
	}
}

/**
 * @author Anthony Asp, Emily Plott
 * 
 * 7x7 Median filter
 */

public class Median7x7Filter implements Filter {
	int borderWidth = 3;
	int filterWidth = 7;
	
	public void filter(PixelImage theImage) {
		theImage.computeMedianFilter(borderWidth, filterWidth);
	}
}

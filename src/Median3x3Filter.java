/**
 * 
 * @author Anthony Asp, Emily Plott
 * 
 * 3x3 Median filter
 *
 */
public class Median3x3Filter implements Filter {
	int centralPixelBorderWidth = 1;
	
	public void filter(PixelImage theImage) {
		theImage.computeMedianFilter(centralPixelBorderWidth);
	}
}

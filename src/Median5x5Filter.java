/**
 * @author Anthony Asp, Emily Plott
 * 
 * 5x5 Median filter
 */

public class Median5x5Filter implements Filter {
	int borderWidth = 2;
	int filterWidth = 5;
	
	public void filter(PixelImage theImage) {
		theImage.computeFilter(borderWidth, filterWidth);		
	}
}

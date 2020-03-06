/**
 * 
 * @author Anthony Asp, Emily Plott
 * 
 * 5x5 Median filter
 *
 */
public class Median5x5Filter implements Filter {
	
	
	public void filter(PixelImage theImage) {
		theImage.computeMedianFilter(2);
		

	}

}

/**
 * @author Anthony Asp, Emily Plott
 * 
 * 7x7 Median filter
 */
public class Median7x7Filter implements Filter {
	

	public void filter(PixelImage theImage) {
		
		
		theImage.computeMedianFilter(3);

	}

}

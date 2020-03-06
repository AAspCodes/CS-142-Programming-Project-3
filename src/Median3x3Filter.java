/**
 * 
 * @author Anthony Asp, Emily Plott
 * 
 * 3x3 Median filter
 *
 */
public class Median3x3Filter implements Filter {
	
	public void filter(PixelImage pi) {
		pi.computeMedianFilter(1);
	}
}

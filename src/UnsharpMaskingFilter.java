/**
 * 
 * @author Anthony Asp, Emily Lott
 *
 */
public class UnsharpMaskingFilter implements Filter {
	int[][] weights = {{-1,-2,-1},
	   		   		   {-2,28,-2},
	   		   		   {-1,-2,-1}};
	int scaleFactor = 16;
	
	public void filter(PixelImage pi) {
		pi.computeSummingFilter(weights, scaleFactor);

	}

}

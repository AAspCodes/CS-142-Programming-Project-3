/**
 * 
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that converts image using Laplacian filter technique.
 *
 */
public class LaplacianFilter implements Filter {
	int[][] weights = {{-1,-1,-1},
			   		   {-1,8,-1},
			   		   {-1,-1,-1}};
	int scaleFactor = 1;

	public void filter(PixelImage pi) {
		pi.computeSummingFilter(weights, scaleFactor);
		
	}

}

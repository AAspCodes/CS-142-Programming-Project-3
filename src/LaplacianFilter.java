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
		Pixel[][] data = pi.getData();
		pi.computeFilter(data, weights, scaleFactor);
		pi.setData(data);
	}

}

/**
 * 
 * @author Anthony Asp, Emily
 *
 */
public class GaussianFilter implements Filter {
	int[][] weights = {{1,2,1},
					   {2,4,2},
					   {1,2,1}};
	int scaleFactor = 16;
	
	
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		pi.computeFilter(data, weights, scaleFactor);
		pi.setData(data);
	}

}

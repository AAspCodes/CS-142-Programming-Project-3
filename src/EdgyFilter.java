
public class EdgyFilter implements Filter {
	int[][] weights = {{-1,-1,-1},
	   		   		   {-1,9,-1},
	   		   		   {-1,-1,-1}};
	int scaleFactor = 1;

	public void filter(PixelImage pi) {
		pi.computeSummingFilter(weights, scaleFactor);
	}
}

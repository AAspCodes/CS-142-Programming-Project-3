
public class Laplacian5x5Filter implements Filter {
	int[][] weights = {{-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1},
					   {-1,-1,24,-1,-1},
					   {-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1}};
	int scaleFactor = 1;
	
	public void filter(PixelImage pi) {
		pi.computeSummingFilter(weights, scaleFactor);

	}

}

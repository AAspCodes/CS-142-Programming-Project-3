
public class StrictLaplacian3x3Filter implements Filter {
	int[][] weights = {{0,-1,0},
					   {-1,4,-1},
					   {0,-1,0}};
	int scaleFactor = 1;

	public void filter(PixelImage theImage) {
		theImage.computeSummingFilter(weights, scaleFactor);
	}
}

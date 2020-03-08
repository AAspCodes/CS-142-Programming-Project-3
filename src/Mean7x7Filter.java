
public class Mean7x7Filter implements Filter {
	int[][] weights = {{1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1},
					   {1,1,1,1,1,1,1}};
	int scaleFactor = 49;

	public void filter(PixelImage theImage) {
		theImage.computeSummingFilter(weights, scaleFactor);
	}
}

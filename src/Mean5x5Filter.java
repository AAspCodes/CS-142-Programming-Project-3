
public class Mean5x5Filter implements Filter {
	int[][] weights = {{1,1,1,1,1},
					   {1,1,1,1,1},
					   {1,1,1,1,1},
					   {1,1,1,1,1},
					   {1,1,1,1,1}};
	int scaleFactor = 25;

	public void filter(PixelImage theImage) {
			theImage.computeSummingFilter(weights, scaleFactor);
	}	
}

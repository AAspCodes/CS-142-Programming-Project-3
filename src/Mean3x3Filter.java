
public class Mean3x3Filter implements Filter {
	int[][] weights = {{1,1,1},
			   		   {1,1,1},
			   		   {1,1,1}};
	
	int scaleFactor = 9;
	
	@Override
	public void filter(PixelImage theImage) {
		theImage.computeSummingFilter(weights, scaleFactor);

	}

}

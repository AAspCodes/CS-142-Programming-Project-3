
public class Laplacian9x9Filter implements Filter {
	int[][] weights = {{-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,80,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1,-1,-1}};
	int scaleFactor = 1;


	public void filter(PixelImage theImage) {
		// TODO Auto-generated method stub
		theImage.computeSummingFilter(weights, scaleFactor);
	}

}

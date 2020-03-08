
public class Laplacian7x7Filter implements Filter {
	int[][] weights = {{-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1},
					   {-1,-1,-1,-1,-1,-1,-1},
			   		   {-1,-1,-1,48,-1,-1,-1},
			   		   {-1,-1,-1,-1,-1,-1,-1},
			   		   {-1,-1,-1,-1,-1,-1,-1},
			   		   {-1,-1,-1,-1,-1,-1,-1}};
	int scaleFactor = 1;

	
	public void filter(PixelImage theImage) {
		// TODO Auto-generated method stub
		theImage.computeSummingFilter(weights, scaleFactor);
	}

}

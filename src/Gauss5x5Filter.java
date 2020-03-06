
public class Gauss5x5Filter implements Filter {
	int[][] weights = {{1,2,3,2,1},
			   		   {2,4,6,4,2},
			   		   {3,6,9,6,3},
			   		   {2,4,6,4,2},
			   		   {1,2,3,2,1}};
	
	int scaleFactor = 81;
			
	
	
	public void filter(PixelImage pi) {
		pi.computeSummingFilter(weights, scaleFactor);

	}

}

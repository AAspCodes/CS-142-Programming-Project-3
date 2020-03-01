
public class EdgyFilter implements Filter {
	int[][] weights = {{-1,-1,-1},
	   		   		   {-1,9,-1},
	   		   		   {-1,-1,-1}};
	int scaleFactor = 1;

	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		Pixel[][] newData = pi.computeFilter(data, weights, scaleFactor);
		pi.setData(newData);
	}
}

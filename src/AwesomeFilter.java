/**
 * @author Anthony Asp, Emily Lott
 * 
 * A filter that combine others filters in a multi-step process to produce some very interesting results, but it is slow...
 */

public class AwesomeFilter implements Filter {
	public void filter(PixelImage theImage) {
		Mean7x7Filter meanf = new Mean7x7Filter();
		for (int i = 0; i<4;i++) {
			meanf.filter(theImage);
		}
		
		Median7x7Filter medf = new Median7x7Filter();
		for (int i = 0; i<4; i++) {
			medf.filter(theImage);
		}
		Laplacian9x9Filter lapf = new Laplacian9x9Filter();
		lapf.filter(theImage);
	}
}

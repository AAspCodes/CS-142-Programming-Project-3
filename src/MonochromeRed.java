/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that removes all color but Red.
 */

public class MonochromeRed implements Filter {
	public void filter(PixelImage theImage) {
		Pixel[][] data = theImage.getData();

		for (int row = 0; row < theImage.getHeight(); row++) {
			for (int col = 0; col < theImage.getWidth(); col++) {				
				monchromeRedizePixel(data[row][col]);
			}
		}
		theImage.setData(data);
	}
	
	private void monchromeRedizePixel(Pixel pixel) {
		pixel.green = 0;
		pixel.blue = 0;
	}
}

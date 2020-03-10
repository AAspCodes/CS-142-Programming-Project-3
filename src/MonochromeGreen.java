/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that removes all color but Green.
 */

public class MonochromeGreen implements Filter {
	public void filter(PixelImage theImage) {
		Pixel[][] data = theImage.getData();

		for (int row = 0; row < theImage.getHeight(); row++) {
			for (int col = 0; col < theImage.getWidth(); col++) {				
				monchromeGreenizePixel(data[row][col]);
			}
		}
		theImage.setData(data);
	}
	
	private void monchromeGreenizePixel(Pixel pixel) {
		pixel.red = 0;
		pixel.blue = 0;
	}
}

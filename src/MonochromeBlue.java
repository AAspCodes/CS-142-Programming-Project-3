/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that removes all color but Blue.
 */

public class MonochromeBlue implements Filter {
	public void filter(PixelImage theImage) {
		Pixel[][] data = theImage.getData();

		for (int row = 0; row < theImage.getHeight(); row++) {
			for (int col = 0; col < theImage.getWidth(); col++) {				
				monchromeBlueizePixel(data[row][col]);
			}
		}
		theImage.setData(data);
	}
	
	private void monchromeBlueizePixel(Pixel pixel) {
		pixel.red = 0;
		pixel.green = 0;
	}
}

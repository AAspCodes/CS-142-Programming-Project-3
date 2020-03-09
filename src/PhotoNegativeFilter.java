/**
 * @author Anthony Asp, Emily
 * 
 * Filter that converts image to a photo negative of itself.
 */

public class PhotoNegativeFilter implements Filter {
	public void filter(PixelImage theImage) {
		Pixel[][] data = theImage.getData();

		for (int row = 0; row < theImage.getHeight(); row++) {
			for (int col = 0; col < theImage.getWidth(); col++) {				
				invertPixel(data[row][col]);
			}
		}
		theImage.setData(data);
	}
	
	private void invertPixel(Pixel pixel) {
		pixel.red = 255 - pixel.red;
		pixel.green = 255 - pixel.green;
		pixel.blue = 255 - pixel.blue;
	}
}

/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter averages all three color values in a pixel, makes the images all grey.
 */

public class GreyScaleFilter implements Filter {
	public void filter(PixelImage theImage) {
		Pixel[][] data = theImage.getData();

		for (int row = 0; row < theImage.getHeight(); row++) {
			for (int col = 0; col < theImage.getWidth(); col++) {				
				greyScalePixel(data[row][col]);
			}
		}
		theImage.setData(data);
	}
	
	private void greyScalePixel(Pixel pixel) {
		int total = pixel.red + pixel.green + pixel.blue;
		total = (int)(total / 3.0);
		pixel.red = total;
		pixel.green = total;
		pixel.blue = total;
	}
}

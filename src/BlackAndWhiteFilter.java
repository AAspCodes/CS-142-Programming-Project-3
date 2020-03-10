/**
 * @author Anthony Asp, Emily Lott
 * 
 * Filter that averages the pixel value and then if above 125.7 makes the pixel all White
 * and if the average is below 125.7 it makes the pixel all Black.
 */

public class BlackAndWhiteFilter implements Filter {
	public void filter(PixelImage theImage) {
		Pixel[][] data = theImage.getData();

		for (int row = 0; row < theImage.getHeight(); row++) {
			for (int col = 0; col < theImage.getWidth(); col++) {				
				blackAndWhitePixel(data[row][col]);
			}
		}
		theImage.setData(data);
	}
	
	private void blackAndWhitePixel(Pixel pixel) {
		int total = pixel.red + pixel.green + pixel.blue;
		double average = total / 3.0;
		if (average >= 127.5) {
			total = 255;
		} else {
			total = 0;
		}
		pixel.red = total;
		pixel.green = total;
		pixel.blue = total;
	}
}

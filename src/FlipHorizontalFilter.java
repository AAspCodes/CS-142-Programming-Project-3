/**
 * Filter that flips the image horizontally. This class is COMPLETE. Don't
 * change it. But model your other classes (such as FlipVerticalFilter) after
 * it.
 */

public class FlipHorizontalFilter implements Filter {
	public void filter(PixelImage theImage) {
		Pixel[][] data = theImage.getData();

		for (int row = 0; row < theImage.getHeight(); row++) {
			for (int col = 0; col < theImage.getWidth() / 2; col++) {
				Pixel temp = data[row][col];
				data[row][col] = data[row][theImage.getWidth() - col - 1];
				data[row][theImage.getWidth() - col - 1] = temp;
			}
		}
		theImage.setData(data);
	}
}

import java.awt.image.*;
import java.util.Arrays;

/**
 * Provides an interface to a picture as an array of Pixels
 */
public class PixelImage {
	private BufferedImage myImage;
	private int width;
	private int height;

	/**
	 * Map this PixelImage to a real image
	 * 
	 * @param bi The image
	 */
	public PixelImage(BufferedImage bi) {
		// initialise instance variables
		this.myImage = bi;
		this.width = bi.getWidth();
		this.height = bi.getHeight();
	}

	/**
	 * Return the width of the image
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Return the height of the image
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Return the BufferedImage of this PixelImage
	 */
	public BufferedImage getImage() {
		return this.myImage;
	}

	/**
	 * Return the image's pixel data as an array of Pixels. The first coordinate is
	 * the x-coordinate, so the size of the array is [width][height], where width
	 * and height are the dimensions of the array
	 * 
	 * @return The array of pixels
	 */
	public Pixel[][] getData() {
		Raster r = this.myImage.getRaster();
		Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
		int[] samples = new int[3];

		for (int row = 0; row < r.getHeight(); row++) {
			for (int col = 0; col < r.getWidth(); col++) {
				samples = r.getPixel(col, row, samples);
				Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
				data[row][col] = newPixel;
			}
		}

		return data;
	}

	/**
	 * Set the image's pixel data from an array. This array matches that returned by
	 * getData(). It is an error to pass in an array that does not match the image's
	 * dimensions or that has pixels with invalid values (not 0-255)
	 * 
	 * @param data The array to pull from
	 */
	public void setData(Pixel[][] data) {
		int[] pixelValues = new int[3]; // a temporary array to hold r,g,b
										// values
		WritableRaster wr = this.myImage.getRaster();

		if (data.length != wr.getHeight()) {
			throw new IllegalArgumentException("Array size does not match");
		} else if (data[0].length != wr.getWidth()) {
			throw new IllegalArgumentException("Array size does not match");
		}

		for (int row = 0; row < wr.getHeight(); row++) {
			for (int col = 0; col < wr.getWidth(); col++) {
				pixelValues[0] = data[row][col].red;
				pixelValues[1] = data[row][col].green;
				pixelValues[2] = data[row][col].blue;
				wr.setPixel(col, row, pixelValues);
			}
		}
	}

	public void computeSummingFilter(int[][] weights, int scaleFactor) {
		int weightsOffset = weights.length / 2;
		
		Pixel[][] data = this.getData();
		Pixel[][] newData = copyImageData(data, weightsOffset);

		// compute each color
		for (int row = weightsOffset; row < this.getHeight() - weightsOffset; row++) {
			for (int col = weightsOffset; col < this.getWidth() - weightsOffset; col++) {
				int adjustedRow = row - weightsOffset;
				int adjustedCol = col - weightsOffset;
				
				// red
				int red = computePixel(data, adjustedRow, adjustedCol, weights, scaleFactor, 0);
				// green
				int green = computePixel(data, adjustedRow, adjustedCol, weights, scaleFactor, 1);
				// blue
				int blue = computePixel(data, adjustedRow, adjustedCol, weights, scaleFactor, 2);
				newData[row][col] = new Pixel(red,green,blue);
				
			}
		}
		this.setData(newData);
	}

	public void computeMedianFilter(int borderWidth, int filterWidth) {
		Pixel[][] data = this.getData();
		Pixel[][] newData = copyImageData(data, borderWidth);

		for (int row = borderWidth; row < this.getHeight() - borderWidth; row++) {
			for (int col = borderWidth; col < this.getWidth() - borderWidth; col++) {
				int adjustedRow = row - borderWidth;
				int adjustedCol = col - borderWidth;
				
				// red
				int red = computePixel(data, adjustedRow, adjustedCol, filterWidth, 0);
				// green
				int green = computePixel(data, adjustedRow, adjustedCol, filterWidth, 1);
				// blue
				int blue = computePixel(data, adjustedRow, adjustedCol, filterWidth, 2);
				
				newData[row][col] = new Pixel(red, green, blue);
			}
		}
		this.setData(newData);
	}
	
	// for the summing filters
	private static int computePixel(Pixel[][] data, int adjustedRow, int adjustedCol, int[][] weights,
			int scaleFactor, int color) {

		int newValue = 0;
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights[0].length; j++) {
				int weight = weights[i][j];
				int value = getColor(data[adjustedRow + i][adjustedCol + j], color);

				newValue += value * weight;
			}
		}
		newValue /= scaleFactor;
		
		if (newValue > 255) {
			return 255;
		} else if (newValue < 0) {
			return 0;
		}
		return newValue;
	}
	
	// for the median filters
	private static int computePixel(Pixel[][] data, int adjustedRow, int adjustedCol, int filterWidth, int color) {

		int[] neighbors = new int[filterWidth * filterWidth];

		for (int i = 0; i < filterWidth; i++) {
			for (int j = 0; j < filterWidth; j++) {
				int value = getColor(data[adjustedRow + i][adjustedCol + j], color);
				neighbors[i * filterWidth + j] = value;
			}
		}

		return findMedian(neighbors);
	}

	private static int findMedian(int[] neighbors) {
		Arrays.sort(neighbors);
		int val = neighbors[neighbors.length / 2];
		return val;
	}

	
	private Pixel[][] copyImageData(Pixel[][] data, int offset) {
		int width = this.getWidth();
		int height = this.getHeight();
		
		Pixel[][] newData = new Pixel[height][width];
		
		// top
		for (int i = 0; i < offset; i++) {
			for (int j = 0; j < width; j++) {
				newData[i][j] = clone(data[i][j]);
			}
		}
		
		// sides
		for (int i = offset; i < height - offset; i++) {
			for (int j = 0; j < offset; j++) {
				newData[i][j] = clone(data[i][j]);
				newData[i][width-j-1] = clone(data[i][width-j-1]);
			}
		}
		
		// bottom
		for (int i = height-offset; i < height; i++) {
			for (int j = 0; j < width; j++) {
				newData[i][j] = clone(data[i][j]);
			}
		}
		return newData;
	}
	
	private Pixel clone(Pixel pixel) {
		return new Pixel(pixel.red, pixel.green, pixel.blue);
	}

	private static int getColor(Pixel pixel, int color) {
		switch (color) {
		case 0:
			return pixel.red;
		case 1:
			return pixel.green;
		default:
			return pixel.blue;
		}
	}
}

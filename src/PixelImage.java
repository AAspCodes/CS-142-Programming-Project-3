import java.awt.image.*;

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
	 * @param bi
	 *            The image
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
	 * Return the image's pixel data as an array of Pixels. The first coordinate
	 * is the x-coordinate, so the size of the array is [width][height], where
	 * width and height are the dimensions of the array
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
	 * Set the image's pixel data from an array. This array matches that
	 * returned by getData(). It is an error to pass in an array that does not
	 * match the image's dimensions or that has pixels with invalid values (not
	 * 0-255)
	 * 
	 * @param data
	 *            The array to pull from
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

	// add a method to compute a new image given weighted averages
	public void computeFilter(Pixel[][] data, int[][] weights, int scaleFactor) {
		
		for (int row = 1; row < data.length - 1; row++) {
			for (int col = 1 ; col < data[0].length - 1; col++) {
				// red
				computePixel(data, row, col, weights, scaleFactor, 0);
				// green
				computePixel(data, row, col, weights, scaleFactor, 1);
				// blue
				computePixel(data, row, col, weights, scaleFactor, 3);
			}
		}
		
	}
	
	public static void computePixel(Pixel[][] data, int row, int col, int[][] weights, int scaleFactor, int color) {
		
		int newValue = 0;
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0;j < weights[0].length ; j++) {
				int weight = weights[i][j];
				int value = getColor(data[row - 1 + i][col - 1 + j], color);
				newValue += value * weight;
			}
		}
		
		newValue /= scaleFactor;

		setColor(data[row][col], color, newValue);
		
	}
	
	public static int getColor(Pixel pixel, int color) {
		switch (color) {
		case 0:
			return pixel.red;
		case 1:
			return pixel.green;
		case 2:
			return pixel.blue;
		default:
			assert(1==1);
			return 0;
		}
	}
	
	
	public static void setColor(Pixel pixel, int color, int newValue) {
		
		if (newValue > 255) {
			newValue = 255;
		} else if (newValue < 0){
			newValue = 0;
		}
		
		switch (color) {
		case 0:
			pixel.red = newValue;
			break;
		case 1:
			pixel.green = newValue;
			break;
		case 2:
			pixel.blue = newValue;
			break;
		default:
			// TODO throw error!!
		}
		
	}
	
	
}





















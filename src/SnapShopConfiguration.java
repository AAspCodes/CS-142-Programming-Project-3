// Write your short report here (-2 if there is no report)
// TODO Write a Report!!!
/**
 * A class to configure the SnapShop application
 * 
 * @author Anthony Asp, Emily Lott
 * @version March 3, 2020
 */
public class SnapShopConfiguration {
	/**
	 * Method to configure the SnapShop. Call methods like addFilter and
	 * setDefaultFilename here.
	 * 
	 * @param theShop
	 *            A pointer to the application
	 */
	public static void configure(SnapShop theShop) {

		theShop.setDefaultFilename("/Users/pro/Documents/ProgrammingFiles/Java/eclipse/PP3/src/billg.jpg");
		theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
		theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
		theShop.addFilter(new PhotoNegativeFilter(), "Photo Negative");
		theShop.addFilter(new GaussianFilter(), "Gaussian Filter");
		theShop.addFilter(new LaplacianFilter(), "Laplacian Filter");
		theShop.addFilter(new UnsharpMaskingFilter(), "Unsharp Masking Filter");
		theShop.addFilter(new EdgyFilter(), "Edgy Filter");
		theShop.addFilter(new Gauss5x5Filter(), "Gauss 5x5 Filter");
		theShop.addFilter(new Laplacian5x5Filter(), "Laplacian 5x5 Filter");
		theShop.addFilter(new Median3x3Filter(), "Median 3x3 Filter");
		theShop.addFilter(new Median5x5Filter(), "Median 5x5 Filter");
		theShop.addFilter(new Median7x7Filter(), "Median 7x7 Filter");
		
		// add your other filters below
	}
}

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
		theShop.addFilter(new UnsharpMasking3x3Filter(), "Unsharp Masking 3x3 Filter");
		theShop.addFilter(new Edgy3x3Filter(), "Edgy 3x3 Filter");
		theShop.addFilter(new Mean3x3Filter(), "Mean 3x3 Filter");
		theShop.addFilter(new Mean5x5Filter(), "Mean 5x5 Filter");
		theShop.addFilter(new Mean7x7Filter(), "Mean 7x7 Filter");
		theShop.addFilter(new Gaussian3x3Filter(), "Gaussian 3x3 Filter");
		theShop.addFilter(new Gaussian5x5Filter(), "Gaussian 5x5 Filter");
		theShop.addFilter(new StrictLaplacian3x3Filter(), "Strict Laplacian 3x3 Filter");
		theShop.addFilter(new Laplacian3x3Filter(), "Laplacian 3x3 Filter");
		theShop.addFilter(new Laplacian5x5Filter(), "Laplacian 5x5 Filter");
		theShop.addFilter(new Laplacian7x7Filter(), "Laplacian 7x7 Filter");
		theShop.addFilter(new Laplacian9x9Filter(), "Laplacian 9x9 Filter");
		theShop.addFilter(new Median3x3Filter(), "Median 3x3 Filter");
		theShop.addFilter(new Median5x5Filter(), "Median 5x5 Filter");
		theShop.addFilter(new Median7x7Filter(), "Median 7x7 Filter");
		theShop.addFilter(new AwesomeFilter(), "Awesome(but slow) Filter");
		
	}
}

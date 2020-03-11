/**
 * 
 * @author Anthony Asp, Emily Plott
 * 
 * this is a testing filter to look for speed improvements that can
 *  be made without adding more overhead in each filter.
 *  
 *  Surpisingly, We were unble to make much progress, 13.5 seconds
 *  on anthony's computer was the average for a 622x1000 pixel image.
 *  
 *  We tried replaceinng the getColor method with 3 seperate compute pixel method(one for each color).
 *  That only made very marginal improvements.
 *  
 *  We tried completely replaceing the pixel class with an int array of length 3.
 *  That actually slowed things down by 3 seconds.
 *  
 *  Perhaps using hash tables could create some improvements.
 *  switching from int to unsigned byte would probably improve speed. 
 *
 */

public class SpeedTestFilter implements Filter {

	
	public void filter(PixelImage theImage) {
		long totalTime = 0;
		
		
		Gaussian5x5Filter gf = new Gaussian5x5Filter();
		for (int i = 0; i < 100; i++) {
			long start = System.nanoTime();
			gf.filter(theImage);
			long end = System.nanoTime();
			totalTime += end-start;
		}
		
		System.out.println(totalTime / 1000000000.0);

	}

}


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

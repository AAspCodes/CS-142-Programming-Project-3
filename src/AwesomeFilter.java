
public class AwesomeFilter implements Filter {

	@Override
	public void filter(PixelImage theImage) {
		Median7x7Filter medf = new Median7x7Filter();
		for (int i = 0; i<4; i++) {
			medf.filter(theImage);
		}
		Laplacian9x9Filter lapf = new Laplacian9x9Filter();
		lapf.filter(theImage);
	}

}

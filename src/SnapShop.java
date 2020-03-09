import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

/**
 * A PhotoShop like application for filtering images This class is COMPLETE.
 * Don't change it.
 */
public class SnapShop extends JFrame {
	FileLoader fl;
	FileSaver fs; // This was added to implement file saving.
	FilterButtons fb;
	ImagePanel ip;
	RenderingDialog rd;

	/**
	 * Constructor for objects of class SnapShop
	 */
	public SnapShop() {
		super("CSC 142 - SnapShop");
		// Take the default look of the computer (windows on a windows machine,
		// etc...)
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			// crash if it didn't work
			throw new RuntimeException(
					"Could not set the default look and feel");
		}

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ip = new ImagePanel(this);
		this.getContentPane().add(ip, BorderLayout.CENTER);

		fl = new FileLoader(this);
		this.getContentPane().add(fl, BorderLayout.NORTH);
		
		// this was added to implement file saving
		fs = new FileSaver(this);
		this.getContentPane().add(fs, BorderLayout.SOUTH);

		fb = new FilterButtons(this);
		this.getContentPane().add(fb, BorderLayout.WEST);

		rd = new RenderingDialog(this);

		SnapShopConfiguration.configure(this);

		this.pack();
		this.setVisible(true);
	}

	private class FileLoader extends JPanel implements ActionListener {
		private JTextArea filenameBox;
		private ImagePanel ip;
		private SnapShop s;

		public FileLoader(SnapShop s) {
			super(new FlowLayout());

			this.s = s;
			this.ip = s.getImagePanel();

			add(new JLabel("Enter loading file name: "));

			filenameBox = new JTextArea(1, 50);
			add(filenameBox);

			JButton loadButton = new JButton("Load");
			loadButton.addActionListener(this);
			add(loadButton);
		}

		public void actionPerformed(ActionEvent e) {
			String filename = filenameBox.getText().trim();
			try {
				ip.loadImage(filename);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(s, "Could not open file",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		public void setDefaultLoadingFilename(String filename) {
			filenameBox.setText(filename);
		}
	}
	
	/**
	 *  We added this to allow Picture saving.
	 *  It was implemented from a copy of File Loader.
	 *  We attempted to make minimal changes in service of readability.
	 */
	private class FileSaver extends JPanel implements ActionListener {
		private JTextArea filenameBox;
		private ImagePanel ip;
		private SnapShop s;

		public FileSaver(SnapShop s) {
			super(new FlowLayout());

			this.s = s;
			this.ip = s.getImagePanel();

			add(new JLabel("Enter Saving file name: "));

			filenameBox = new JTextArea(1, 50);
			add(filenameBox);

			JButton loadButton = new JButton("Save");
			loadButton.addActionListener(this);
			add(loadButton);
		}

		public void actionPerformed(ActionEvent e) {
			String filename = filenameBox.getText().trim();
			try {
				ip.saveImage(filename);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(s, "Unable to save File.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		public void setDefaultSavingFilename(String filename) {
			filenameBox.setText(filename);
		}
	}
	
	

	private class FilterButtons extends JPanel {
		private SnapShop s;
		private ImagePanel ip;

		public FilterButtons(SnapShop s) {
			// 0 rows since we don't know how many buttons there are
			setLayout(new GridLayout(0, 1, 3, 3));
			this.s = s;
			this.ip = s.getImagePanel();
			;
		}

		public void addFilter(Filter f, String description) {
			JButton filterButton = new JButton(description);
			filterButton.addActionListener(new FilterButtonListener(this, f));
			add(filterButton);
			s.pack();
		}

		public void applyFilter(Filter f) {
			try {
				ip.applyFilter(f);
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}

		private class FilterButtonListener implements ActionListener {
			private FilterButtons fb;
			private Filter f;

			public FilterButtonListener(FilterButtons fb, Filter f) {
				this.fb = fb;
				this.f = f;
			}

			public void actionPerformed(ActionEvent e) {
				fb.applyFilter(f);
			}
		}
	}

	private class ImagePanel extends JPanel {
		private BufferedImage bi;
		private SnapShop s;

		public ImagePanel(SnapShop s) {
			bi = null;
			this.s = s;
		}

		public void loadImage(String filename) {
			Image img = Toolkit.getDefaultToolkit().getImage(filename);
			try {
				MediaTracker tracker = new MediaTracker(this);
				tracker.addImage(img, 0);
				tracker.waitForID(0);
			} catch (Exception e) {
			}
			int width = img.getWidth(this);
			int height = img.getHeight(this);
			bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D biContext = bi.createGraphics();
			biContext.drawImage(img, 0, 0, null);
			setPreferredSize(new Dimension(bi.getWidth(), bi.getHeight()));
			revalidate();
			s.pack();
			s.repaint();
		}
		
		/**
		 * This method was added to implement image saving. 
		 */
		public void saveImage(String filename) throws Exception {
			try { 
				ImageIO.write(bi, "jpg", new File(filename));
			} catch (Exception e) {
				throw e;
			}
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (bi != null)
				g.drawImage(bi, 0, 0, this);
		}

		public void applyFilter(Filter f) {
			if (bi == null)
				return;

			PixelImage newImage = new PixelImage(bi);
			s.showWaitDialog();
			f.filter(newImage);
			s.hideWaitDialog();
			bi = newImage.getImage();
			repaint();
		}
	}

	private class RenderingDialog extends Frame {
		public RenderingDialog(JFrame parent) {
			super("Message");
			Point p = parent.getLocation();
			setLocation((int) p.getX() + 100, (int) p.getY() + 100);
			Label label = new Label("Applying filter, please wait...",
					JLabel.CENTER);
			this.setLayout(new BorderLayout());
			this.add(label, BorderLayout.CENTER);
		}
	}

	/**
	 * Add a filter to the SnapShop interface. Creates a button and links it to
	 * the filter.
	 * 
	 * @param f
	 *            The filter to apply
	 * @param description
	 *            English description of the filter
	 */
	public void addFilter(Filter f, String description) {
		fb.addFilter(f, description);
	}

	/**
	 * Display a message box telling the user that the image is being processed
	 */
	protected void showWaitDialog() {
		rd.pack();
		rd.setVisible(true);
	}

	/**
	 * The image has been processed. Hide the message box.
	 */
	protected void hideWaitDialog() {
		rd.setVisible(false);
	}

	/**
	 * Return the image panel of this SnapShop
	 */
	protected ImagePanel getImagePanel() {
		return ip;
	}

	/**
	 * Set the default filename to appear in the box
	 * 
	 * @param filename
	 *            The filename
	 *   
	 * This method name was changed to differentiate it from the new method
	 * "setDefaultSavingFilename", the method call was also changed in SnapShopConfiguration.java.
	 * no changes to functionality were made.
	 */
	public void setDefaultLoadingFilename(String filename) {
		fl.setDefaultLoadingFilename(filename);
	}
	
	/** 
	 * this method was added to implement file saving.
	 * A corresponding method call was also added to SnapShopConfiguration.java.
	 */
	public void setDefaultSavingFilename(String filename) {
		fs.setDefaultSavingFilename(filename);
	}

	/**
	 * Open a SnapShop
	 */
	public static void main(String[] args) {
		SnapShop s = new SnapShop();
	}
}

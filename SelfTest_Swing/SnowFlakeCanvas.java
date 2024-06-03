import java.awt.*;
import java.util.Random;


/**
 * SnowFlakeCanvas. Canvas to show snow flakes.
 * @author veit
 */
@SuppressWarnings("serial")
public class SnowFlakeCanvas extends Canvas {
	private int minBeamLen;    // minimum beam length
	private int maxBeamLen;    // maximum beam length
	private int numFlakes;     // number of snow flakes
	private Color flakeColor;  // color of snow flakes

	/**
	 * Paints the snowflakes.
	 */
	public void paint(Graphics gr) {
		int width = getSize().width;
		int height = getSize().height;

		for (int i = 0; i < numFlakes; i++) {
			// set center coordinates of the flake within the canvas
			int x = randomInt(0, width);
			int y = randomInt(0, height);
			// set beam length
			int beamLen = randomInt(minBeamLen, maxBeamLen);

			// set color of flake
			if (flakeColor != null)
				gr.setColor(flakeColor);
			else
				gr.setColor(randomColor());

			drawStar(gr, x, y, beamLen);
		}
	}

	/*
	 * Recursive method to draw a snow flake.
	 */
	private void drawStar(Graphics canvas, int x, int y, int beamLen) {
		if (beamLen < 2)
			return;

		int endX, endY;
		for (int i = 0; i < 6; i++) {
			endX = x + (int) (beamLen * Math.cos((2 * Math.PI / 6) * i));
			endY = y - (int) (beamLen * Math.sin((2 * Math.PI / 6) * i));
			canvas.drawLine(x, y, endX, endY);
			drawStar(canvas, endX, endY, beamLen / 3);
		}
	}

	/*
	 * Helper to return a random integer between min and max (inclusively).
	 */
	private static int randomInt(int min, int max) {
		Random randomizer = new Random();
		int randomNumber = randomizer.nextInt(max - min + 1) + min;
		return randomNumber;
	}

	/*
	 * Helper to return a random color.
	 */
	private static Color randomColor() {
		Random randomizer = new Random();
		int r = randomizer.nextInt(256);
		int g = randomizer.nextInt(256);
		int b = randomizer.nextInt(256);
		return new Color(r, g, b);
	}

	// ************************* setter methods ********************
	
	public void setMinBeamLen(int minBeamLen) {
		this.minBeamLen = minBeamLen;
	}

	public void setMaxBeamLen(int maxBeamLen) {
		this.maxBeamLen = maxBeamLen;
	}

	public void setNumFlakes(int numFlakes) {
		this.numFlakes = numFlakes;
	}

	public void setFlakeColor(Color flakeColor) {
		this.flakeColor = flakeColor;
	}

}

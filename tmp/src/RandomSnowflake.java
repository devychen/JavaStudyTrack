import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import java.lang.Math;
import java.util.Random;

public class RandomSnowflake extends Applet {
    /**
     * Draw a snowflake-like star at coordinate x, y on canvas.
     * The beams of the star are beamLen pixels long.
     */
    private void drawStar(Graphics canvas, int x, int y, int beamLen) {
        int endX;
        int endY;

        if (beamLen <= 0) {
            return;
        }

        for(int i = 0; i < beamLen; i++) {
            endX = x + (int) (beamLen * Math.cos(((2 * Math.PI) / 6) * i));
            endY = y - (int) (beamLen * Math.sin(((2 * Math.PI) / 6) * i));

            canvas.drawLine(x, y, endX, endY);

            // recursively draw the star
            drawStar(canvas, endX, endY, beamLen / 3); // 3 manually

        }

    }


    /**
     * Paint method of the applet. Gets called whenever the applet needs a redraw
     *
     * @param gr - The canvas to draw the applets content on
     */

    public void paint(Graphics gr) {
        int width = getSize().width;
        int height = getSize().height;
        int min = Math.min(width, height); // return minimal of two numbers.

        // Set background and pen color
        setBackground(Color.white); // interface, void

        // Calculate the maximal Beam length that adopted to the window
        int maxLen = min / 5; // manually set

        // Random colour
        Random rand = new Random();

        int numSnow = rand.nextInt(20) + 1;

        // Draw a star, in the middle
        for (int i = 0; i < numSnow; i++) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            int beamLen = rand.nextInt(maxLen);
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            Color randomColor = new Color(r, g, b);
            gr.setColor(randomColor);

            drawStar(gr, x, y, beamLen);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RandomSnowflake");
        RandomSnowflake snowflake = new RandomSnowflake();
        frame.add(snowflake);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



}

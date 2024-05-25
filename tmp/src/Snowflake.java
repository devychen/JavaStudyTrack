import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import java.lang.Math;
import java.util.Random;

public class Snowflake extends Applet {
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
        gr.setColor(Color.blue); // Graphics, abstract void

        // Calculate the maximal Beam length that adopted to the window
        int maxLen = min / 5; // manually set

        // Draw a star, in the middle
        drawStar(gr, width / 2, height / 2, maxLen);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snowflake");
        Snowflake snowflake = new Snowflake();
        frame.add(snowflake);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

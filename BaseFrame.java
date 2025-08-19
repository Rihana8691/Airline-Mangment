package gitairlines;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected BaseFrame() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    }

    protected void setWindowProperties(int width, int height) {
        setSize(width, height);
        setLocation(400, 200);
        setVisible(true);
    }
}

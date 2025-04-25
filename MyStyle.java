package Quarter2;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

/**
 *
 * @author Thaddeus
 */
public class MyStyle {
    public void changeFontRecursive(Container root, Font font) {
        for (Component c : root.getComponents()) {
            c.setFont(font);
            if (c instanceof Container) {
                changeFontRecursive((Container) c, font);
            }
        }
    }
}

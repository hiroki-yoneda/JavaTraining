package dc.dc1_3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RightClickMenu extends MouseAdapter {
    private DigitalClock digitalClock;
    private MouseEvent startMouse = null;

    RightClickMenu(DigitalClock digitalClock) {
        this.digitalClock = digitalClock;
    }

    public void mouseReleased(MouseEvent e) {
        if (1 == e.getButton()) {
            digitalClock.setLocation(digitalClock.getLocation().x + e.getX() - startMouse.getX(),
                    digitalClock.getLocation().y + e.getY() - startMouse.getY());
            startMouse = null;
        }
        else if (3 == e.getButton()) {
            digitalClock.popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (null != startMouse) {
        digitalClock.setLocation(digitalClock.getLocation().x + e.getX() - startMouse.getX(),
                digitalClock.getLocation().y + e.getY() - startMouse.getY());
        }
    }

    public void mousePressed(MouseEvent e) {
        if (1 == e.getButton()) {
            startMouse = e;
        }
        else if (3 == e.getButton()) {
            digitalClock.popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
}

package org.harrynoob.hbot.callbacks;

import java.awt.*;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 24-2-13
 * Time: 11:28
 */
public class PaintCallback {

    public static void callback(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(Color.black);
        g.drawString("yap it works bitches", 30, 30);
    }

}

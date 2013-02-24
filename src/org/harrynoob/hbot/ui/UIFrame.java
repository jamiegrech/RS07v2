package org.harrynoob.hbot.ui;

import org.harrynoob.hbot.util.Settings;
import org.harrynoob.hbot.util.WebCrawler;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 23-2-13
 * Time: 23:12
 */
public class UIFrame extends JFrame implements Settings, AppletStub {

    private static final HashMap<String, String> parameters = WebCrawler.crawl();
    private Applet app;

    public UIFrame(Applet loader) {
        this.setTitle("hBot - v" + version);
        this.setResizable(false);
        loader.setStub(this);
        loader.init();
        loader.start();
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        JPanel theGame = new JPanel(new BorderLayout());
        theGame.setPreferredSize(new Dimension(768, 560));
        setPreferredSize(new Dimension(768, 658));
        theGame.add(loader);
        getContentPane().add(loader, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(769, 531);
    }

    public void addApplet(Applet a) {
    }

    @Override
    public final URL getDocumentBase() {
        try {
            return new URL(PAGE_URL);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public final URL getCodeBase() {
        try {
            return new URL(PAGE_URL);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public final String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public final AppletContext getAppletContext() {
        return null;
    }

    @Override
    public void appletResize(int width, int height) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

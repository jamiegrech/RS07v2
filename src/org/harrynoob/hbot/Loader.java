package org.harrynoob.hbot;

import org.harrynoob.hbot.ui.UIFrame;
import org.harrynoob.hbot.util.Downloader;
import org.harrynoob.hbot.util.Extractor;
import org.harrynoob.hbot.util.Settings;
import org.harrynoob.hbot.util.WebCrawler;

import java.applet.Applet;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: harrynoob
 * Date: 23-2-13
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
public class Loader implements Settings {

    public static void main(String[] args) {
        Downloader.downloadJar();
        new Extractor().extractJar();
        URLClassLoader u = getClassLoader();
        try {
            Class<?> clazz = Class.forName("client", true, u);
            Class<? extends Applet> appClazz = clazz.asSubclass(Applet.class);
            Applet app = appClazz.newInstance();
            UIFrame frame = new UIFrame(app);
            frame.setVisible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static URLClassLoader getClassLoader() {
        try {
            return URLClassLoader.newInstance(new URL[] { new URL("file:" + SAVEDIR + "gamepack/")});
        } catch (Exception e) {
            return null;
        }
    }

}

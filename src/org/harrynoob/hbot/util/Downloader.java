package org.harrynoob.hbot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 23-2-13
 * Time: 23:28
 */
public class Downloader implements Settings {

    public static void downloadJar() {
        if(requiresUpdate()) {
            try {
                URL u = new URL(PAGE_URL + WebCrawler.get("gamepack"));
                u.openConnection();
                InputStream reader = u.openStream();
                FileOutputStream writer = new FileOutputStream(SAVEDIR + WebCrawler.get("gamepack"));
                byte[] buffer = new byte[153600];
                int bytesRead = 0;
                while ((bytesRead = reader.read(buffer)) > 0)
                {
                    writer.write(buffer, 0, bytesRead);
                    buffer = new byte[153600];
                }
                reader.close();
                writer.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean requiresUpdate() {
        File dir = new File(SAVEDIR);
        if(dir.mkdirs()) {
            return true;
        }
        for(File f : dir.listFiles()) {
            if(f.getName().equals(WebCrawler.get("gamepack"))) {
                return false;
            }
        }
        return true;
    }


}

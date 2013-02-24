package org.harrynoob.hbot.util;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 24-2-13
 * Time: 11:40
 */
public class Extractor implements Settings {

    public void extractJar(ZipFile zf) {
/*
        try {
            File saveDir = new File(SAVEDIR, "gamepack/");
            deleteFiles(saveDir);
            saveDir.mkdirs();
            JarFile jf = new JarFile(new File(SAVEDIR, WebCrawler.get("gamepack")));
            Enumeration<JarEntry> e = jf.entries();
            while(e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                InputStream is = jf.getInputStream(je);
                try {
                    File out = new File(saveDir, je.getName());
                    out.createNewFile();
                    BufferedWriter bw = new BufferedWriter(new FileWriter(out));
                    byte[] buf = new byte[2048];
                    int read = 0;
                    while((read = is.read(buf, 0, buf.length)) > 0) {
                        bw.write(new String(buf));
                    }
                    bw.close();
                    is.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        extractZip(zf);
    }

    public void extractZip(ZipFile zip) {
        try {
            String newPath = SAVEDIR + "gamepack/";
            new File(newPath).mkdir();
            Enumeration zipFileEntries = zip.entries();
            while (zipFileEntries.hasMoreElements())
            {
                ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
                String currentEntry = entry.getName();
                File destFile = new File(newPath, currentEntry);
                File destinationParent = destFile.getParentFile();
                destinationParent.mkdirs();
                if (!entry.isDirectory())
                {
                    BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
                    int currentByte;
                    byte data[] = new byte[2048];
                    FileOutputStream fos = new FileOutputStream(destFile);
                    BufferedOutputStream dest = new BufferedOutputStream(fos,2048);
                    while ((currentByte = is.read(data, 0, 2048)) != -1) {
                        dest.write(data, 0, currentByte);
                    }
                    dest.flush();
                    dest.close();
                    is.close();
                }
                if (currentEntry.endsWith(".zip"))
                {
                    extractZip(new ZipFile(destFile.getAbsolutePath()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteFiles(File dir) {
        for(File f : dir.listFiles()) {
            if(!f.delete()) {
                return false;
            }
        }
        return true;
    }

}

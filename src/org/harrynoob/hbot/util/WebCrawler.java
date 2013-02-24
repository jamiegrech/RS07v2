package org.harrynoob.hbot.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 23-2-13
 * Time: 22:32
 */
public class WebCrawler implements Settings {

    private static HashMap<String, String> hm = null;
    public static HashMap<String, String> crawl() {
        if(hm != null) {
            return hm;
        }
        hm = new HashMap<String, String>();
        try {
            Document d = Jsoup.connect(PAGE_URL).get();
            Element e = d.getElementById("deployJava");
            for(String s : e.toString().split("\n")) {
                if(s.contains("archive=")) {
                    hm.put("gamepack", s.replaceAll(REGEX1, "").replaceAll(REGEX2, "").split("=")[1]);
                }
                if(s.contains(PARAMREGEX)) {
                    String[] s1 = s.replaceAll(REGEX1, "").replaceAll(REGEX2, "").replaceAll(PARAMREGEX2, "").replaceAll(PARAMREGEX3, "").split(PARAMREGEX);
                    hm.put(s1[0].trim(), s1[1].trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
        hm.remove("seperate_jvm");
        hm.remove("java_arguments");
        return hm;
    }

    public static String get(String key) {
        if(hm == null) crawl();
        return hm.get(key);
    }

}

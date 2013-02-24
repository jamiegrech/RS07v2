package org.harrynoob.hbot.asm;

import org.harrynoob.hbot.asm.pattern.Paint;
import org.harrynoob.hbot.asm.pattern.Strings;
import org.harrynoob.hbot.util.Settings;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 23-2-13
 * Time: 23:53
 */
public class Updater implements Settings, Opcodes {

    private static final Pattern[] patterns = new Pattern[] { new Strings(), new Paint() };

    public void update() {
        File dir = new File(SAVEDIR + "gamepack/");
        for(File f : dir.listFiles()) {
            if(f.getName().endsWith(".class")) {
                try {
                    FileInputStream fis = new FileInputStream(f);
                    ClassReader cr = new ClassReader(fis);
                    ClassNode cn = new ClassNode();
                    cr.accept(cn, ASM4);
                    for(Pattern p : patterns) {
                        if(p.accept(cn)) {
                            System.out.println(p.getName() + " detected: " + cn.name);
                            if(p.getAssociatedHook() != null) {
                                cn = p.getAssociatedHook().apply(cn);
                                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
                                cn.accept(cw);
                                FileOutputStream fos = new FileOutputStream(f);
                                fos.write(cw.toByteArray());
                                fos.flush();
                                fos.close();
                            }
                        }
                    }
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

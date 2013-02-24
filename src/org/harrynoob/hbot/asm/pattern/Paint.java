package org.harrynoob.hbot.asm.pattern;

import org.harrynoob.hbot.asm.Hook;
import org.harrynoob.hbot.asm.Pattern;
import org.harrynoob.hbot.asm.hooks.PaintHook;
import org.objectweb.asm.tree.ClassNode;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 24-2-13
 * Time: 11:18
 */
public class Paint implements Pattern {
    @Override
    public boolean accept(ClassNode cn) {
        return cn.superName.equals("java/applet/Applet")
                && cn.interfaces.contains("java/lang/Runnable");
    }

    @Override
    public Hook getAssociatedHook() {
        return new PaintHook();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return "PaintHook";  //To change body of implemented methods use File | Settings | File Templates.
    }
}

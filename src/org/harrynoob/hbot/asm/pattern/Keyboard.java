package org.harrynoob.hbot.asm.pattern;

import org.harrynoob.hbot.asm.Hook;
import org.harrynoob.hbot.asm.Pattern;
import org.objectweb.asm.tree.ClassNode;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 24-2-13
 * Time: 11:32
 */
public class Keyboard implements Pattern {
    @Override
    public boolean accept(ClassNode cn) {
        return cn.interfaces.contains("java/awt/event/KeyListener")
                && cn.interfaces.contains("java/awt/event/FocusListener");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Hook getAssociatedHook() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return "Keyboard";  //To change body of implemented methods use File | Settings | File Templates.
    }
}

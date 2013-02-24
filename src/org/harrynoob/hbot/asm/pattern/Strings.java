package org.harrynoob.hbot.asm.pattern;

import org.harrynoob.hbot.asm.Hook;
import org.harrynoob.hbot.asm.Pattern;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 24-2-13
 * Time: 0:01
 */
public class Strings implements Pattern {

    @Override
    public boolean accept(ClassNode cn) {
        int count = 0;
        for(Object o : cn.fields) {
            FieldNode fn = (FieldNode) o;
            if(fn.desc.contains("java/lang/String")) {
                count++;
            }
        }
        return count > 100;
    }

    @Override
    public Hook getAssociatedHook() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return "StringList";  //To change body of implemented methods use File | Settings | File Templates.
    }
}

package org.harrynoob.hbot.asm.hooks;

import org.harrynoob.hbot.asm.Hook;
import org.objectweb.asm.tree.*;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 24-2-13
 * Time: 11:20
 */
public class PaintHook implements Hook {
    @Override
    public String getName() {
        return "PaintHook";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ClassNode apply(ClassNode ori) {
        for(Object o : ori.methods.toArray()) {
            MethodNode mn = (MethodNode) o;
            if(mn.name.equals("update")) {
                ori.methods.remove(mn);
                InsnList nl = new InsnList();
                for(AbstractInsnNode n : mn.instructions.toArray()) {
                    if(n instanceof InsnNode && n.getOpcode() == RETURN) {
                        nl.add(new VarInsnNode(ALOAD, 1));
                        nl.add(new MethodInsnNode(INVOKESTATIC, "org/harrynoob/hbot/callbacks/PaintCallback", "callback", "(Ljava/awt/Graphics;)V"));
                    }
                    nl.add(n);
                }
                mn.instructions = nl;
                ori.methods.add(mn);
            }
        }
        return ori;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

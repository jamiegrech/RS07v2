package org.harrynoob.hbot.asm;

import org.objectweb.asm.tree.ClassNode;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 23-2-13
 * Time: 23:55
 */
public interface Pattern {
    public boolean accept(ClassNode cn);
    public Hook getAssociatedHook();
    public String getName();
}

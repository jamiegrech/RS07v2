package org.harrynoob.hbot.asm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 23-2-13
 * Time: 23:54
 */
public interface Hook extends Opcodes {
    public String getName();
    public ClassNode apply(ClassNode ori);
}

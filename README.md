# Test

```
❯ gradle test

RemapperTest > remapper() FAILED
    java.lang.ArrayIndexOutOfBoundsException: Index 65536 out of bounds for length 297
        at org.objectweb.asm.ClassReader.readLabel(ClassReader.java:2695)
        at org.objectweb.asm.ClassReader.createLabel(ClassReader.java:2711)
        at org.objectweb.asm.ClassReader.readTypeAnnotations(ClassReader.java:2777)
        at org.objectweb.asm.ClassReader.readCode(ClassReader.java:1929)
        at org.objectweb.asm.ClassReader.readMethod(ClassReader.java:1515)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:745)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:425)
        at remapper.bug.RemapperTest.remapper(RemapperTest.java:44)
```

When using CheckClassAdapter

```
❯ gradle test
RemapperTest > remapper() FAILED
    java.lang.IllegalArgumentException: Invalid end label (must be visited first)
        at org.objectweb.asm.util.CheckMethodAdapter.checkLabel(CheckMethodAdapter.java:1453)
        at org.objectweb.asm.util.CheckMethodAdapter.visitLocalVariableAnnotation(CheckMethodAdapter.java:996)
        at org.objectweb.asm.MethodVisitor.visitLocalVariableAnnotation(MethodVisitor.java:757)
        at org.objectweb.asm.commons.MethodRemapper.visitLocalVariableAnnotation(MethodRemapper.java:257)
        at org.objectweb.asm.ClassReader.readCode(ClassReader.java:2614)
        at org.objectweb.asm.ClassReader.readMethod(ClassReader.java:1515)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:745)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:425)
        at remapper.bug.RemapperTest.remapper(RemapperTest.java:42)

```
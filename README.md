# Test

```
❯ ./gradlew test

> Task :app:test FAILED

RemapperTest > calcite36() FAILED
    java.lang.ArrayIndexOutOfBoundsException: Index 65536 out of bounds for length 297
        at org.objectweb.asm.ClassReader.readLabel(ClassReader.java:2695)
        at org.objectweb.asm.ClassReader.createLabel(ClassReader.java:2711)
        at org.objectweb.asm.ClassReader.readTypeAnnotations(ClassReader.java:2777)
        at org.objectweb.asm.ClassReader.readCode(ClassReader.java:1929)
        at org.objectweb.asm.ClassReader.readMethod(ClassReader.java:1515)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:745)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:425)
        at remapper.bug.RemapperTest.runTest(RemapperTest.java:60)
        at remapper.bug.RemapperTest.calcite36(RemapperTest.java:36)

RemapperTest > calcite36WithCheck() FAILED
    java.lang.IllegalArgumentException: Invalid end label (must be visited first)
        at org.objectweb.asm.util.CheckMethodAdapter.checkLabel(CheckMethodAdapter.java:1453)
        at org.objectweb.asm.util.CheckMethodAdapter.visitLocalVariableAnnotation(CheckMethodAdapter.java:996)
        at org.objectweb.asm.MethodVisitor.visitLocalVariableAnnotation(MethodVisitor.java:757)
        at org.objectweb.asm.commons.MethodRemapper.visitLocalVariableAnnotation(MethodRemapper.java:257)
        at org.objectweb.asm.ClassReader.readCode(ClassReader.java:2614)
        at org.objectweb.asm.ClassReader.readMethod(ClassReader.java:1515)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:745)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:425)
        at remapper.bug.RemapperTest.runTest(RemapperTest.java:53)
        at remapper.bug.RemapperTest.calcite36WithCheck(RemapperTest.java:39)

RemapperTest > calcite35WithCheck() FAILED
    java.lang.IllegalArgumentException: Invalid start label (must be visited first)
        at org.objectweb.asm.util.CheckMethodAdapter.checkLabel(CheckMethodAdapter.java:1453)
        at org.objectweb.asm.util.CheckMethodAdapter.visitLocalVariableAnnotation(CheckMethodAdapter.java:995)
        at org.objectweb.asm.MethodVisitor.visitLocalVariableAnnotation(MethodVisitor.java:757)
        at org.objectweb.asm.commons.MethodRemapper.visitLocalVariableAnnotation(MethodRemapper.java:257)
        at org.objectweb.asm.ClassReader.readCode(ClassReader.java:2614)
        at org.objectweb.asm.ClassReader.readMethod(ClassReader.java:1515)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:745)
        at org.objectweb.asm.ClassReader.accept(ClassReader.java:425)
        at remapper.bug.RemapperTest.runTest(RemapperTest.java:53)
        at remapper.bug.RemapperTest.calcite35WithCheck(RemapperTest.java:32)

4 tests completed, 3 failed

```
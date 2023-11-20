# Test

```
❯ gradle test

> Task :app:test FAILED

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

1 test completed, 1 failed

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:test'.
> There were failing tests. See the report at: file:///Users/bob/foos/remapper-bug/app/build/reports/tests/test/index.html

* Try:
> Run with --scan to get full insights.

BUILD FAILED in 765ms
2 actionable tasks: 1 executed, 1 up-to-date
```
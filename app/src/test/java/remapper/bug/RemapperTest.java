/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package remapper.bug;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.util.CheckClassAdapter;

class RemapperTest {
  @Test void calcite35() throws IOException {
    runTest("SqlFunctions-1.35.0.class", false);
  }
  @Test void calcite35WithCheck() throws IOException {
    runTest("SqlFunctions-1.35.0.class", true);
  }

  @Test void calcite36() throws IOException {
    runTest("SqlFunctions-1.36.0.class", false);
  }
  @Test void calcite36WithCheck() throws IOException {
    runTest("SqlFunctions-1.36.0.class", true);
  }

  void runTest(String filename, boolean checkClass) throws IOException {
    byte[] bytecode = Files.readAllBytes(Paths.get("../" + filename));

    Remapper remapper = new Remapper() {};

    ClassReader classReader = new ClassReader(bytecode);
    ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    ClassVisitor classVisitor = checkClass ? new CheckClassAdapter(classWriter) : classWriter;

    ClassRemapper classRemapper = new ClassRemapper(classVisitor, remapper);

    classReader.accept(classRemapper, ClassReader.EXPAND_FRAMES);

    byte[] outputBytecode = classWriter.toByteArray();
    
    ClassReader classReader2 = new ClassReader(outputBytecode);
    ClassWriter classWriter2 = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    ClassVisitor visitor = new ClassVisitor(Opcodes.ASM9, classWriter2) {};
    classReader2.accept(visitor, ClassReader.EXPAND_FRAMES);

  }
}



package dev.anvilcraft.base.wenyan;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;

class WenyanEngineTest {
    @Test
    void runSimpleLoopExample() throws Exception {
        String source = Files.readString(Path.of("example", "天地，好在否.wy"), StandardCharsets.UTF_8);
        WenyanEngine.Result result = new WenyanEngine().execute(source);
        assertFalse(result.output().isBlank());
    }

    @Test
    void runFunctionExample() throws Exception {
        String source = Files.readString(Path.of("example", "乘算口訣.wy"), StandardCharsets.UTF_8);
        WenyanEngine.Result result = new WenyanEngine().execute(source);
        assertFalse(result.output().isBlank());
    }
}


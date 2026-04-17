package dev.anvilcraft.base;

import dev.anvilcraft.base.wenyan.WenyanEngine;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java -jar wenyan4j.jar <path-to-script.wy>");
            return;
        }

        Path scriptPath = Path.of(args[0]);
        String source = Files.readString(scriptPath, StandardCharsets.UTF_8);

        WenyanEngine engine = new WenyanEngine();
        WenyanEngine.Result result = engine.execute(source);
        if (!result.output().isBlank()) {
            System.out.print(result.output());
        }
    }
}
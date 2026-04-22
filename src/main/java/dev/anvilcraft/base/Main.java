package dev.anvilcraft.base;

import dev.anvilcraft.base.wenyan.WenyanEngine;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 文言脚本命令行入口。
 */
public class Main {
    /**
     * 工具类无需实例化。
     */
    private Main() {
    }

    /**
     * 从首个命令行参数读取并执行文言脚本。
     *
     * @param args 命令行参数，{@code args[0]} 为脚本路径
     * @throws Exception 读取文件或执行脚本失败时抛出
     */
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
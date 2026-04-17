package dev.anvilcraft.base.wenyan.extension;

import dev.anvilcraft.base.wenyan.annotation.WenyuanFunction;

public final class TestExtensionLibrary {
    private TestExtensionLibrary() {
    }

    @WenyuanFunction("倍之")
    public static int doubleValue(int x) {
        return x * 2;
    }
}


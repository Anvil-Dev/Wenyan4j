package dev.anvilcraft.base.wenyan.runtime;

final class BreakSignal extends RuntimeException {
    BreakSignal() {
        super(null, null, false, false);
    }
}


package dev.anvilcraft.base.wenyan.runtime;

final class ReturnSignal extends RuntimeException {
    private final WenyanValue value;

    ReturnSignal(WenyanValue value) {
        super(null, null, false, false);
        this.value = value;
    }

    WenyanValue value() {
        return value;
    }
}


package dev.anvilcraft.base.wenyan.runtime;

import java.util.HashMap;
import java.util.Map;

public final class Environment {
    private final Environment parent;
    private final Map<String, WenyanValue> values = new HashMap<>();

    public Environment(Environment parent) {
        this.parent = parent;
    }

    public void define(String name, WenyanValue value) {
        values.put(name, value);
    }

    public WenyanValue get(String name) {
        if (values.containsKey(name)) {
            return values.get(name);
        }
        if (parent != null) {
            return parent.get(name);
        }
        throw new IllegalStateException("Undefined identifier: " + name);
    }

    public void assign(String name, WenyanValue value) {
        if (values.containsKey(name)) {
            values.put(name, value);
            return;
        }
        if (parent != null) {
            parent.assign(name, value);
            return;
        }
        values.put(name, value);
    }

    public void delete(String name) {
        if (values.containsKey(name)) {
            values.remove(name);
            return;
        }
        if (parent != null) {
            parent.delete(name);
            return;
        }
        throw new IllegalStateException("Undefined identifier: " + name);
    }
}


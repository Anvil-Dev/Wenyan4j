package dev.anvilcraft.base.wenyan.runtime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class WenyanValue {
	public static final WenyanValue NULL = new WenyanValue(Type.NULL, null);

	public enum Type {
		NUMBER,
		STRING,
		BOOLEAN,
		ARRAY,
		FUNCTION,
		NULL
	}

	private final Type type;
	private final Object value;

	private WenyanValue(Type type, Object value) {
		this.type = type;
		this.value = value;
	}

	public static WenyanValue number(BigDecimal value) {
		return new WenyanValue(Type.NUMBER, value.stripTrailingZeros());
	}

	public static WenyanValue text(String value) {
		return new WenyanValue(Type.STRING, value);
	}

	public static WenyanValue bool(boolean value) {
		return new WenyanValue(Type.BOOLEAN, value);
	}

	public static WenyanValue array(List<WenyanValue> value) {
		return new WenyanValue(Type.ARRAY, new ArrayList<>(value));
	}

	public static WenyanValue function(WenyanFunction value) {
		return new WenyanValue(Type.FUNCTION, value);
	}

	public Type type() {
		return type;
	}

	public BigDecimal asNumber() {
		if (type == Type.NUMBER) {
			return (BigDecimal) value;
		}
		if (type == Type.BOOLEAN) {
			return (Boolean) value ? BigDecimal.ONE : BigDecimal.ZERO;
		}
		throw new IllegalStateException("Expected number but got " + type);
	}

	public String asText() {
		if (type == Type.STRING) {
			return (String) value;
		}
		return toDisplayString();
	}

	public boolean asBoolean() {
		return switch (type) {
			case BOOLEAN -> (Boolean) value;
			case NUMBER -> asNumber().compareTo(BigDecimal.ZERO) != 0;
			case STRING -> !((String) value).isEmpty();
			case ARRAY -> !asArray().isEmpty();
			case FUNCTION -> true;
			case NULL -> false;
		};
	}

	@SuppressWarnings("unchecked")
	public List<WenyanValue> asArray() {
		if (type != Type.ARRAY) {
			throw new IllegalStateException("Expected array but got " + type);
		}
		return (List<WenyanValue>) value;
	}

	public WenyanFunction asFunction() {
		if (type != Type.FUNCTION) {
			throw new IllegalStateException("Expected function but got " + type);
		}
		return (WenyanFunction) value;
	}

	public WenyanValue copyIfNeeded() {
		if (type == Type.ARRAY) {
			return array(asArray());
		}
		return this;
	}

	public String toDisplayString() {
		return switch (type) {
			case NUMBER -> asNumber().stripTrailingZeros().toPlainString();
			case STRING -> (String) value;
			case BOOLEAN -> (Boolean) value ? "陽" : "陰";
			case ARRAY -> asArray().stream().map(WenyanValue::toDisplayString).toList().toString();
			case FUNCTION -> "<術>";
			case NULL -> "空無";
		};
	}

	@Override
	public String toString() {
		return toDisplayString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof WenyanValue other)) {
			return false;
		}
		return type == other.type && Objects.equals(value, other.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, value);
	}
}


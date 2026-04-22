package dev.anvilcraft.base.wenyan.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将 Java 字段/Record 组件暴露为文言对象可读选择器。
 */
@Target({ElementType.FIELD, ElementType.RECORD_COMPONENT})
@Retention(RetentionPolicy.RUNTIME)
public @interface WenyuanField {
    /**
     * 该字段在文言中的选择器名称。
     *
     * @return 文言字段名，例如 {@code 其之『商』} 中的 {@code 商}
     */
    String value();
}

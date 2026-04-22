package dev.anvilcraft.base.wenyan.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记可被文言脚本导入的 {@code public static} Java 方法。
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WenyuanFunction {
    /**
     * 文言脚本中可见的方法名。
     *
     * @return 函数名
     */
    String value();
}

package dev.anvilcraft.base.wenyan.wenyuan;

import dev.anvilcraft.base.wenyan.annotation.WenyuanField;
import dev.anvilcraft.base.wenyan.annotation.WenyuanFunction;
import dev.anvilcraft.base.wenyan.annotation.WenyuanPavilion;

/**
 * 提供基础算术能力的内置文渊阁。
 */
@WenyuanPavilion(value = "算經", simplified = "算经")
public class MathematicalClassic {
    /**
     * 工具类无需实例化。
     */
    private MathematicalClassic() {
    }

    /**
     * 不可变的商/余数二元组。
     *
     * @param quotient  商
     * @param remainder 余数
     */
    public record DivMod(
        @WenyuanField(value = "商", simplified = "商") int quotient,
        @WenyuanField(value = "餘", simplified = "余") int remainder
    ) {
    }

    /**
     * 计算整数除法的商与余数。
     *
     * @param x 被除数
     * @param y 除数
     * @return 商与余数
     */
    @WenyuanFunction(value = "取底除", simplified = "取底除")
    public static DivMod divMod(int x, int y) {
        return new DivMod(x / y, x % y);
    }

    @WenyuanFunction(value = "正弦", simplified = "正弦")
    public static double sin(double a) {
        return Math.sin(a);
    }

    @WenyuanFunction(value = "餘弦", simplified = "余弦")
    public static double cos(double a) {
        return Math.cos(a);
    }

    @WenyuanFunction(value = "正切", simplified = "正切")
    public static double tan(double a) {
        return Math.tan(a);
    }

    @WenyuanFunction(value = "反正弦", simplified = "反正弦")
    public static double asin(double a) {
        return Math.asin(a);
    }

    @WenyuanFunction(value = "反餘弦", simplified = "反余弦")
    public static double acos(double a) {
        return Math.acos(a);
    }

    @WenyuanFunction(value = "反正切", simplified = "反正切")
    public static double atan(double a) {
        return Math.atan(a);
    }

    @WenyuanFunction(value = "化度為弧", simplified = "化度为弧")
    public static double toRadians(double angdeg) {
        return Math.toRadians(angdeg);
    }

    @WenyuanFunction(value = "化弧為度", simplified = "化弧为度")
    public static double toDegrees(double angrad) {
        return Math.toDegrees(angrad);
    }

    @WenyuanFunction(value = "納陛乘冪", simplified = "纳陛乘幂")
    public static double exp(double a) {
        return Math.exp(a);
    }

    @WenyuanFunction(value = "納陛歸元", simplified = "纳陛归元")
    public static double log(double a) {
        return Math.log(a);
    }

    @WenyuanFunction(value = "十底歸元", simplified = "十底归元")
    public static double log10(double a) {
        return Math.log10(a);
    }

    @WenyuanFunction(value = "開方", simplified = "开方")
    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    @WenyuanFunction(value = "開立方", simplified = "开立方")
    public static double cbrt(double a) {
        return Math.cbrt(a);
    }

    @WenyuanFunction(value = "規餘取範", simplified = "规余取范")
    public static double IEEEremainder(double f1, double f2) {
        return Math.IEEEremainder(f1, f2); // delegate to Math
    }

    @WenyuanFunction(value = "逢餘進一", simplified = "逢余进一")
    public static double ceil(double a) {
        return Math.ceil(a);
    }

    @WenyuanFunction(value = "逢餘退一", simplified = "逢余退一")
    public static double floor(double a) {
        return Math.floor(a);
    }

    @WenyuanFunction(value = "逢餘五入", simplified = "逢余五入")
    public static int round(float a) {
        return Math.round(a);
    }

    @WenyuanFunction(value = "逢餘五入", simplified = "逢余五入")
    public static long round(double a) {
        return Math.round(a);
    }

    @WenyuanFunction(value = "逢餘歸近", simplified = "逢余归近")
    public static double rint(double a) {
        return Math.rint(a);
    }

    @WenyuanFunction(value = "縱橫求向", simplified = "纵横求向")
    public static double atan2(double y, double x) {
        return Math.atan2(y, x);
    }

    @WenyuanFunction(value = "乘冪求積", simplified = "乘幂求积")
    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }

    @WenyuanFunction(value = "天機之數", simplified = "天机之数")
    public static double random() {
        return Math.random();
    }

    @WenyuanFunction(value = "謹加防溢", simplified = "谨加防溢")
    public static int addExact(int x, int y) {
        return Math.addExact(x, y);
    }

    @WenyuanFunction(value = "謹加防溢", simplified = "谨加防溢")
    public static long addExact(long x, long y) {
        return Math.addExact(x, y);
    }

    @WenyuanFunction(value = "謹減防越", simplified = "谨减防越")
    public static int subtractExact(int x, int y) {
        return Math.subtractExact(x, y);
    }

    @WenyuanFunction(value = "謹減防越", simplified = "谨减防越")
    public static long subtractExact(long x, long y) {
        return Math.subtractExact(x, y);
    }

    @WenyuanFunction(value = "謹乘防溢", simplified = "谨乘防溢")
    public static int multiplyExact(int x, int y) {
        return Math.multiplyExact(x, y);
    }

    @WenyuanFunction(value = "謹乘防溢", simplified = "谨乘防溢")
    public static long multiplyExact(long x, int y) {
        return Math.multiplyExact(x, y);
    }

    @WenyuanFunction(value = "謹乘防溢", simplified = "谨乘防溢")
    public static long multiplyExact(long x, long y) {
        return Math.multiplyExact(x, y);
    }

    @WenyuanFunction(value = "謹商防越", simplified = "謹商防越")
    public static int divideExact(int x, int y) {
        return Math.divideExact(x, y);
    }

    @WenyuanFunction(value = "謹商防越", simplified = "謹商防越")
    public static long divideExact(long x, long y) {
        return Math.divideExact(x, y);
    }

    @WenyuanFunction(value = "謹商取下", simplified = "謹商取下")
    public static int floorDivExact(int x, int y) {
        return Math.floorDivExact(x, y);
    }

    @WenyuanFunction(value = "謹商取下", simplified = "謹商取下")
    public static long floorDivExact(long x, long y) {
        return Math.floorDivExact(x, y);
    }

    @WenyuanFunction(value = "謹商取上", simplified = "謹商取上")
    public static int ceilDivExact(int x, int y) {
        return Math.ceilDivExact(x, y);
    }

    @WenyuanFunction(value = "謹商取上", simplified = "謹商取上")
    public static long ceilDivExact(long x, long y) {
        return Math.ceilDivExact(x, y);
    }

    @WenyuanFunction(value = "增一防溢", simplified = "增一防溢")
    public static int incrementExact(int a) {
        return Math.incrementExact(a);
    }

    @WenyuanFunction(value = "增一防溢", simplified = "增一防溢")
    public static long incrementExact(long a) {
        return Math.incrementExact(a);
    }

    @WenyuanFunction(value = "減一防越", simplified = "减一防越")
    public static int decrementExact(int a) {
        return Math.decrementExact(a);
    }

    @WenyuanFunction(value = "減一防越", simplified = "减一防越")
    public static long decrementExact(long a) {
        return Math.decrementExact(a);
    }

    @WenyuanFunction(value = "取反防溢", simplified = "取反防溢")
    public static int negateExact(int a) {
        return Math.negateExact(a);
    }

    @WenyuanFunction(value = "取反防溢", simplified = "取反防溢")
    public static long negateExact(long a) {
        return Math.negateExact(a);
    }

    @WenyuanFunction(value = "約長就短", simplified = "约长就短")
    public static int toIntExact(long value) {
        return Math.toIntExact(value);
    }

    @WenyuanFunction(value = "全積求積", simplified = "全积求积")
    public static long multiplyFull(int x, int y) {
        return Math.multiplyFull(x, y);
    }

    @WenyuanFunction(value = "取積高位", simplified = "取积高位")
    public static long multiplyHigh(long x, long y) {
        return Math.multiplyHigh(x, y);
    }

    @WenyuanFunction(value = "無號取高", simplified = "无号取高")
    public static long unsignedMultiplyHigh(long x, long y) {
        return Math.unsignedMultiplyHigh(x, y);
    }

    @WenyuanFunction(value = "求商取下", simplified = "求商取下")
    public static int floorDiv(int x, int y) {
        return Math.floorDiv(x, y);
    }

    @WenyuanFunction(value = "求商取下", simplified = "求商取下")
    public static long floorDiv(long x, int y) {
        return Math.floorDiv(x, y);
    }

    @WenyuanFunction(value = "求商取下", simplified = "求商取下")
    public static long floorDiv(long x, long y) {
        return Math.floorDiv(x, y);
    }

    @WenyuanFunction(value = "求餘取下", simplified = "求余取下")
    public static int floorMod(int x, int y) {
        return Math.floorMod(x, y);
    }

    @WenyuanFunction(value = "求餘取下", simplified = "求余取下")
    public static int floorMod(long x, int y) {
        return Math.floorMod(x, y);
    }

    @WenyuanFunction(value = "求餘取下", simplified = "求余取下")
    public static long floorMod(long x, long y) {
        return Math.floorMod(x, y);
    }

    @WenyuanFunction(value = "求商取上", simplified = "求商取上")
    public static int ceilDiv(int x, int y) {
        return Math.ceilDiv(x, y);
    }

    @WenyuanFunction(value = "求商取上", simplified = "求商取上")
    public static long ceilDiv(long x, int y) {
        return Math.ceilDiv(x, y);
    }

    @WenyuanFunction(value = "求商取上", simplified = "求商取上")
    public static long ceilDiv(long x, long y) {
        return Math.ceilDiv(x, y);
    }

    @WenyuanFunction(value = "求餘取上", simplified = "求余取上")
    public static int ceilMod(int x, int y) {
        return Math.ceilMod(x, y);
    }

    @WenyuanFunction(value = "求餘取上", simplified = "求余取上")
    public static int ceilMod(long x, int y) {
        return Math.ceilMod(x, y);
    }

    @WenyuanFunction(value = "求餘取上", simplified = "求余取上")
    public static long ceilMod(long x, long y) {
        return Math.ceilMod(x, y);
    }

    @WenyuanFunction(value = "取正", simplified = "取正")
    public static int abs(int a) {
        return Math.abs(a);
    }

    @WenyuanFunction(value = "取正防溢", simplified = "取正防溢")
    public static int absExact(int a) {
        return Math.absExact(a);
    }

    @WenyuanFunction(value = "取正", simplified = "取正")
    public static long abs(long a) {
        return Math.abs(a);
    }

    @WenyuanFunction(value = "取正防溢", simplified = "取正防溢")
    public static long absExact(long a) {
        return Math.absExact(a);
    }

    @WenyuanFunction(value = "取正", simplified = "取正")
    public static float abs(float a) {
        return Math.abs(a);
    }

    @WenyuanFunction(value = "取正", simplified = "取正")
    public static double abs(double a) {
        return Math.abs(a);
    }

    @WenyuanFunction(value = "最大", simplified = "最大")
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    @WenyuanFunction(value = "最大", simplified = "最大")
    public static long max(long a, long b) {
        return Math.max(a, b);
    }

    @WenyuanFunction(value = "最大", simplified = "最大")
    public static float max(float a, float b) {
        return Math.max(a, b);
    }

    @WenyuanFunction(value = "最大", simplified = "最大")
    public static double max(double a, double b) {
        return Math.max(a, b);
    }

    @WenyuanFunction(value = "最小", simplified = "最小")
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    @WenyuanFunction(value = "最小", simplified = "最小")
    public static long min(long a, long b) {
        return Math.min(a, b);
    }

    @WenyuanFunction(value = "最小", simplified = "最小")
    public static float min(float a, float b) {
        return Math.min(a, b);
    }

    @WenyuanFunction(value = "最小", simplified = "最小")
    public static double min(double a, double b) {
        return Math.min(a, b);
    }

    @WenyuanFunction(value = "範數", simplified = "范数")
    public static int clamp(long value, int min, int max) {
        return Math.clamp(value, min, max);
    }

    @WenyuanFunction(value = "範數", simplified = "范数")
    public static long clamp(long value, long min, long max) {
        return Math.clamp(value, min, max);
    }

    @WenyuanFunction(value = "範數", simplified = "范数")
    public static double clamp(double value, double min, double max) {
        return Math.clamp(value, min, max);
    }

    @WenyuanFunction(value = "範數", simplified = "范数")
    public static float clamp(float value, float min, float max) {
        return Math.clamp(value, min, max);
    }

    @WenyuanFunction(value = "融乘加積", simplified = "融乘加积")
    public static double fma(double a, double b, double c) {
        return Math.fma(a, b, c);
    }

    @WenyuanFunction(value = "融乘加積", simplified = "融乘加积")
    public static float fma(float a, float b, float c) {
        return Math.fma(a, b, c);
    }

    @WenyuanFunction(value = "浮點末度", simplified = "浮点末度")
    public static double ulp(double d) {
        return Math.ulp(d);
    }

    @WenyuanFunction(value = "浮點末度", simplified = "浮点末度")
    public static float ulp(float f) {
        return Math.ulp(f);
    }

    @WenyuanFunction(value = "辨號定符", simplified = "辨号定符")
    public static double signum(double d) {
        return Math.signum(d);
    }

    @WenyuanFunction(value = "辨號定符", simplified = "辨号定符")
    public static float signum(float f) {
        return Math.signum(f);
    }

    @WenyuanFunction(value = "雙曲正弦", simplified = "双曲正弦")
    public static double sinh(double x) {
        return Math.sinh(x);
    }

    @WenyuanFunction(value = "雙曲余弦", simplified = "双曲余弦")
    public static double cosh(double x) {
        return Math.cosh(x);
    }

    @WenyuanFunction(value = "雙曲正切", simplified = "双曲正切")
    public static double tanh(double x) {
        return Math.tanh(x);
    }

    @WenyuanFunction(value = "勾股求弦", simplified = "勾股求弦")
    public static double hypot(double x, double y) {
        return Math.hypot(x, y);
    }

    @WenyuanFunction(value = "納陛減一", simplified = "纳陛减一")
    public static double expm1(double x) {
        return Math.expm1(x);
    }

    @WenyuanFunction(value = "納陛归真", simplified = "纳陛归真")
    public static double log1p(double x) {
        return Math.log1p(x);
    }

    @WenyuanFunction(value = "襲號存體", simplified = "袭号存体")
    public static double copySign(double magnitude, double sign) {
        return Math.copySign(magnitude, sign);
    }

    @WenyuanFunction(value = "襲號存體", simplified = "袭号存体")
    public static float copySign(float magnitude, float sign) {
        return Math.copySign(magnitude, sign);
    }

    @WenyuanFunction(value = "析浮取指", simplified = "析浮取指")
    public static int getExponent(float f) {
        return Math.getExponent(f);
    }

    @WenyuanFunction(value = "析浮取指", simplified = "析浮取指")
    public static int getExponent(double d) {
        return Math.getExponent(d);
    }

    @WenyuanFunction(value = "循向步鄰", simplified = "循向步邻")
    public static double nextAfter(double start, double direction) {
        return Math.nextAfter(start, direction);
    }

    @WenyuanFunction(value = "循向步鄰", simplified = "循向步邻")
    public static float nextAfter(float start, double direction) {
        return Math.nextAfter(start, direction);
    }

    @WenyuanFunction(value = "升毫至鄰", simplified = "升毫至邻")
    public static double nextUp(double d) {
        return Math.nextUp(d);
    }

    @WenyuanFunction(value = "升毫至鄰", simplified = "升毫至邻")
    public static float nextUp(float f) {
        return Math.nextUp(f);
    }

    @WenyuanFunction(value = "降毫至鄰", simplified = "降毫至邻")
    public static double nextDown(double d) {
        return Math.nextDown(d);
    }

    @WenyuanFunction(value = "降毫至鄰", simplified = "降毫至邻")
    public static float nextDown(float f) {
        return Math.nextDown(f);
    }

    @WenyuanFunction(value = "徙冪伸縮", simplified = "徙幂伸缩")
    public static double scalb(double d, int scaleFactor) {
        return Math.scalb(d, scaleFactor);
    }

    @WenyuanFunction(value = "徙冪伸縮", simplified = "徙幂伸缩")
    public static float scalb(float f, int scaleFactor) {
        return Math.scalb(f, scaleFactor);
    }
}

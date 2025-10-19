package Utils;

public class EnumUtils {
    public static Enum<?>  castToEnum(Enum<?> obj, Class<?> enumType) {
        if (enumType.isInstance(obj)) {
            return obj;
        } else {
            throw new IllegalArgumentException("Object is not of type " + enumType.getName());
        }
    }
}

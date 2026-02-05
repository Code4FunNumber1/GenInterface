public interface Rule<T> {

    boolean test(T value);

    default boolean testNot(T value) {
        return !test(value);
    }
}

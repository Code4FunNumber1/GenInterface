public class BracketFormatter<T> implements Formatter<T> {
    @Override
    public String format(T value) {
        return "[%s]".formatted(value);
    }
}

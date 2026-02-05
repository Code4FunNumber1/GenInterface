public class AlwaysTrueRule<T> implements Rule<T> {
    @Override
    public boolean test(T value) {
        return true;
    }
}

public class NonEmptyStringRule implements Rule<String> {

    @Override
    public boolean test(String value) {
        return value != null && !value.isBlank();
    }
}

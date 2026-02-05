public class EvenIntegerRule implements Rule<Integer> {

    @Override
    public boolean test(Integer value) {
        return value != null && value % 2 == 0;
    }
}

public class IntHexFormatter implements Formatter<Integer> {

    @Override
    public String format(Integer value) {
        return Integer.toHexString(value).toLowerCase();
    }
}

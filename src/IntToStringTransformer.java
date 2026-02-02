public class IntToStringTransformer implements Transformer<Integer, String> {

    @Override
    public String transform(Integer input) {
        return input.toString();
    }
}

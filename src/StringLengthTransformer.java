public class StringLengthTransformer implements Transformer<String, Integer>{

    @Override
    public Integer transform(String input) {
        return input.length();
    }
}

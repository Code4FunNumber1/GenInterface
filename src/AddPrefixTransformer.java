public class AddPrefixTransformer implements Transformer<String, String>{

    private final String prefix;

    public AddPrefixTransformer(String prefix){
        this.prefix = prefix;
    }

    @Override
    public String transform(String input) {
        return "%s%s".formatted(prefix, input);
    }
}

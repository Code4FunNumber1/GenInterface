public class ComposedTransformer<IN, MID, OUT> implements Transformer<IN, OUT> {

    private final Transformer<IN, MID> first;
    private final Transformer<MID, OUT> second;

    public ComposedTransformer(Transformer<IN, MID> first, Transformer<MID, OUT> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public OUT transform(IN input) {
        MID mid = first.transform(input);
        return second.transform(mid);
    }
}

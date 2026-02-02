public interface Transformer<IN, OUT> {
    OUT transform(IN input);
}

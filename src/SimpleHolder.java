// Implementation stays generic (pattern A)
class SimpleHolder<T> implements Holder<T> {
    private T value;

    public SimpleHolder(T value) {
        this.value = value;
    }

    @Override
    public void set(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }
}
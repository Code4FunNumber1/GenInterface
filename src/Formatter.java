public interface Formatter<T> {

    String format(T value);

    default void print(T value){
        System.out.println(format(value));
    }
}

package lab11.ex2;

@FunctionalInterface
public interface ICustomConsumer<T> {
    void consume(T t);
}

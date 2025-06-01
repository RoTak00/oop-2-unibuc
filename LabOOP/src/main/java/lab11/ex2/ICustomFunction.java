package lab11.ex2;

@FunctionalInterface
public interface ICustomFunction<T, R> {
    R apply (T t);
}

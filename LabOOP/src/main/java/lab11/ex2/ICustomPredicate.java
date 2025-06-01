package lab11.ex2;

@FunctionalInterface
public interface ICustomPredicate<T> {
    boolean test(T t);
}

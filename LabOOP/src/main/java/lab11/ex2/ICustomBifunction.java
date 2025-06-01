package lab11.ex2;

@FunctionalInterface
public interface ICustomBifunction<R, T, K> {
    R apply(T t, K k);
}

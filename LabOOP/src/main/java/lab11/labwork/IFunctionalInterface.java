package lab11.labwork;

@FunctionalInterface
public interface IFunctionalInterface {

    void print(String message);

    static void staticMethod1() {
        // do someth
    }

    default void method2() {
        // do someth else
    }
}

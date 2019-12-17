package test.conclusion.file;

public interface TestFile<T> {
    T content();
    long numberOfTests();
}

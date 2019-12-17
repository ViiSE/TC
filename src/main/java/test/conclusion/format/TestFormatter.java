package test.conclusion.format;

public interface TestFormatter<M, C, T> {
    String formatMethod(M data);
    String formatClass(C data);
    String formatTime(T data);
}

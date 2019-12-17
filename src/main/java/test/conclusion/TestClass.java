package test.conclusion;

import java.util.Date;
import java.util.Map;

public interface TestClass {
    String name();
    Map<String, Date> calculateAvgTime();
    void addTestMethod(TestMethod method);
}

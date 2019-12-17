package test.conclusion;

import java.util.Date;
import java.util.Map;

public interface TestClasses {
    void addTestMethod(String className, TestMethod testMethod);
    void addClass(TestClass testClass);
    Map<String, Map<String, Date>> calculateAvgTime();
}

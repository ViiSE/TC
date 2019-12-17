package test.conclusion.producer;

import test.conclusion.TestClass;
import test.conclusion.TestMethod;

import java.util.List;

public interface TestClassProducer {
    TestClass getTestClassDefaultInstance(String testClassName, List<TestMethod> testMethods);
}

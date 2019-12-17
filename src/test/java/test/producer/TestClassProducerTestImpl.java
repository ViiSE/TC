package test.producer;

import test.conclusion.TestClass;
import test.conclusion.TestClassDefaultImpl;
import test.conclusion.TestMethod;
import test.conclusion.producer.TestClassProducer;

import java.util.List;

public class TestClassProducerTestImpl implements TestClassProducer {

    @Override
    public TestClass getTestClassDefaultInstance(String testClassName, List<TestMethod> testMethods) {
        return new TestClassDefaultImpl(testClassName, testMethods);
    }
}

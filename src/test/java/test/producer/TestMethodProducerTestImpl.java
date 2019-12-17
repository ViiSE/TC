package test.producer;

import test.conclusion.TestMethod;
import test.conclusion.TestMethodDefaultImpl;
import test.conclusion.producer.TestMethodProducer;

import java.util.Date;
import java.util.List;

public class TestMethodProducerTestImpl implements TestMethodProducer {

    @Override
    public TestMethod getTestMethodDefaultInstance(String methodName, List<Date> testTimes) {
        return new TestMethodDefaultImpl(methodName, testTimes);
    }
}

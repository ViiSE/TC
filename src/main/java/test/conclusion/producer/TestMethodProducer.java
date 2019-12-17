package test.conclusion.producer;

import test.conclusion.TestMethod;

import java.util.Date;
import java.util.List;

public interface TestMethodProducer {
    TestMethod getTestMethodDefaultInstance(String methodName, List<Date> testTimes);
}

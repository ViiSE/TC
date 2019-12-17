package test.conclusion.producer.creator;

import test.conclusion.creator.TestMethodCreator;
import test.conclusion.producer.TestMethodProducer;
import test.conclusion.time.DateParser;

public interface TestMethodCreatorProducer {
    TestMethodCreator getTestMethodCreatorDefaultInstance(
            TestMethodProducer testMethodProducer,
            DateParser dateParser,
            String methodName,
            String testTime);
}

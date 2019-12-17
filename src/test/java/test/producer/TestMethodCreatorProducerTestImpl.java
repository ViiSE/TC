package test.producer;

import test.conclusion.creator.TestMethodCreator;
import test.conclusion.creator.TestMethodCreatorDefaultImpl;
import test.conclusion.producer.TestMethodProducer;
import test.conclusion.producer.creator.TestMethodCreatorProducer;
import test.conclusion.time.DateParser;

public class TestMethodCreatorProducerTestImpl implements TestMethodCreatorProducer {

    @Override
    public TestMethodCreator getTestMethodCreatorDefaultInstance(
            TestMethodProducer testMethodProducer,
            DateParser dateParser,
            String methodName,
            String testTime) {
        return new TestMethodCreatorDefaultImpl(
                testMethodProducer,
                dateParser,
                methodName,
                testTime);
    }
}

package test.producer;

import test.conclusion.creator.TestClassCreator;
import test.conclusion.creator.TestClassCreatorDefaultImpl;
import test.conclusion.producer.TestClassProducer;
import test.conclusion.producer.creator.TestClassCreatorProducer;

public class TestClassCreatorProducerTestImpl implements TestClassCreatorProducer {

    @Override
    public TestClassCreator getTestClassCreatorDefaultInstance(TestClassProducer testClassProducer, String testClassName) {
        return new TestClassCreatorDefaultImpl(
                testClassProducer,
                testClassName);
    }
}

package test.conclusion.producer.creator;

import test.conclusion.creator.TestClassCreator;
import test.conclusion.producer.TestClassProducer;

public interface TestClassCreatorProducer {
    TestClassCreator getTestClassCreatorDefaultInstance(TestClassProducer testClassProducer, String testClassName);
}

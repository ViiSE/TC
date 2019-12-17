package test.conclusion.service;

import test.conclusion.producer.TestClassProducer;
import test.conclusion.producer.TestMethodProducer;
import test.conclusion.producer.creator.TestClassCreatorProducer;
import test.conclusion.producer.creator.TestMethodCreatorProducer;
import test.conclusion.producer.print.TestConclusionPrinterProducer;
import test.conclusion.producer.time.DateFormatterProducer;

public interface TestConclusionRunnerProducerService {
    TestMethodCreatorProducer testMethodCreatorProducer();
    TestClassCreatorProducer testClassCreatorProducer();
    TestConclusionPrinterProducer testConclusionPrinterProducer();
    DateFormatterProducer dateFormatterProducer();
    TestClassProducer testClassProducer();
    TestMethodProducer testMethodProducer();
}

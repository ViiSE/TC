package test.conclusion.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import test.conclusion.producer.TestClassProducer;
import test.conclusion.producer.TestMethodProducer;
import test.conclusion.producer.creator.TestClassCreatorProducer;
import test.conclusion.producer.creator.TestMethodCreatorProducer;
import test.conclusion.producer.print.TestConclusionPrinterProducer;
import test.conclusion.producer.time.DateFormatterProducer;

@Service("testConclusionRunnerProducerServiceDefault")
@Scope("prototype")
public class TestConclusionRunnerProducerServiceDefaultImpl implements TestConclusionRunnerProducerService {

    private final TestMethodCreatorProducer testMethodCreatorProducer;
    private final TestClassCreatorProducer testClassCreatorProducer;
    private final TestConclusionPrinterProducer testConclusionPrinterProducer;
    private final DateFormatterProducer dateFormatterProducer;
    private final TestMethodProducer testMethodProducer;
    private final TestClassProducer testClassProducer;

    public TestConclusionRunnerProducerServiceDefaultImpl(
            TestMethodCreatorProducer testMethodCreatorProducer,
            TestClassCreatorProducer testClassCreatorProducer,
            TestConclusionPrinterProducer testConclusionPrinterProducer,
            DateFormatterProducer dateFormatterProducer,
            TestMethodProducer testMethodProducer,
            TestClassProducer testClassProducer) {
        this.testMethodCreatorProducer = testMethodCreatorProducer;
        this.testClassCreatorProducer = testClassCreatorProducer;
        this.testConclusionPrinterProducer = testConclusionPrinterProducer;
        this.dateFormatterProducer = dateFormatterProducer;
        this.testMethodProducer = testMethodProducer;
        this.testClassProducer = testClassProducer;
    }

    @Override
    public TestMethodCreatorProducer testMethodCreatorProducer() {
        return testMethodCreatorProducer;
    }

    @Override
    public TestClassCreatorProducer testClassCreatorProducer() {
        return testClassCreatorProducer;
    }

    @Override
    public TestConclusionPrinterProducer testConclusionPrinterProducer() {
        return testConclusionPrinterProducer;
    }

    @Override
    public DateFormatterProducer dateFormatterProducer() {
        return dateFormatterProducer;
    }

    @Override
    public TestClassProducer testClassProducer() {
        return testClassProducer;
    }

    @Override
    public TestMethodProducer testMethodProducer() {
        return testMethodProducer;
    }
}

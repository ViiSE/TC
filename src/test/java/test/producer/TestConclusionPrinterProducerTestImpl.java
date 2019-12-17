package test.producer;

import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.print.TestConclusionPrinterDefaultImpl;
import test.conclusion.print.TestConclusionPrinterToFileImpl;
import test.conclusion.print.TestConclusionPrinterToWindowImpl;
import test.conclusion.producer.print.TestConclusionPrinterProducer;
import test.conclusion.time.DateFormatter;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class TestConclusionPrinterProducerTestImpl implements TestConclusionPrinterProducer {

    @Override
    public TestConclusionPrinter<String> getTestConclusionPrinterDefaultInstance(
            Map<String, Map<String, Date>> data, DateFormatter dateFormatter, long numberOfTests) {
        return new TestConclusionPrinterDefaultImpl(data, dateFormatter, numberOfTests);
    }

    @Override
    public TestConclusionPrinter<Void> getTestConclusionPrinterToWindowInstance(
            TestConclusionPrinter<String> testConclusionPrinter) {
        return new TestConclusionPrinterToWindowImpl(testConclusionPrinter);
    }

    @Override
    public TestConclusionPrinter<File> getFileTestConclusionPrinterToFileInstance(
            TestConclusionPrinter<String> testConclusionPrinter, String fullFilename) {
        return new TestConclusionPrinterToFileImpl(testConclusionPrinter, fullFilename);
    }
}

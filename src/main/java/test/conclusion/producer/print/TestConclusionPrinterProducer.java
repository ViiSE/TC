package test.conclusion.producer.print;

import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.time.DateFormatter;

import java.io.File;
import java.util.Date;
import java.util.Map;

public interface TestConclusionPrinterProducer {
    TestConclusionPrinter<String> getTestConclusionPrinterDefaultInstance(
            Map<String, Map<String, Date>> data,
            DateFormatter dateFormatter,
            long numberOfTests);
    TestConclusionPrinter<Void> getTestConclusionPrinterToWindowInstance(
            TestConclusionPrinter<String> testConclusionPrinter);
    TestConclusionPrinter<File> getFileTestConclusionPrinterToFileInstance(
            TestConclusionPrinter<String> testConclusionPrinter,
            String fullFilename);
}

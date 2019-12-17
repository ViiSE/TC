package test.conclusion.producer.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.print.TestConclusionPrinterDefaultImpl;
import test.conclusion.print.TestConclusionPrinterToFileImpl;
import test.conclusion.print.TestConclusionPrinterToWindowImpl;
import test.conclusion.time.DateFormatter;

import java.io.File;
import java.util.Date;
import java.util.Map;

@Service("testConclusionPrinterProducerDefault")
public class TestConclusionPrinterProducerDefaultImpl implements TestConclusionPrinterProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public TestConclusionPrinter<String> getTestConclusionPrinterDefaultInstance(
            Map<String, Map<String, Date>> data,
            DateFormatter dateFormatter,
            long numberOfTests) {
        return (TestConclusionPrinterDefaultImpl) ctx.getBean("testConclusionPrinterDefault", data, dateFormatter, numberOfTests);
    }

    @Override
    public TestConclusionPrinter<Void> getTestConclusionPrinterToWindowInstance(TestConclusionPrinter<String> testConclusionPrinter) {
        return (TestConclusionPrinterToWindowImpl) ctx.getBean("testConclusionPrinterToWindow", testConclusionPrinter);
    }

    @Override
    public TestConclusionPrinter<File> getFileTestConclusionPrinterToFileInstance(
            TestConclusionPrinter<String> testConclusionPrinter,
            String fullFilename) {
        return (TestConclusionPrinterToFileImpl) ctx.getBean(
                "testConclusionPrinterToFile",
                testConclusionPrinter,
                fullFilename);
    }
}

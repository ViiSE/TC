package test.conclusion;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.conclusion.file.TestFile;
import test.conclusion.format.TestFormatter;
import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.service.TestConclusionRunnerProducerService;
import test.conclusion.time.DateParser;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component("testConclusionRunnerDefault")
@Scope("prototype")
public class TestConclusionRunnerDefaultImpl implements TestConclusionRunner {

    private final TestClasses testClasses;
    private final TestFile<List<String>> testFile;
    private final TestFormatter<String, String, String> testFormatter;
    private final TestConclusionRunnerProducerService service;
    private final DateParser dateParser;
    private final String fullFilename;

    public TestConclusionRunnerDefaultImpl(
            TestClasses testClasses,
            TestFile<List<String>> testFile,
            TestFormatter<String, String, String> testFormatter,
            TestConclusionRunnerProducerService service,
            DateParser dateParser,
            String fullFilename) {
        this.testClasses = testClasses;
        this.testFile = testFile;
        this.testFormatter = testFormatter;
        this.service = service;
        this.dateParser = dateParser;
        this.fullFilename = fullFilename;
    }

    @Override
    public void run() {
        List<String> content = testFile.content();
        String testClassName = "";
        for(String line: content) {
            if(line.contains("\t")) {
                String methodName = testFormatter.formatMethod(line);
                String testTime = testFormatter.formatTime(line);
                TestMethod testMethod = service.testMethodCreatorProducer()
                        .getTestMethodCreatorDefaultInstance(
                                service.testMethodProducer(),
                                dateParser,
                                methodName,
                                testTime)
                        .create();
                testClasses.addTestMethod(testClassName, testMethod);
            } else {
                testClassName = testFormatter.formatClass(line);
                TestClass testClass = service.testClassCreatorProducer()
                        .getTestClassCreatorDefaultInstance(
                                service.testClassProducer(),
                                testClassName)
                        .create();
                testClasses.addClass(testClass);
            }
        }

        Map<String, Map<String, Date>> result = testClasses.calculateAvgTime();
        TestConclusionPrinter<String> tcp =
                service.testConclusionPrinterProducer()
                        .getTestConclusionPrinterDefaultInstance(
                                result,
                                service.dateFormatterProducer().getDateFormatterDefaultInstance(),
                                testFile.numberOfTests());
        service.testConclusionPrinterProducer()
                .getTestConclusionPrinterToWindowInstance(tcp)
                .print();
        service.testConclusionPrinterProducer()
                .getFileTestConclusionPrinterToFileInstance(tcp, fullFilename)
                .print();
    }
}

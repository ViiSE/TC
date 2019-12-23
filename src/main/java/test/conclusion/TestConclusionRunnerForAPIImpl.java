package test.conclusion;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.conclusion.constants.APIConstants;
import test.conclusion.file.TestFile;
import test.conclusion.format.TestFormatter;
import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.service.TestConclusionRunnerProducerService;
import test.conclusion.time.DateParser;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component("testConclusionRunnerForAPI")
@Scope("prototype")
public class TestConclusionRunnerForAPIImpl implements TestConclusionRunner {

    private final TestClasses testClasses;
    private final TestFile<List<String>> testFile;
    private final TestFormatter<String, String, String> testFormatter;
    private final TestConclusionRunnerProducerService service;
    private final DateParser dateParser;
    private final String fullFilename;

    public TestConclusionRunnerForAPIImpl(
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

        if(content.contains(APIConstants.GET))
            addClass(APIConstants.GET);
        else if(content.contains(APIConstants.POST))
            addClass(APIConstants.POST);

        String currentApiMethod = APIConstants.GET;
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
                testClasses.addTestMethod(currentApiMethod, testMethod);
            } else {
                if(line.equals(APIConstants.GET))
                    currentApiMethod = APIConstants.GET;
                else if(line.equals(APIConstants.POST))
                    currentApiMethod = APIConstants.POST;
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

    private void addClass(String apiMethodName) {
        testClasses.addClass(service.testClassCreatorProducer()
                .getTestClassCreatorDefaultInstance(
                        service.testClassProducer(),
                        testFormatter.formatClass(apiMethodName))
                .create());
    }
}

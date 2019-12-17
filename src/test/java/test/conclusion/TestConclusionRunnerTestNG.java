package test.conclusion;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.conclusion.file.TestFile;
import test.conclusion.file.TestFileListStringImpl;
import test.conclusion.service.TestConclusionRunnerProducerService;
import test.conclusion.service.TestConclusionRunnerProducerServiceDefaultImpl;
import test.conclusion.time.DateParser;
import test.conclusion.time.DateParserDefaultPatternImpl;
import test.conclusion.format.*;
import test.producer.*;
import test.util.TestUtils;

import java.util.HashMap;
import java.util.List;

public class TestConclusionRunnerTestNG {

    private TestConclusionRunner tcr;

    @BeforeClass
    public void setUp() {
        TestClasses tc = new TestClassesDefaultImpl(new HashMap<>());
        TestFile<List<String>> tf = new TestFileListStringImpl(TestUtils.getTestResourcesFile("elapse_time_test"));

        ClassFormatter<String> classFormatter = new ClassFormatterStringDefaultImpl();
        MethodFormatter<String> methodFormatter = new MethodFormatterStringDefaultImpl();
        TimeFormatter<String> timeFormatter = new TimeFormatterStringDefaultImpl();
        TestFormatter<String, String, String> tForm = new TestFormatterDefaultImpl(
                classFormatter,
                methodFormatter,
                timeFormatter);
        TestConclusionRunnerProducerService tcrps = new TestConclusionRunnerProducerServiceDefaultImpl(
                new TestMethodCreatorProducerTestImpl(),
                new TestClassCreatorProducerTestImpl(),
                new TestConclusionPrinterProducerTestImpl(),
                new DateFormatterProducerTestImpl(),
                new TestMethodProducerTestImpl(),
                new TestClassProducerTestImpl());
        DateParser dp = new DateParserDefaultPatternImpl();
        String resFilePath = TestUtils.getTestResourcesFile("con_res_test");

        tcr = new TestConclusionRunnerDefaultImpl(
                tc,
                tf,
                tForm,
                tcrps,
                dp,
                resFilePath);
    }

    @Test
    public void run() {
        tcr.run();
    }
}

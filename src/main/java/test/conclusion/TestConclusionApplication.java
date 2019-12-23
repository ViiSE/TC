package test.conclusion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.conclusion.configuration.TestConclusionConfiguration;
import test.conclusion.file.TestFile;
import test.conclusion.file.TestFileListStringImpl;
import test.conclusion.producer.TestClassProducer;
import test.conclusion.producer.TestMethodProducer;
import test.conclusion.producer.creator.TestClassCreatorProducer;
import test.conclusion.producer.creator.TestMethodCreatorProducer;
import test.conclusion.producer.print.TestConclusionPrinterProducer;
import test.conclusion.producer.time.DateFormatterProducer;
import test.conclusion.service.TestConclusionRunnerProducerService;
import test.conclusion.time.DateParser;
import test.conclusion.format.*;

import java.util.HashMap;
import java.util.List;

public class TestConclusionApplication {

	public static void main(String[] args) {
		String shKeyApi = "";

		if(args.length == 0) {
			throw new RuntimeException("Enter the filename from which the test results are read!");
		}
		if(args.length == 1) {
			throw new RuntimeException("Enter the filename in which the result of the program execution is written!");
		}
		if(args.length == 3) {
			if(!args[2].equals("--api"))
				throw new RuntimeException("Unknown command!");
			else
				shKeyApi = "--api";
		}

		ApplicationContext ctx = new AnnotationConfigApplicationContext(TestConclusionConfiguration.class);

		String fullFilenameOld = args[0];
		String fullFilenameNew = args[1];

		TestConclusionRunnerProducerService service = (TestConclusionRunnerProducerService) ctx.getBean(
					"testConclusionRunnerProducerServiceDefault",
					ctx.getBean(TestMethodCreatorProducer.class),
					ctx.getBean(TestClassCreatorProducer.class),
					ctx.getBean(TestConclusionPrinterProducer.class),
					ctx.getBean(DateFormatterProducer.class),
					ctx.getBean(TestMethodProducer.class),
					ctx.getBean(TestClassProducer.class));

		TestClasses testClasses = (TestClasses) ctx.getBean("testClassesDefault", new HashMap<>());
		TestFile<List<String>> testFile = (TestFileListStringImpl) ctx.getBean("testFileListString", fullFilenameOld);
		TestFormatter<String, String, String> testFormatter = (TestFormatterDefaultImpl) ctx.getBean(
				"testFormatterDefault",
				ctx.getBean(ClassFormatterStringDefaultImpl.class),
				ctx.getBean(MethodFormatterStringDefaultImpl.class),
				ctx.getBean(TimeFormatterStringDefaultImpl.class));
		DateParser dateParser = ctx.getBean(DateParser.class);

		TestConclusionRunner runner;
		if(!shKeyApi.isEmpty())
			runner = (TestConclusionRunner) ctx.getBean(
					"testConclusionRunnerForAPI",
					testClasses,
					testFile,
					testFormatter,
					service,
					dateParser,
					fullFilenameNew);

		else
			runner = (TestConclusionRunner) ctx.getBean(
					"testConclusionRunnerDefault",
					testClasses,
					testFile,
					testFormatter,
					service,
					dateParser,
					fullFilenameNew);
		runner.run();
	}

}

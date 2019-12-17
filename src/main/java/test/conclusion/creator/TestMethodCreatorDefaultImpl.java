package test.conclusion.creator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import test.conclusion.TestMethod;
import test.conclusion.producer.TestMethodProducer;
import test.conclusion.time.DateParser;

import java.util.ArrayList;

@Service("testMethodCreatorDefault")
@Scope("prototype")
public class TestMethodCreatorDefaultImpl implements TestMethodCreator {

    private final TestMethodProducer testMethodProducer;
    private final DateParser dateParser;
    private final String methodName;
    private final String testTime;

    public TestMethodCreatorDefaultImpl(
            TestMethodProducer testMethodProducer,
            DateParser dateParser,
            String methodName,
            String testTime) {
        this.testMethodProducer = testMethodProducer;
        this.dateParser = dateParser;
        this.methodName = methodName;
        this.testTime = testTime;
    }

    @Override
    public TestMethod create() {
        return testMethodProducer.getTestMethodDefaultInstance(
                methodName,
                new ArrayList<>() {{ add(dateParser.parse(testTime)); }});
    }
}

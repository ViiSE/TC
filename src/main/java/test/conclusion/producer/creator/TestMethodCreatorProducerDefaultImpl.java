package test.conclusion.producer.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.conclusion.creator.TestMethodCreator;
import test.conclusion.producer.TestMethodProducer;
import test.conclusion.time.DateParser;

@Service("testMethodCreatorProducerDefault")
public class TestMethodCreatorProducerDefaultImpl implements TestMethodCreatorProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public TestMethodCreator getTestMethodCreatorDefaultInstance(
            TestMethodProducer testMethodProducer,
            DateParser dateParser,
            String methodName,
            String testTime) {
        return (TestMethodCreator) ctx.getBean(
                "testMethodCreatorDefault",
                testMethodProducer,
                dateParser,
                methodName,
                testTime);
    }
}

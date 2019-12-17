package test.conclusion.producer.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.conclusion.creator.TestClassCreator;
import test.conclusion.producer.TestClassProducer;

@Service("testClassCreatorProducerDefault")
public class TestClassCreatorProducerDefaultImpl implements TestClassCreatorProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public TestClassCreator getTestClassCreatorDefaultInstance(TestClassProducer testClassProducer, String testClassName) {
        return (TestClassCreator) ctx.getBean("testClassCreatorDefault", testClassProducer, testClassName);
    }
}

package test.conclusion.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.conclusion.TestClass;
import test.conclusion.TestMethod;

import java.util.List;

@Service("testClassProducerDefault")
public class TestClassProducerDefaultImpl implements TestClassProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public TestClass getTestClassDefaultInstance(String testClassName, List<TestMethod> testMethods) {
        return (TestClass) ctx.getBean("testClassDefault", testClassName, testMethods);
    }
}

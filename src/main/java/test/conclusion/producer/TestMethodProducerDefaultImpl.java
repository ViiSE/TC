package test.conclusion.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.conclusion.TestMethod;

import java.util.Date;
import java.util.List;

@Service("testMethodProducerDefault")
public class TestMethodProducerDefaultImpl implements TestMethodProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public TestMethod getTestMethodDefaultInstance(String methodName, List<Date> testTimes) {
        return (TestMethod) ctx.getBean("testMethodDefault", methodName, testTimes);
    }
}

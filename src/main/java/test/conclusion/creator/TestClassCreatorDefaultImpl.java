package test.conclusion.creator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import test.conclusion.TestClass;
import test.conclusion.producer.TestClassProducer;

import java.util.ArrayList;

@Service("testClassCreatorDefault")
@Scope("prototype")
public class TestClassCreatorDefaultImpl implements TestClassCreator {

    private final TestClassProducer testClassProducer;
    private final String testClassName;

    public TestClassCreatorDefaultImpl(TestClassProducer testClassProducer, String testClassName) {
        this.testClassProducer = testClassProducer;
        this.testClassName = testClassName;
    }

    @Override
    public TestClass create() {
        return testClassProducer.getTestClassDefaultInstance(testClassName, new ArrayList<>());
    }
}

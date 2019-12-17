package test.conclusion;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("testClassDefault")
@Scope("prototype")
public class TestClassDefaultImpl implements TestClass {

    private final String name;
    private final List<TestMethod> testMethods;

    public TestClassDefaultImpl(String name, List<TestMethod> testMethods) {
        this.name = name;
        this.testMethods = testMethods;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<String, Date> calculateAvgTime() {
        Map<String, Date> avgTimes = new HashMap<>();
        for(TestMethod testMethod: testMethods)
            avgTimes.put(testMethod.name(), testMethod.calculateAvgTime());
        return avgTimes;
    }

    @Override
    public void addTestMethod(TestMethod method) {
        for(TestMethod testMethod: testMethods) {
            if(testMethod.name().equals(method.name())) {
                testMethod.addTestTime(method.testTimes());
                return;
            }
        }

        testMethods.add(method);
    }
}

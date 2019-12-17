package test.conclusion;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("testClassesDefault")
@Scope("prototype")
public class TestClassesDefaultImpl implements TestClasses {

    private final Map<String, TestClass> testClasses;

    public TestClassesDefaultImpl(Map<String, TestClass> testClasses) {
        this.testClasses = testClasses;
    }

    @Override
    public void addTestMethod(String className, TestMethod testMethod) {
        if(testClasses.containsKey(className))
            testClasses.get(className).addTestMethod(testMethod);
    }

    @Override
    public void addClass(TestClass testClass) {
        testClasses.put(testClass.name(), testClass);
    }

    @Override
    public Map<String, Map<String, Date>> calculateAvgTime() {
        Map<String, Map<String, Date>> avgTime = new HashMap<>();
        testClasses.forEach((className, testClass) -> avgTime.put(className, testClass.calculateAvgTime()));

        return avgTime;
    }
}

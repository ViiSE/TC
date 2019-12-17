package test.conclusion;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component("testMethodDefault")
@Scope("prototype")
public class TestMethodDefaultImpl implements TestMethod {

    private final String name;
    private final List<Date> testTimes;

    public TestMethodDefaultImpl(String name, List<Date> testTimes) {
        this.name = name;
        this.testTimes = testTimes;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public List<Date> testTimes() {
        return testTimes;
    }

    @Override
    public Date calculateAvgTime() {
        long sumTime = 0;
        for(Date time: testTimes)
            sumTime += time.getTime();
        return new Date(sumTime / testTimes.size());
    }

    @Override
    public void addTestTime(List<Date> testTime) {
        testTimes.addAll(testTime);
    }
}

package test.conclusion;

import java.util.Date;
import java.util.List;

public interface TestMethod {
    String name();
    List<Date> testTimes();
    Date calculateAvgTime();
    void addTestTime(List<Date> testTime);
}

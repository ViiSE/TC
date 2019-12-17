package test.conclusion;

import org.testng.annotations.Test;
import test.conclusion.time.DateFormatter;
import test.conclusion.time.DateFormatterDefaultImpl;
import test.conclusion.time.DateParser;
import test.conclusion.time.DateParserDefaultPatternImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestMethodTestNG {

    @Test
    public void calculateAvgTime() {
        String time1 = "00m 00s 096ms";
        String time2 = "00m 00s 081ms";
        String time3 = "00m 00s 165ms";

        DateParser parser = new DateParserDefaultPatternImpl();
        DateFormatter formatter = new DateFormatterDefaultImpl();

        String name = "readDepartments()";
        List<Date> testTimes = new ArrayList<>();

        TestMethod testMethod = new TestMethodDefaultImpl(name, testTimes);
        testMethod.addTestTime(new ArrayList<>() {{ add(parser.parse(time1));}});
        testMethod.addTestTime(new ArrayList<>() {{ add(parser.parse(time2));}});
        testMethod.addTestTime(new ArrayList<>() {{ add(parser.parse(time3));}});

        Date avgTime = testMethod.calculateAvgTime();
        String fAvgTime = formatter.format(avgTime);

        System.out.println(fAvgTime);
        assertEquals(fAvgTime, "00m 00s 114ms", "Average time is not average!");
    }
}

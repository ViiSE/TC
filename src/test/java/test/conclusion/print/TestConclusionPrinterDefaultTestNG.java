package test.conclusion.print;

import org.testng.annotations.Test;
import test.conclusion.*;
import test.conclusion.time.DateFormatter;
import test.conclusion.time.DateFormatterDefaultImpl;
import test.conclusion.time.DateParser;
import test.conclusion.time.DateParserDefaultPatternImpl;

import java.util.*;

public class TestConclusionPrinterDefaultTestNG {

    @Test
    public void test() {
        String time1 = "00m 00s 096ms";
        String time2 = "00m 00s 081ms";
        String time3 = "00m 00s 165ms";

        DateParser parser = new DateParserDefaultPatternImpl();
        DateFormatter formatter = new DateFormatterDefaultImpl();

        String name1 = "readDepartments()";
        List<Date> testTimes1 = new ArrayList<>() {{
            add(parser.parse(time1));
            add(parser.parse(time2));
            add(parser.parse(time3));;
        }};
        TestMethod testMethod1 = new TestMethodDefaultImpl(name1, testTimes1);

        String time4 = "00m 00s 063ms";
        String time5 = "00m 00s 051ms";
        String time6 = "00m 00s 074ms";

        String name2 = "readUnits()";
        List<Date> testTimes2 = new ArrayList<>() {{
            add(parser.parse(time4));
            add(parser.parse(time5));
            add(parser.parse(time6));;
        }};
        TestMethod testMethod2 = new TestMethodDefaultImpl(name2, testTimes2);

        TestClass testClass1 = new TestClassDefaultImpl(
                "testClass1",
                new ArrayList<>() {{ add(testMethod1); }});
        testClass1.addTestMethod(testMethod2);

        String time7 = "00m 00s 219ms";
        String time8 = "00m 00s 224ms";
        String time9 = "00m 00s 231ms";

        String name3 = "readCategories()";
        List<Date> testTimes3 = new ArrayList<>() {{
            add(parser.parse(time7));
            add(parser.parse(time8));
            add(parser.parse(time9));;
        }};
        TestMethod testMethod3 = new TestMethodDefaultImpl(name3, testTimes3);

        String time10 = "01m 25s 589ms";
        String time11 = "01m 20s 530ms";
        String time12 = "02m 15s 938ms";

        String name4 = "readProducts()";
        List<Date> testTimes4 = new ArrayList<>() {{
            add(parser.parse(time10));
            add(parser.parse(time11));
            add(parser.parse(time12));;
        }};
        TestMethod testMethod4 = new TestMethodDefaultImpl(name4, testTimes4);

        TestClass testClass2 = new TestClassDefaultImpl(
                "testClass2",
                new ArrayList<>() {{ add(testMethod3); }});

        TestClasses testClasses = new TestClassesDefaultImpl(new HashMap<>());
        testClasses.addClass(testClass1);
        testClasses.addClass(testClass2);

        testClasses.addTestMethod("testClass2", testMethod4);

        Map<String, Map<String, Date>> avgTimes = testClasses.calculateAvgTime();
        TestConclusionPrinter<String> printer = new TestConclusionPrinterDefaultImpl(avgTimes, formatter, 3);
        System.out.println(printer.print());
    }
}

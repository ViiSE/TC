/*
 *     Copyright (C) 2020 ViiSE
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package test.conclusion;

import org.testng.annotations.Test;
import test.conclusion.print.TestConclusionPrinter;
import test.conclusion.print.TestConclusionPrinterDefaultImpl;
import test.conclusion.time.DateFormatter;
import test.conclusion.time.DateFormatterDefaultImpl;
import test.conclusion.time.DateParser;
import test.conclusion.time.DateParserDefaultPatternImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class TestClassesTestNG {

    @Test
    public void calculateAvgTime() {
        String time1 = "00m 00s 096ms";
        String time2 = "00m 00s 081ms";
        String time3 = "00m 00s 165ms";

        DateParser parser = new DateParserDefaultPatternImpl();
        DateFormatter formatter = new DateFormatterDefaultImpl();

        String name1 = "methodA1()";
        List<Date> testTimes1 = new ArrayList<>() {{
            add(parser.parse(time1));
            add(parser.parse(time2));
            add(parser.parse(time3));;
        }};
        TestMethod testMethod1 = new TestMethodDefaultImpl(name1, testTimes1);

        String time4 = "00m 00s 063ms";
        String time5 = "00m 00s 051ms";
        String time6 = "00m 00s 074ms";

        String name2 = "methodA2()";
        List<Date> testTimes2 = new ArrayList<>() {{
            add(parser.parse(time4));
            add(parser.parse(time5));
            add(parser.parse(time6));;
        }};
        TestMethod testMethod2 = new TestMethodDefaultImpl(name2, testTimes2);

        TestClass testClass1 = new TestClassDefaultImpl(
                "testClassA",
                new ArrayList<>() {{ add(testMethod1); }});
        testClass1.addTestMethod(testMethod2);

        String time7 = "00m 00s 219ms";
        String time8 = "00m 00s 224ms";
        String time9 = "00m 00s 231ms";

        String name3 = "methodB1()";
        List<Date> testTimes3 = new ArrayList<>() {{
            add(parser.parse(time7));
            add(parser.parse(time8));
            add(parser.parse(time9));;
        }};
        TestMethod testMethod3 = new TestMethodDefaultImpl(name3, testTimes3);

        String time10 = "01m 25s 589ms";  //85589   --\
        String time11 = "01m 20s 530ms";  //80530   ---> 100685ms --> 01m 40s 686ms
        String time12 = "02m 15s 938ms";  //135938  --/

        String name4 = "methodB2()";
        List<Date> testTimes4 = new ArrayList<>() {{
            add(parser.parse(time10));
            add(parser.parse(time11));
            add(parser.parse(time12));;
        }};
        TestMethod testMethod4 = new TestMethodDefaultImpl(name4, testTimes4);

        TestClass testClass2 = new TestClassDefaultImpl(
                "testClassB",
                new ArrayList<>() {{ add(testMethod3); }});

        TestClasses testClasses = new TestClassesDefaultImpl();
        testClasses.addClass(testClass1);
        testClasses.addClass(testClass2);

        testClasses.addTestMethod("testClassB", testMethod4);

        Map<String, Map<String, Date>> avgTimes = testClasses.calculateAvgTime();
        TestConclusionPrinter<String> printer = new TestConclusionPrinterDefaultImpl(avgTimes, formatter, 3);
        System.out.println(printer.print());

        assertEquals(formatter.format(avgTimes.get("testClassA").get("methodA1()")),
                "00m 00s 114ms",
                "Average time is not average!");
        assertEquals(formatter.format(avgTimes.get("testClassA").get("methodA2()")),
                "00m 00s 063ms",
                "Average time is not average!");

        assertEquals(formatter.format(avgTimes.get("testClassB").get("methodB1()")),
                "00m 00s 225ms",
                "Average time is not average!");
        assertEquals(formatter.format(avgTimes.get("testClassB").get("methodB2()")),
                "01m 40s 686ms",
                "Average time is not average!");

    }
}

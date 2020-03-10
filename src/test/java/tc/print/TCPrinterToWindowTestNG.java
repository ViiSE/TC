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

package tc.print;

import org.testng.annotations.Test;
import tc.*;
import tc.time.DateFormatter;
import tc.time.DateFormatterDefaultImpl;
import tc.time.DateParser;
import tc.time.DateParserDefaultPatternImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TCPrinterToWindowTestNG {

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

        TestClasses testClasses = new TestClassesDefaultImpl();
        testClasses.addClass(testClass1);
        testClasses.addClass(testClass2);

        testClasses.addTestMethod("testClass2", testMethod4);

        Map<String, Map<String, Date>> avgTimes = testClasses.calculateAvgTime();
        TCPrinter<Void> printer = new TCPrinterToWindowImpl(
                new TCPrinterDefaultImpl(avgTimes, formatter, 3));
        printer.print();
    }
}

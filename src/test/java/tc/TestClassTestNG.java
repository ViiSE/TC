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

package tc;

import org.testng.annotations.Test;
import tc.time.DateFormatter;
import tc.time.DateFormatterDefaultImpl;
import tc.time.DateParser;
import tc.time.DateParserDefaultPatternImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class TestClassTestNG {

    @Test
    public void calculateAvgTime() {
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

        TestClass testClass = new TestClassDefaultImpl(
                "Sample name",
                new ArrayList<>() {{ add(testMethod1); }});
        testClass.addTestMethod(testMethod2);
        Map<String, Date> avgTimes = testClass.calculateAvgTime();

        avgTimes.forEach((methodName, date) ->
            System.out.println(methodName + ": " + formatter.format(date)));

        assertEquals(formatter.format(avgTimes.get("readDepartments()")), "00m 00s 114ms", "Average time is not average!");
        assertEquals(formatter.format(avgTimes.get("readUnits()")), "00m 00s 063ms", "Average time is not average!");
    }
}

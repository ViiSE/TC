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

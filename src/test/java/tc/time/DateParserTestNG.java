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

package tc.time;

import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;

public class DateParserTestNG {

    @Test
    public void parse() {
        String time = "00m 00s 096ms";

        DateParser dateParser = new DateParserDefaultPatternImpl();
        Date pDate = dateParser.parse(time);

        System.out.println(pDate.getTime());
        assertEquals(pDate.getTime(), -35999904, "Time is not equals!");
    }
}

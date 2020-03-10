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

package test.conclusion.time;

import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;

public class DateFormatterTestNG {

    @Test
    public void format() {
        Date date = new Date(-35999904L); //00m 00s 096ms
        DateFormatter formatter = new DateFormatterDefaultImpl();
        String sDate = formatter.format(date);

        assertEquals(sDate, "00m 00s 096ms", "Time not equals 00m 00s 096ms !");

        System.out.println(sDate);
    }
}

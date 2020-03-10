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

package tc.format;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TimeFormatterTestNG {

    @Test
    public void format() {
        String sample = "\treadDepartments() - 00m 00s 096ms";

        TimeFormatter<String> timeFormatter = new TimeFormatterStringDefaultImpl();
        String formatSample = timeFormatter.format(sample);
        assertNotNull(formatSample, "Format sample is null!");
        assertNotEquals(sample, formatSample, "Format sample is not formatted!");
        assertFalse(formatSample.contains("\t"), "Format sample contains \\t");
        assertFalse(formatSample.contains("-"), "Format sample contains -");

        System.out.println(sample);
        System.out.println(formatSample);
    }
}

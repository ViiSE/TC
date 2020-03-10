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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class ClassFormatterTestNG {

    @Test
    public void format() {
        String sample = "DepartmentsRepositoryDefaultIntegration";

        ClassFormatter<String> classFormatter = new ClassFormatterStringDefaultImpl();
        String formatSample = classFormatter.format(sample);
        assertNotNull(formatSample, "Format sample is null!");
        assertFalse(formatSample.contains("\t"), "Format sample contains \\t");

        System.out.println(sample);
        System.out.println(formatSample);
    }
}

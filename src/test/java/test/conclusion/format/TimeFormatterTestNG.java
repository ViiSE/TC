/*
 *   Copyright 2020 ViiSE
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package test.conclusion.format;

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

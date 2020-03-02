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

package test.conclusion.time;

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

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

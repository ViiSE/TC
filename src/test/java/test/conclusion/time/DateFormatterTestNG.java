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

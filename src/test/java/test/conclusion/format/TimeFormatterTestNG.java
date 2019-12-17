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

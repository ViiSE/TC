package test.conclusion.format;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MethodFormatterTestNG {

    @Test
    public void format() {
        String sample = "\treadDepartments() - 00m 00s 096ms";

        MethodFormatter<String> methodFormatter = new MethodFormatterStringDefaultImpl();
        String formatSample = methodFormatter.format(sample);
        assertNotNull(formatSample, "Format sample is null!");
        assertNotEquals(sample, formatSample, "Format sample is not formatted!");
        assertFalse(formatSample.contains("\t"), "Format sample contains \\t");

        System.out.println(sample);
        System.out.println(formatSample);
    }
}

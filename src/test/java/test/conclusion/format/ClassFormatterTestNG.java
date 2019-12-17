package test.conclusion.format;

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

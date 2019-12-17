package test.conclusion.file;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.util.TestUtils;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class TestFileTestNG {

    private TestFile<List<String>> testFile;

    @BeforeClass
    public void setUpClass() {
        testFile = new TestFileListStringImpl(TestUtils.getTestResourcesFile("elapse_time_test")); //10 tests in a row
    }

    @Test
    public void content() {
        List<String> content = testFile.content();
        for(String line: content)
            System.out.println(line);
        for(String line: content) {
            assertFalse(line.contains("TEST BEGIN"), "Line have TEST BEGIN");
            assertFalse(line.contains("TEST END"), "Line have TEST BEGIN");
        }
    }

    @Test
    public void numberOfTests() {
        long countTest = testFile.numberOfTests();
        System.out.println(countTest);
        assertEquals(countTest, 10, "Number of test is wrong!");
    }
}

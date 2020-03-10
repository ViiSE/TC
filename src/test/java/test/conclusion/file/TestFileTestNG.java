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

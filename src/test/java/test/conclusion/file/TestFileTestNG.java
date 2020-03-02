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

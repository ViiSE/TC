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

package tc;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tc.file.TestFile;
import tc.file.TestFileListStringImpl;
import tc.format.*;
import tc.service.TCRunnerProducerService;
import tc.service.TCRunnerProducerServiceDefaultImpl;
import test.producer.TCProducerTestImpl;
import test.producer.TestClassCreatorProducerTestImpl;
import test.producer.TestMethodCreatorProducerTestImpl;
import test.util.TestUtils;

import java.util.List;

public class TCRunnerTestNG {

    private TCRunner<String> tcr;
    private TestFile<List<String>> tf;
    private String resFilePath;

    @BeforeClass
    public void setUp() {
        TestClasses tc = new TestClassesDefaultImpl();
        tf = new TestFileListStringImpl(TestUtils.getTestResourcesFile("elapse_time_test"));

        ClassFormatter<String> classFormatter = new ClassFormatterStringDefaultImpl();
        MethodFormatter<String> methodFormatter = new MethodFormatterStringDefaultImpl();
        TimeFormatter<String> timeFormatter = new TimeFormatterStringDefaultImpl();
        TestFormatter<String, String, String> tForm = new TestFormatterDefaultImpl(
                classFormatter,
                methodFormatter,
                timeFormatter);
        TCRunnerProducerService tcrps = new TCRunnerProducerServiceDefaultImpl(
                new TestMethodCreatorProducerTestImpl(),
                new TestClassCreatorProducerTestImpl(),
                new TCProducerTestImpl());
        resFilePath = TestUtils.getTestResourcesFile("con_res_test");

        tcr = new TCRunnerDefaultImpl(
                tc,
                tForm,
                tcrps);
    }

    @Test
    public void run() {
        tcr.run(resFilePath, tf);
    }
}

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

package test.conclusion;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.conclusion.file.TestFile;
import test.conclusion.file.TestFileListStringImpl;
import test.conclusion.format.*;
import test.conclusion.service.TestConclusionRunnerProducerService;
import test.conclusion.service.TestConclusionRunnerProducerServiceDefaultImpl;
import test.producer.TestClassCreatorProducerTestImpl;
import test.producer.TestConclusionProducerTestImpl;
import test.producer.TestMethodCreatorProducerTestImpl;
import test.util.TestUtils;

import java.util.List;

public class TestConclusionRunnerTestNG {

    private TestConclusionRunner<String> tcr;
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
        TestConclusionRunnerProducerService tcrps = new TestConclusionRunnerProducerServiceDefaultImpl(
                new TestMethodCreatorProducerTestImpl(),
                new TestClassCreatorProducerTestImpl(),
                new TestConclusionProducerTestImpl());
        resFilePath = TestUtils.getTestResourcesFile("con_res_test");

        tcr = new TestConclusionRunnerDefaultImpl(
                tc,
                tForm,
                tcrps);
    }

    @Test
    public void run() {
        tcr.run(resFilePath, tf);
    }
}

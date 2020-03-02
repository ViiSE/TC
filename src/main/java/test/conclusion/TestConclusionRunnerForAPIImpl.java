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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.conclusion.constants.APIConstants;
import test.conclusion.file.TestFile;
import test.conclusion.format.TestFormatter;
import test.conclusion.service.TestConclusionRunnerProducerService;

import java.util.List;

@Component("testConclusionRunnerForAPI")
@Scope("prototype")
public class TestConclusionRunnerForAPIImpl implements TestConclusionRunner<String> {

    private final TestClasses testClasses;
    private final TestFormatter<String, String, String> testFormatter;
    private final TestConclusionRunnerProducerService service;

    public TestConclusionRunnerForAPIImpl(
            TestClasses testClasses,
            TestFormatter<String, String, String> testFormatter,
            TestConclusionRunnerProducerService service) {
        this.testClasses = testClasses;
        this.testFormatter = testFormatter;
        this.service = service;
    }

    @Override
    public void run(String fullFilename, TestFile<List<String>> testFile) {
        List<String> content = testFile.content();
        String currentApiMethod = APIConstants.NONE;

        for(String line: content) {
            if(line.contains("\t")) {
                String methodName = testFormatter.formatMethod(line);
                String testTime = testFormatter.formatTime(line);
                TestMethod testMethod = service.testMethodCreatorProducer()
                        .getTestMethodCreatorDefaultInstance()
                        .create(new String[] {methodName, testTime});
                testClasses.addTestMethod(currentApiMethod, testMethod);
            } else {
                addClass(line);
                currentApiMethod = line;
            }
        }

        service.testConclusionProducer()
                .getTestConclusionDefaultInstance()
                .create(fullFilename, testClasses.calculateAvgTime(), testFile.numberOfTests());
    }

    private void addClass(String apiMethodName) {
        testClasses.addClass(service.testClassCreatorProducer()
                .getTestClassCreatorDefaultInstance()
                .create(testFormatter.formatClass(apiMethodName)));
    }
}

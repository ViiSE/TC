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

package test.conclusion.service;

import org.springframework.stereotype.Service;
import test.conclusion.producer.TestConclusionProducer;
import test.conclusion.producer.creator.TestClassCreatorProducer;
import test.conclusion.producer.creator.TestMethodCreatorProducer;

@Service("testConclusionRunnerProducerServiceDefault")
public class TestConclusionRunnerProducerServiceDefaultImpl implements TestConclusionRunnerProducerService {

    private final TestMethodCreatorProducer testMethodCreatorProducer;
    private final TestClassCreatorProducer testClassCreatorProducer;
    private final TestConclusionProducer testConclusionProducer;

    public TestConclusionRunnerProducerServiceDefaultImpl(
            TestMethodCreatorProducer testMethodCreatorProducer,
            TestClassCreatorProducer testClassCreatorProducer,
            TestConclusionProducer testConclusionProducer) {
        this.testMethodCreatorProducer = testMethodCreatorProducer;
        this.testClassCreatorProducer = testClassCreatorProducer;
        this.testConclusionProducer = testConclusionProducer;
    }

    @Override
    public TestMethodCreatorProducer testMethodCreatorProducer() {
        return testMethodCreatorProducer;
    }

    @Override
    public TestClassCreatorProducer testClassCreatorProducer() {
        return testClassCreatorProducer;
    }

    @Override
    public TestConclusionProducer testConclusionProducer() {
        return testConclusionProducer;
    }
}

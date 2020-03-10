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

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

package test.conclusion.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.conclusion.TestConclusion;
import test.conclusion.TestConclusionDefaultImpl;

import java.util.Date;
import java.util.Map;

@Service("testConclusionProducerDefault")
public class TestConclusionProducerDefaultImpl implements TestConclusionProducer {

    private final ApplicationContext ctx;

    public TestConclusionProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public TestConclusion<Map<String, Map<String, Date>>> getTestConclusionDefaultInstance() {
        return ctx.getBean("testConclusionDefault", TestConclusionDefaultImpl.class);
    }
}

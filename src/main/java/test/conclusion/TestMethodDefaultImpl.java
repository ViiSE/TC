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

import java.util.Date;
import java.util.List;

@Component("testMethodDefault")
@Scope("prototype")
public class TestMethodDefaultImpl implements TestMethod {

    private final String name;
    private final List<Date> testTimes;

    public TestMethodDefaultImpl(String name, List<Date> testTimes) {
        this.name = name;
        this.testTimes = testTimes;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public List<Date> testTimes() {
        return testTimes;
    }

    @Override
    public Date calculateAvgTime() {
        long sumTime = 0;
        for(Date time: testTimes)
            sumTime += time.getTime();
        return new Date(sumTime / testTimes.size());
    }

    @Override
    public void addTestTime(List<Date> testTime) {
        testTimes.addAll(testTime);
    }
}

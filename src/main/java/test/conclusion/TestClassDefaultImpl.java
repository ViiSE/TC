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

package test.conclusion;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("testClassDefault")
@Scope("prototype")
public class TestClassDefaultImpl implements TestClass {

    private final String name;
    private final List<TestMethod> testMethods;

    public TestClassDefaultImpl(String name, List<TestMethod> testMethods) {
        this.name = name;
        this.testMethods = testMethods;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Map<String, Date> calculateAvgTime() {
        Map<String, Date> avgTimes = new HashMap<>();
        for(TestMethod testMethod: testMethods)
            avgTimes.put(testMethod.name(), testMethod.calculateAvgTime());
        return avgTimes;
    }

    @Override
    public void addTestMethod(TestMethod method) {
        for(TestMethod testMethod: testMethods) {
            if(testMethod.name().equals(method.name())) {
                testMethod.addTestTime(method.testTimes());
                return;
            }
        }

        testMethods.add(method);
    }
}

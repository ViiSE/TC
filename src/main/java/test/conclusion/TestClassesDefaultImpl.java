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

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("testClassesDefault")
public class TestClassesDefaultImpl implements TestClasses {

    private final Map<String, TestClass> testClasses = new HashMap<>();

    @Override
    public void addTestMethod(String className, TestMethod testMethod) {
        if(testClasses.containsKey(className))
            testClasses.get(className).addTestMethod(testMethod);
    }

    @Override
    public void addClass(TestClass testClass) {
        if(!testClasses.containsKey(testClass.name()))
            testClasses.put(testClass.name(), testClass);
    }

    @Override
    public Map<String, Map<String, Date>> calculateAvgTime() {
        Map<String, Map<String, Date>> avgTime = new HashMap<>();
        testClasses.forEach((className, testClass) -> avgTime.put(className, testClass.calculateAvgTime()));

        return avgTime;
    }
}

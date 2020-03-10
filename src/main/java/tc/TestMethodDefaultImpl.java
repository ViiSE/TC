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

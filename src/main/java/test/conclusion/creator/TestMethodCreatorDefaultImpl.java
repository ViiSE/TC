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

package test.conclusion.creator;

import org.springframework.stereotype.Service;
import test.conclusion.TestMethod;
import test.conclusion.producer.TestMethodProducer;
import test.conclusion.time.DateParser;

import java.util.ArrayList;

@Service("testMethodCreatorDefault")
public class TestMethodCreatorDefaultImpl implements TestMethodCreator {

    private final TestMethodProducer testMethodProducer;
    private final DateParser dateParser;

    public TestMethodCreatorDefaultImpl(
            TestMethodProducer testMethodProducer,
            DateParser dateParser) {
        this.testMethodProducer = testMethodProducer;
        this.dateParser = dateParser;
    }

    @Override
    public TestMethod create(String[] methodNameAndTestTime) {
        return testMethodProducer.getTestMethodDefaultInstance(
                methodNameAndTestTime[0],
                new ArrayList<>() {{ add(dateParser.parse(methodNameAndTestTime[1])); }});
    }
}

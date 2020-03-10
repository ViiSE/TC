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

package tc.creator;

import org.springframework.stereotype.Service;
import tc.TestClass;
import tc.producer.TestClassProducer;

import java.util.ArrayList;

@Service("testClassCreatorDefault")
public class TestClassCreatorDefaultImpl implements TestClassCreator {

    private final TestClassProducer testClassProducer;

    public TestClassCreatorDefaultImpl(TestClassProducer testClassProducer) {
        this.testClassProducer = testClassProducer;
    }

    @Override
    public TestClass create(String testClassName) {
        return testClassProducer.getTestClassDefaultInstance(testClassName, new ArrayList<>());
    }
}

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

package tc.service;

import org.springframework.stereotype.Service;
import tc.producer.TCProducer;
import tc.producer.creator.TestClassCreatorProducer;
import tc.producer.creator.TestMethodCreatorProducer;

@Service("tcRunnerProducerServiceDefault")
public class TCRunnerProducerServiceDefaultImpl implements TCRunnerProducerService {

    private final TestMethodCreatorProducer testMethodCreatorProducer;
    private final TestClassCreatorProducer testClassCreatorProducer;
    private final TCProducer tcProducer;

    public TCRunnerProducerServiceDefaultImpl(
            TestMethodCreatorProducer testMethodCreatorProducer,
            TestClassCreatorProducer testClassCreatorProducer,
            TCProducer tcProducer) {
        this.testMethodCreatorProducer = testMethodCreatorProducer;
        this.testClassCreatorProducer = testClassCreatorProducer;
        this.tcProducer = tcProducer;
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
    public TCProducer tcProducer() {
        return tcProducer;
    }
}

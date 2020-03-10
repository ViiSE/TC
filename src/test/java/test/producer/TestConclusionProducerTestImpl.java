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

package test.producer;

import test.conclusion.TestConclusion;
import test.conclusion.TestConclusionDefaultImpl;
import test.conclusion.producer.TestConclusionProducer;
import test.conclusion.time.DateFormatterDefaultImpl;

import java.util.Date;
import java.util.Map;

public class TestConclusionProducerTestImpl implements TestConclusionProducer {

    @Override
    public TestConclusion<Map<String, Map<String, Date>>> getTestConclusionDefaultInstance() {
        return new TestConclusionDefaultImpl(
                new DateFormatterDefaultImpl(),
                new TestConclusionPrinterProducerTestImpl());
    }
}

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

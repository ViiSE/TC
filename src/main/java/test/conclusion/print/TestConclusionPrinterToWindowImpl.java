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

package test.conclusion.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("testConclusionPrinterToWindow")
@Scope("prototype")
public class TestConclusionPrinterToWindowImpl implements TestConclusionPrinter<Void> {

    private final TestConclusionPrinter<String> testConclusionPrinter;

    public TestConclusionPrinterToWindowImpl(TestConclusionPrinter<String> testConclusionPrinter) {
        this.testConclusionPrinter = testConclusionPrinter;
    }

    @Override
    public Void print() {
        String result = testConclusionPrinter.print();
        System.out.println(result);

        return null;
    }
}

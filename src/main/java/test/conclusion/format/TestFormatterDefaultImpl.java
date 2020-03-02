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

package test.conclusion.format;

import org.springframework.stereotype.Component;

@Component("testFormatterDefault")
public class TestFormatterDefaultImpl implements TestFormatter<String, String, String> {

    private final ClassFormatter<String> classFormatter;
    private final MethodFormatter<String> methodFormatter;
    private final TimeFormatter<String> timeFormatter;

    public TestFormatterDefaultImpl(
            ClassFormatter<String> classFormatter,
            MethodFormatter<String> methodFormatter,
            TimeFormatter<String> timeFormatter) {
        this.classFormatter = classFormatter;
        this.methodFormatter = methodFormatter;
        this.timeFormatter = timeFormatter;
    }

    @Override
    public String formatMethod(String data) {
        return methodFormatter.format(data);
    }

    @Override
    public String formatClass(String data) {
        return classFormatter.format(data);
    }

    @Override
    public String formatTime(String data) {
        return timeFormatter.format(data);
    }
}

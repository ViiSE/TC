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

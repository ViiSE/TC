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

package tc.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tcPrinterToWindow")
@Scope("prototype")
public class TCPrinterToWindowImpl implements TCPrinter<Void> {

    private final TCPrinter<String> tcPrinter;

    public TCPrinterToWindowImpl(TCPrinter<String> tcPrinter) {
        this.tcPrinter = tcPrinter;
    }

    @Override
    public Void print() {
        String result = tcPrinter.print();
        System.out.println(result);

        return null;
    }
}

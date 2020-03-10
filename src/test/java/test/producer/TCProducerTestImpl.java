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

import tc.TC;
import tc.TCDefaultImpl;
import tc.producer.TCProducer;
import tc.time.DateFormatterDefaultImpl;

import java.util.Date;
import java.util.Map;

public class TCProducerTestImpl implements TCProducer {

    @Override
    public TC<Map<String, Map<String, Date>>> getTCDefaultInstance() {
        return new TCDefaultImpl(
                new DateFormatterDefaultImpl(),
                new TCPrinterProducerTestImpl());
    }
}

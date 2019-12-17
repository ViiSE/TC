package test.producer;

import test.conclusion.producer.time.DateFormatterProducer;
import test.conclusion.time.DateFormatter;
import test.conclusion.time.DateFormatterDefaultImpl;

public class DateFormatterProducerTestImpl implements DateFormatterProducer {

    @Override
    public DateFormatter getDateFormatterDefaultInstance() {
        return new DateFormatterDefaultImpl();
    }
}

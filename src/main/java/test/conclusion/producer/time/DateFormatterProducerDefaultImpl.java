package test.conclusion.producer.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.conclusion.time.DateFormatter;

@Service("dateFormatterProducerDefault")
public class DateFormatterProducerDefaultImpl implements DateFormatterProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public DateFormatter getDateFormatterDefaultInstance() {
        return ctx.getBean(DateFormatter.class);
    }
}

package siran.test.heigh.chain;

import com.lmax.disruptor.EventHandler;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:上午11:52
 */
public class Handler2 implements EventHandler<Trade> {

    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("handler 2 : SET ID");
        TimeUnit.SECONDS.sleep(2);
        event.setId(UUID.randomUUID().toString());
    }
}

package siran.test.heigh.chain;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:上午11:52
 */
public class Handler1 implements EventHandler<Trade>, WorkHandler<Trade> {

    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }
    @Override
    public void onEvent(Trade event) throws Exception {
        System.err.println("handler 1 : SET NAME");
        Thread.sleep(1000);
        event.setName("H1");
    }
}

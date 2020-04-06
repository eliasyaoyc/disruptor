package siran.test.heigh.chain;

import com.lmax.disruptor.EventHandler;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:上午11:52
 */
public class Handler5 implements EventHandler<Trade> {

    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("handler 4 : SET PRICE");
        Thread.sleep(1000);
        event.setPrice(17.0);
    }
}

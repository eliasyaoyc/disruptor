package siran.test.heigh.chain;

import com.lmax.disruptor.EventHandler;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:上午11:52
 */
public class Handler3 implements EventHandler<Trade> {

    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("handler 3 : NAME: "
                + event.getName()
                + ", ID: "
                + event.getId()
                + ", PRICE: "
                + event.getPrice()
                + " INSTANCE : " + event.toString());
    }
}

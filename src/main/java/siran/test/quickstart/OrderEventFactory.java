package siran.test.quickstart;

import com.lmax.disruptor.EventFactory;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:上午9:46
 */
public class OrderEventFactory implements EventFactory<OrderEvent> {

    @Override
    public OrderEvent newInstance() {
        return new OrderEvent();
    }
}

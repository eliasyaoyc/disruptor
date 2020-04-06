package siran.test.quickstart;


import com.lmax.disruptor.EventHandler;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:上午9:47
 */
public class OrderEventHandler implements EventHandler<OrderEvent> {


    @Override
    public void onEvent(OrderEvent orderEvent, long l, boolean b) throws Exception {
        System.out.println("消费者：" + orderEvent.getValue());
    }
}

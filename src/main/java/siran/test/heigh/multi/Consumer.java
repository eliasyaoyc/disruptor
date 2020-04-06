package siran.test.heigh.multi;

import com.lmax.disruptor.WorkHandler;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:下午1:49
 */
public class Consumer implements WorkHandler<Order> {
    private String ConsumerId;
    private static AtomicInteger count = new AtomicInteger(0);

    public Consumer(String consumerId) {
        ConsumerId = consumerId;
    }

    @Override
    public void onEvent(Order event) throws Exception {
        Thread.sleep(1 * new Random().nextInt(5));
        System.err.println("当前消费者： " + this.ConsumerId + ", 消费信息ID： " + event.getId());
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }
}

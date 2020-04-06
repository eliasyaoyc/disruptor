package siran.test.quickstart;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:上午10:15
 */
public class OrderEventProducer {
    private RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb) {
        long sequence = ringBuffer.next();
        try {
            OrderEvent orderEvent = ringBuffer.get(sequence);
            orderEvent.setValue(bb.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

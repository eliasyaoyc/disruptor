package siran.test.quickstart;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

/**
 * @Author: siran.yao
 * @time: 2020/4/6:上午9:50
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int bufferSize = 1024 * 1024;
        /**
         * 1. eventFactory  消息工场对象
         * 2. ringBufferSize 容器长度
         * 3. executor: 线程池
         * 4. producerType ：单线程 还是多线程
         * 5. waitStrategy 等待策略
         */
        // Construct the Disruptor
        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                new OrderEventFactory(),
                bufferSize,
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()),
                ProducerType.SINGLE,
                new BlockingWaitStrategy());

        // Connect the handler
        disruptor.handleEventsWith(new OrderEventHandler());

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

        OrderEventProducer producer = new OrderEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            producer.onData(bb);
            Thread.sleep(1000);
        }
    }
}

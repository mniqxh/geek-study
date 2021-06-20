package cn.com.dodo.week12;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于 JMS，写代码分别实现对于 queue 和 topic 的消息生产和消费
 */
public class ActivemqApplication {

    public static void main(String[] args) {
        testTopic();
        testQueue();
    }

    // 测试队列
    private static void testQueue() {
        testMQ(new ActiveMQQueue("test.queue"));
    }

    // 测试消息订阅
    private static void testTopic() {
        testMQ(new ActiveMQTopic("test.topic"));
    }

    private static void testMQ(Destination destination) {
        try {
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.56.2:61616");
            ActiveMQConnection conn = (ActiveMQConnection) factory.createConnection();
            conn.start();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

            ThreadPoolExecutor threadPool = createThreadPool();
            CountDownLatch cdl = new CountDownLatch(3);
            threadPool.execute(createProducer(0, session, destination, cdl));
            for (int i = 0; i < 2; i++) {
                threadPool.execute(createConsumer(i, session, destination, cdl));
            }
            cdl.await();
            threadPool.shutdown();
            session.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 创建生产者
    private static Runnable createProducer(int no, Session session, Destination destination, CountDownLatch cdl) {
        return () -> {
            try {
                MessageProducer producer = session.createProducer(destination);
                int index = 0;
                while (index++ < 10) {
                    TextMessage message = session.createTextMessage(index + " message.");
                    producer.send(message);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cdl.countDown();
            }
        };
    }

    // 创建消费者
    private static Runnable createConsumer(int no, Session session, Destination destination, CountDownLatch cdl) {
        final AtomicInteger count = new AtomicInteger(0);
        return () -> {
            try {
                MessageConsumer consumer = session.createConsumer(destination);
                consumer.setMessageListener((message) -> {
                    System.out.println("consumer:" + no + " " + count.incrementAndGet() + " => receive from " + destination.toString() + ": " + message);
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cdl.countDown();
            }
        };
    }

    public static ThreadPoolExecutor createThreadPool() {
        return new ThreadPoolExecutor(3, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10), new ActiveMQDemoThreadFactory());
    }

}



package cn.com.dodo.geek.statuy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class SyncSubThreadResult {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();

		// �����ﴴ��һ���̻߳��̳߳أ�
		// �첽ִ�� ���淽��

		// int result = sum(); //���ǵõ��ķ���ֵ
		// int result = getByThreadJoin();
		// int result = getByFutrue();
		// int result = getByCDL();
		// int result = getByCB();
		int result = getByBQ();
		// ȷ�� �õ�result �����
		System.out.println("�첽������Ϊ��" + result);

		System.out.println("ʹ��ʱ�䣺" + (System.currentTimeMillis() - start) + " ms");

		// Ȼ���˳�main�߳�
	}


	private static int getByBQ() throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
		Thread t = new Thread(() -> {
			queue.add(sum());
		});
		t.start();
		int result = queue.take();
		return result;
	}

	private static int getByCB() throws InterruptedException, BrokenBarrierException {
		CyclicBarrier cb = new CyclicBarrier(2);

		AtomicInteger result = new AtomicInteger();
		Thread t = new Thread(() -> {
			try {
				result.set(sum());
			} finally {
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		cb.await();
		return result.get();
	}

	private static int getByCDL() throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(1);
		AtomicInteger result = new AtomicInteger();
		Thread t = new Thread(() -> {
			try {
				result.set(sum());
			} finally {
				cdl.countDown();
			}
		});
		t.start();
		cdl.await();
		return result.get();
	}

	private static int getByFutrue() throws InterruptedException, ExecutionException {
		ExecutorService pool = null;
		try {
			pool = Executors.newSingleThreadExecutor();

			Future<Integer> f = pool.submit(() -> {
				return sum();
			});

			return f.get();
		} finally {
			if (pool != null) {
				pool.shutdown();
			}
		}
	}

	private static int getByThreadJoin() throws InterruptedException {
		AtomicInteger result = new AtomicInteger();
		Thread t = new Thread(() -> {
			result.set(sum());
		});
		t.start();
		t.join();
		return result.get();
	}

	private static int sum() {
		return fibo(36);
	}

	private static int fibo(int a) {
		if (a < 2)
			return 1;
		return fibo(a - 1) + fibo(a - 2);
	}

}

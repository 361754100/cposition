package com.hro.core.cposition.threadpool;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通用的线程池任务管理器
 * @author Mojianzhang
 *
 */
public class CommonTaskManager {
	
	private static CommonTaskManager instance = null;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonTaskManager.class);
	
	private final static int initialThreadSize = 5;
	private final static int maxThreadSize = 100;
	private final static int threadWaitingTimeoutMillis = 30000;
	private final static int backlogSize = 3000;
	
	private final static Random random = new Random();
	
	private ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor( initialThreadSize, maxThreadSize, threadWaitingTimeoutMillis,
			TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(backlogSize));
	
	private static class HolderClass {
		private static final CommonTaskManager manager = new CommonTaskManager();
	}
	
	public static CommonTaskManager getInstance() {
		if(instance == null) {
			instance = HolderClass.manager;
		}
		return instance;
	}
	
	public void addTask(Runnable task) {
		logger.debug("[CommonTaskManager] Active Thread Count ->"+taskExecutor.getActiveCount()+"  maxThreadSize ->"+maxThreadSize);
		if (taskExecutor.getQueue().size() < backlogSize) {
			taskExecutor.execute(task);
		} else {
			logger.info("CommonTaskManager backlogSize has reach too limit!!");
		}
	}
	
	public void stop() {
		taskExecutor.getQueue().clear();
		taskExecutor.shutdownNow();
		logger.info("<<< CommonTaskManager Executor shutdown >>>");
	}
	
	/**
	 * 多线程间利用同一个 random 获取不同的随机数(整型)
	 * @param min
	 * @param max
	 * @return
	 */
	public int getRandomInt(int min, int max) {
	    int randomNum = random.nextInt(max)%(max-min+1) + min;
	    return randomNum;
	}
	
}

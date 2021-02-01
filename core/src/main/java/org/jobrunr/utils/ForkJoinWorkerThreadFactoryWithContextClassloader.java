package org.jobrunr.utils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;

public class ForkJoinWorkerThreadFactoryWithContextClassloader implements ForkJoinWorkerThreadFactory {

	@Override
	public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
		return new ForkJoinWorkerThreadWithContextClassLoader(pool);
	}

	private static class ForkJoinWorkerThreadWithContextClassLoader extends ForkJoinWorkerThread {

		protected ForkJoinWorkerThreadWithContextClassLoader(ForkJoinPool pool) {
			super(pool);
			this.setContextClassLoader(Thread.currentThread().getContextClassLoader());
		}

	}

}

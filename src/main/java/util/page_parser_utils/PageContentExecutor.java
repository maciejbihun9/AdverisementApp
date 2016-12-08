package util.page_parser_utils;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Maciek on 2016-11-22.
 * We do not have any long running processes.
 * Use fixed number of threads or change it accordingly,
 *
 * Do not create to small executor
 * If we have too many tasks then new thread mark to execution later.
 *
 *
 */
public class PageContentExecutor {

    private static int corePoolSize = Runtime.getRuntime().availableProcessors();

    private static int maximumPoolSize = 10;

    private static long keepAliveTime = 10000;

    private static int numberOfTasksInQueue = 5;

    private static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(numberOfTasksInQueue);

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
            keepAliveTime, TimeUnit.MILLISECONDS, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());


    public void submitTaskToExecutor(Runnable newTaskRunnable){
        threadPoolExecutor.submit(newTaskRunnable);
    }
}

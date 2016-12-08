package util.page_parser_utils;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Maciek on 2016-11-23.
 */
public class PageContentThreadFactory implements ThreadFactory {

    private final String poolName;

    public PageContentThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new PageContentThread(r, poolName);
    }
}

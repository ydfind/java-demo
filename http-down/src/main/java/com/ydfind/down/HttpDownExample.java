package com.ydfind.down;

import com.ydfind.down.common.CrawlerFileCache;
/**
 * http下载类
 * @author ydfind
 * @date 2019.10.12
 */
public class HttpDownExample {

    public static void downByHttp(String url) throws Exception {
        String content = CrawlerFileCache.getHtmlStrByUrl(url, "GRADUATE");
    }
}

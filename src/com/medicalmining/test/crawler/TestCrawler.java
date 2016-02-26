package com.medicalmining.test.crawler;

import org.junit.Test;

import com.medialmining.crawler.CrawlerDataUtil;
import com.medialmining.crawler.GetWordExecutor;
import com.medialmining.crawler.GetWordSelector;
import com.medicalmining.file.FileUtil;
import com.medicalmining.file.FileUtilRead;
import com.medicalmining.file.FileUtilWrite;

public class TestCrawler {

	@Test
	public void testCrawler() {
		CrawlerDataUtil crawlerDataUtil = new CrawlerDataUtil();
		crawlerDataUtil.setBreath(20);
		crawlerDataUtil.setThreadCount(10);
		crawlerDataUtil.addOneSeed("http://jbk.39.net/bw_t2_v6/");
		crawlerDataUtil.addOneRegex("http://jbk.39.net/bw_v6_p.*");
		crawlerDataUtil.addSelectStr("dt[class=clearfix]>h3");
		GetWordSelector getWordSelector = new GetWordSelector(crawlerDataUtil);
		GetWordExecutor executor = new GetWordExecutor(getWordSelector, "jbk");
		executor.start();
		FileUtil fileUtil = new FileUtilWrite("wordresult.txt");
		executor.writeWordResultToFile(fileUtil);
	}
}

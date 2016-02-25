package test.com.crawler.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.crawler.data.CrawlerDataUtil;
import com.crawler.data.GetWordExecutor;
import com.crawler.data.GetWordSelector;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;

public class GetWordSelectorTest {

	@Test
	public void test() {
		CrawlerDataUtil crawlerDataUtil = new CrawlerDataUtil();
		crawlerDataUtil.setBreath(20);
		crawlerDataUtil.setThreadCount(10);
		crawlerDataUtil.addOneSeed("http://jbk.39.net/bw_t2_v6/");
		crawlerDataUtil.addOneRegex("http://jbk.39.net/bw_v6_p.*");
		crawlerDataUtil.addSelectStr("dt[class=clearfix]>h3");
		GetWordSelector getWordSelector = new GetWordSelector(crawlerDataUtil);
		GetWordExecutor executor = new GetWordExecutor(getWordSelector, "jbk");
		executor.start();
		for (String arr[] : executor.getResList()) {
			for (String str : arr) {
                System.out.println(str);
			}
		}
	}

}

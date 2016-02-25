package test.com.crawler.data;

import org.junit.Test;

import com.crawler.data.CrawlerDataUtil;
import com.crawler.data.WordCrawler;

import junit.framework.Assert;

public class TestCrawler {


	@Test
	public void testgetData() {
		CrawlerDataUtil crawlerDataUtil = new CrawlerDataUtil();
		crawlerDataUtil.setBreath(20);
		crawlerDataUtil.setThreadCount(10);
		crawlerDataUtil.addOneSeed("http://jbk.39.net/bw_t2_v5/");
		crawlerDataUtil.addOneRegex("http://jbk.39.net/bw_t2_p.*");
		WordCrawler crawler = new WordCrawler(crawlerDataUtil, "jbk");
		crawler.start();
//		for (String str : crawler.getResultList()) {
//			Assert.assertEquals("¸É¿È", str);
//		}
	}

	@Test
	public void testgetDataNoSeed() {
		CrawlerDataUtil crawlerDataUtil = new CrawlerDataUtil();
		crawlerDataUtil.setBreath(20);
		crawlerDataUtil.setThreadCount(10);
		crawlerDataUtil.addOneRegex("http://jbk.39.net/bw_t2_p.*");
		WordCrawler crawler = new WordCrawler(crawlerDataUtil, "jbk");
		crawler.start();
		Assert.assertEquals(null, crawler.getResultList());
	}
}

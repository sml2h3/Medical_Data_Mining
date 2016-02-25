package test.com.crawler.data;

import org.junit.Test;

import com.crawler.data.CrawlerDataUtil;

import junit.framework.Assert;

public class TestCrawlerDataUtil {

	@Test
	public void testCrawlerSeedList() {
		CrawlerDataUtil crawler = new CrawlerDataUtil();
		crawler.addOneSeed("http://jbk.39.net/bw_t2_p190#ps");
		crawler.addOneSeed("http://fanyi.youdao.com/");
		Assert.assertEquals("http://jbk.39.net/bw_t2_p190#ps", crawler.getSeed(0));
		Assert.assertEquals("http://fanyi.youdao.com/", crawler.getSeed(1));
		Assert.assertEquals(2, crawler.getSeedList().size());

	}

	@Test
	public void testCrawlerSeedListMoreSize() {
		CrawlerDataUtil crawler = new CrawlerDataUtil();
		crawler.addOneSeed("http://jbk.39.net/bw_t2_p190#ps");
		crawler.addOneSeed("http://fanyi.youdao.com/");
		Assert.assertEquals(null, crawler.getSeed(2));
		Assert.assertEquals(null, crawler.getSeed(6));
	}

	@Test
	public void testCrawlerRegexList() {
		CrawlerDataUtil crawler = new CrawlerDataUtil();
		crawler.addOneRegex("http://jbk.39.net/bw_t2_p.*");
		Assert.assertEquals("http://jbk.39.net/bw_t2_p.*", crawler.getRegex(0));
		Assert.assertEquals(null, crawler.getRegex(2));
		Assert.assertEquals(1, crawler.getRegexList().size());
	}

	@Test
	public void testThreadConut() {
		CrawlerDataUtil crawler = new CrawlerDataUtil();
		crawler.setThreadCount(10);
		Assert.assertEquals(10, crawler.getThreadCount());
		crawler.setThreadCount(25);
		Assert.assertEquals(25, crawler.getThreadCount());
	}

	@Test
	public void testBreath() {
		CrawlerDataUtil crawler = new CrawlerDataUtil();
		crawler.setBreath(20);
		Assert.assertEquals(20, crawler.getBreath());
		crawler.setBreath(40);
		Assert.assertEquals(30, crawler.getBreath());
	}

	@Test
	public void testSelectCssStr() {
		CrawlerDataUtil crawler = new CrawlerDataUtil();
		crawler.addSelectStr("dt[class=clearfix]>h3");
		Assert.assertEquals("dt[class=clearfix]>h3", crawler.getSelectStr(0));
		Assert.assertEquals(null, crawler.getSelectStr(2));
		Assert.assertEquals(1, crawler.getSelectList().size());
	}

}

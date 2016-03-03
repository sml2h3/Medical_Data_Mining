package test.com.medicalmining.crawler;

import org.junit.Test;

import com.medialmining.crawler.Crawler;
import com.medicalmining.file.FileUtilRead;

import org.junit.Assert;

public class TestCrawler {

	@SuppressWarnings("deprecation")
	@Test
	public void testCrawler() {
		String startSeed = "http://jbk.39.net/bw_t2/";
		String[] filterByRegs = { "http://jbk.39.net/bw_t2_p.*" };
		String[] cssSelectors = { "dt[class=clearfix]>h3" };
		Crawler inllnessCrawler = new Crawler(20, 20, startSeed, filterByRegs, cssSelectors);
		inllnessCrawler.run();
		Assert.assertEquals(readFile("expected.txt"), readFile("wordresult.txt"));
	}

	private String readFile(String name) {
		FileUtilRead fileUtilExpected = new FileUtilRead(name);
		String expect = fileUtilExpected.getFromFile("gbk");
		return expect;
	}
}

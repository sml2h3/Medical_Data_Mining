package com.medicalmining.test.crawler;

import org.junit.Before;
import org.junit.Test;

import com.medialmining.crawler.CrawlerDataUtil;
import com.medialmining.crawler.GetWordSelector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class TestWordSelector {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWordSelector() {
		CrawlerDataUtil crawlerDataUtil = new CrawlerDataUtil();
		crawlerDataUtil.setBreath(20);
		crawlerDataUtil.setThreadCount(10);
		crawlerDataUtil.addOneSeed("http://jbk.39.net/bw_t2_v6/");
		crawlerDataUtil.addOneRegex("http://jbk.39.net/bw_v6_p.*");
		crawlerDataUtil.addSelectStr("dt[class=clearfix]>h3");
		GetWordSelector wordSelector = new GetWordSelector(crawlerDataUtil);
		BreadthCrawler oneCrawler = new BreadthCrawler("jbk", true) {
			@Override
			public void visit(Page page, CrawlDatums arg1) {
				if (wordSelector.isMatch(page.getUrl())) {
					String[] arr=wordSelector.getInfoFromPage(page);
					for(String res:arr){
						System.out.println(res);
					}
				}
			}
		};
		wordSelector.init(oneCrawler);
		try {
			oneCrawler.start(wordSelector.getBreath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

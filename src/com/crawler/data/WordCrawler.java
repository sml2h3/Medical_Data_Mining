package com.crawler.data;

import java.util.List;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class WordCrawler {

	private CrawlerDataUtil dataUtil;
	private String name;
	private List<String> resultList;

	public WordCrawler(CrawlerDataUtil data, String name) {
		dataUtil = data;
		this.name = name;
	}

	
	public void start() {
		Crawler oneCrawler = new BreadthCrawler(name, true) {
			@Override
			public void visit(Page arg0, CrawlDatums arg1) {
				// TODO Auto-generated method stub

			}
		};
		if (dataUtil.getSeedList().size() == 0) {
			System.out.println("务必添加一个起始种子");
		}
	}

	public List<String> getResultList(){
		return(resultList);
	}

}

package com.medialmining.crawler;

import java.util.ArrayList;

import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class GetWordSelector {

	private CrawlerDataUtil dataUtil;

	public GetWordSelector(CrawlerDataUtil data) {
		dataUtil = data;
	}

	public boolean init(BreadthCrawler oneCrawler) {
		if (dataUtil.getSeedList().size() == 0) {
			System.out.println("务必添加一个起始种子");
			return (false);
		} else {
			for (String eachSeed : dataUtil.getSeedList()) {
				oneCrawler.addSeed(eachSeed);
			}
		}
		for (String eachRegex : dataUtil.getRegexList()) {
			oneCrawler.addRegex(eachRegex);
		}
		oneCrawler.setThreads(dataUtil.getThreadCount());
		return (true);
	}

	public boolean isMatch(String url) {
		boolean isMatch = false;
		for (String regex : dataUtil.getRegexList()) {
			if (url.matches(regex)) {
				isMatch = true;
				break;
			}
		}
		return (isMatch);
	}

	public String[] getInfoFromPage(Page page) {
		List<String> data = new ArrayList<>();
		for (String selectStr : dataUtil.getSelectList()) {
			Elements elements = page.getDoc().select(selectStr);
			for (Element oneElement : elements) {
				String title = oneElement.text();
				data.add(title);
			}
		}
		final int size = data.size();
		String[] arr = (String[]) data.toArray(new String[size]);
		return (arr);
	}

	public int getBreath() {
		return (dataUtil.getBreath());
	}
	


}

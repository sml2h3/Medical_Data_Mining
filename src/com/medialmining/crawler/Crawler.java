package com.medialmining.crawler;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.medicalmining.file.FileUtil;
import com.medicalmining.file.FileUtilWrite;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler {

	private String startSeed;
	private String[] filterByRegs;
	private int threadCount;
	private int breath;
	private String[] cssSelectors;
	private String name = "jbk";
	private List<String[]> resultList = new ArrayList<>();

	public final static int MAX_THREAD = 20;
	public final static int MAX_BREATH = 30;

	public Crawler(int breath, int threadCount, String startSeed, String[] filterByRegs, String[] cssSeletors) {
		this.breath = breath >= MAX_BREATH ? MAX_BREATH : breath;
		this.threadCount = threadCount >= MAX_THREAD ? MAX_THREAD : threadCount;
		this.filterByRegs = filterByRegs;
		this.startSeed = startSeed;
		this.cssSelectors = cssSeletors;
	}

	private boolean isMatch(String url) {
		for (String regex : this.filterByRegs) {
			if (url.matches(regex)) {
				return true;
			}
		}
		return false;
	}

	private String[] getInfoFromPage(Page page) {
		List<String> data = new ArrayList<>();
		for (String selectStr : cssSelectors) {
			Elements elements = page.getDoc().select(selectStr);
			for (Element element : elements) {
				data.add(element.text());
			}
		}
		return data.toArray(new String[data.size()]);
	}

	public void run() {
		BreadthCrawler crawler = new BreadthCrawler(this.name, true) {
			@Override
			public void visit(Page page, CrawlDatums arg1) {
				if (isMatch(page.getUrl())) {
					resultList.add(getInfoFromPage(page));
				}
			}
		};

		crawler.addSeed(this.startSeed);
		for (String regex : this.filterByRegs) {
			crawler.addRegex(regex);
		}
		crawler.setThreads(this.threadCount);
		try {
			crawler.start(this.breath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeResult2file();
	}

	private void writeResult2file() {
		FileUtil fileUtil = new FileUtilWrite("wordresult.txt");
		fileUtil.write(JSON.toJSONString(resultList));
	}

}

package com.medialmining.crawler;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.medicalmining.file.FileUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class GetWordExecutor {

	private GetWordSelector mSelector;
	private String name;
	private List<String[]> resultList;

	public GetWordExecutor(GetWordSelector selector, String name) {
		mSelector = selector;
		this.name = name;
		resultList = new ArrayList<>();
	}

	public void start() {
		BreadthCrawler crawler = new BreadthCrawler(name, true) {
			@Override
			public void visit(Page page, CrawlDatums arg1) {
				if (mSelector.isMatch(page.getUrl())) {
					resultList.add(mSelector.getInfoFromPage(page));
				}
			}
		};
		mSelector.init(crawler);
		try {
			crawler.start(mSelector.getBreath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String[]> getResList() {
		return (resultList);
	}

	public void writeWordResultToFile(FileUtil wFileUtil) {
		wFileUtil.writeToFile(JSON.toJSONString(resultList));
	}

}

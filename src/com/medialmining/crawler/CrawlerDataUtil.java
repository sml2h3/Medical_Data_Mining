package com.medialmining.crawler;

import java.util.ArrayList;
import java.util.List;

public class CrawlerDataUtil {

	private List<String> seedList;
	private List<String> regexList;
	private int threadCount;
	private int breath;
	private List<String> selectList;

	public final static int MAX_THREAD = 20;
	public final static int MAX_BREATH = 30;

	public CrawlerDataUtil() {
		this.seedList = new ArrayList<>();
		this.regexList = new ArrayList<>();
		this.selectList = new ArrayList<>();
	}

	public void addOneSeed(String url) {
		seedList.add(url);
	}

	public String getSeed(int index) {
		if (index >= seedList.size()) {
			return (null);
		}
		return (seedList.get(index));
	}

	public List<String> getSeedList() {
		return (seedList);
	}

	public List<String> getRegexList() {
		return (regexList);
	}

	public List<String> getSelectList() {
		return (selectList);
	}

	public void addOneRegex(String url) {
		this.regexList.add(url);
	}

	public String getRegex(int index) {
		if (index >= regexList.size()) {
			return (null);
		}
		return (regexList.get(index));
	}

	public void setThreadCount(int count) {
		if (count >= MAX_THREAD) {
			threadCount = count;
		} else {
			this.threadCount = count;
		}
	}

	public int getThreadCount() {
		return (this.threadCount);
	}

	public void setBreath(int breath) {
		if (breath > MAX_BREATH) {
			this.breath = MAX_BREATH;
		} else {
			this.breath = breath;
		}
	}

	public int getBreath() {
		return (this.breath);
	}

	public void addSelectStr(String select) {
		this.selectList.add(select);
	}

	public String getSelectStr(int index) {
		if (index >= selectList.size()) {
			return (null);
		} else {
			return (selectList.get(index));
		}
	}

}

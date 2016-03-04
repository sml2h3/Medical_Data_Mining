package com.medicalmining.participles;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.medicalmining.file.FileUtilRead;
import com.medicalmining.file.FileUtilWrite;

import kevin.zhang.NLPIR;

public class Participle {

	private NLPIR mNLPIR;
	private Set<String> mWordsSet;

	public Participle(String wordFilePath) {
		init(wordFilePath);
	}

	private void init(String wordFilePath) {
		try {
			if (initNLPIRSystem()) {
				addWordsIntoSystem(wordFilePath);
			} else {
				System.out.println("NLPIRSystem init fail");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private boolean initNLPIRSystem() throws UnsupportedEncodingException {
		mNLPIR = new NLPIR();
		return NLPIR.NLPIR_Init("./file/".getBytes("utf-8"), 1);
	}

	private void addWordsIntoSystem(String wordfilePath) throws UnsupportedEncodingException {
		for (String strsLevelOne : parseJSONnStr(getContentFromFile(wordfilePath))) {
			for (String strsLevelTwo : parseJSONnStr(strsLevelOne)) {
				mNLPIR.NLPIR_AddUserWord((strsLevelTwo + " n").getBytes("utf-8"));
				if (this.mWordsSet == null) {
					mWordsSet = new HashSet<>();
				}
				mWordsSet.add(strsLevelTwo);
			}
		}
	}

	private List<String> parseJSONnStr(String parseStr) {
		return (JSON.parseArray(parseStr, String.class));
	}

	private String getContentFromFile(String filePath) {
		FileUtilRead fileUtilRead = new FileUtilRead(filePath);
		return (fileUtilRead.getFromFile("gbk"));
	}

	public void doParticiple(String contentfilePath, String targetFilePath) {
		List<String> resultList = new ArrayList<>();
		for (String oneWord : getParagraphProcess(getContentFromFile(contentfilePath))) {
			if (oneWord.endsWith("/n")) {
				oneWord = isMatch(oneWord);
				if (oneWord != null) {
					resultList.add(oneWord);
				}
			}
		}
		writeToFile(resultList, targetFilePath);
	}

	private String isMatch(String str) {
		str = str.substring(0, str.length() - 2);
		return mWordsSet.contains(str) ? str : null;
	}

	private String[] getParagraphProcess(String participledContentContentStr) {
		try {
			if (participledContentContentStr != null) {
				byte[] resBytes = mNLPIR.NLPIR_ParagraphProcess(participledContentContentStr.getBytes("UTF-8"), 1);
				return new String(resBytes, "utf-8").split(" ");
			}
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return (new String[0]);
	}

	private void writeToFile(List<String> resultList, String outputPath) {
		FileUtilWrite fileUtilWrite = new FileUtilWrite(outputPath);
		fileUtilWrite.write(JSON.toJSONString(resultList));
	}

}

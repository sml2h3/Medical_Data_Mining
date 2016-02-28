package com.medicalmining.file;

import java.io.File;
import java.io.IOException;

public abstract class FileUtil {

	protected File mFile;

	public FileUtil(String filePath) {
		mFile = new File(filePath);
		initFile();
	}

	protected void initFile() {
		if (!mFile.exists()) {
			try {
				mFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public FileUtil(File file) {
		this.mFile = file;
		initFile();
	}

	public abstract String getFromFile(String charset);

	public abstract void write(String outputStr);

}

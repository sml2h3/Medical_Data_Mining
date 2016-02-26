package com.medicalmining.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtilWrite extends FileUtil {

	public FileUtilWrite(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public FileUtilWrite(String filePath) {
		super(filePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getFromFile(String charset) {
		return null;
	}

	@Override
	public void writeToFile(String outputStr) {
		// TODO Auto-generated method stub
		if (outputStr == null) {
			System.out.println("输出字符串为空，无法输出");
			return;
		}
		try {
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(mFile));
			outputStream.write(outputStr.getBytes());
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}
	}
}

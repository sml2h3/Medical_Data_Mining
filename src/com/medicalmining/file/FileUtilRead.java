package com.medicalmining.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtilRead extends FileUtil {

	public FileUtilRead(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public FileUtilRead(String filePath) {
		super(filePath);
	}
	
	public String getFromFile(String charset) {
		if (mFile == null) {
			return (null);
		}
		try {
			String tmpStr = null;
			StringBuilder stringBuilder = new StringBuilder();
			FileInputStream fileInputStream = new FileInputStream(mFile);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, charset));
			while ((tmpStr = bufferedReader.readLine()) != null) {
				stringBuilder.append(tmpStr + "\n");
			}
			fileInputStream.close();
			bufferedReader.close();
			return (stringBuilder.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (null);
	}

	@Override
	public void writeToFile(String outputStr) {
		// TODO Auto-generated method stub
		
	}



}

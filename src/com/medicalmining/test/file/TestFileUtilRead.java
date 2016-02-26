package com.medicalmining.test.file;

import org.junit.Before;
import org.junit.Test;

import com.medicalmining.file.FileUtilRead;

import junit.framework.Assert;

public class TestFileUtilRead {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFilePath() {
		FileUtilRead fileUtil = new FileUtilRead("test.txt");
		
	}

	@Test
	public void testgetFromFileHasStrOneLine() {
		FileUtilRead fileUtil = new FileUtilRead("testoneline.txt");
		Assert.assertEquals("asgega" + "\n", fileUtil.getFromFile("gbk"));
	}

	@Test
	public void testgetFromFileHasStrMutipleLine() {
		FileUtilRead fileUtil = new FileUtilRead("testmutipleline.txt");
		Assert.assertEquals("asgega" + "\n" + "lzw" + "\n", fileUtil.getFromFile("gbk"));
	}
	
	@Test
	public void testgetFromFileNull() {
		FileUtilRead fileUtil = new FileUtilRead("");;
	}


}

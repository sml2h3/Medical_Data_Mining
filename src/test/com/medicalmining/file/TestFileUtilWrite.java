package test.com.medicalmining.file;

import org.junit.Before;
import org.junit.Test;

import com.medicalmining.file.FileUtilWrite;

public class TestFileUtilWrite {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWriteTofile() {
		FileUtilWrite fileUtilWrite = new FileUtilWrite("output.txt");
		fileUtilWrite.write("ageag");
	}
	
	@Test
	public void testWriteTofileNull(){
		FileUtilWrite fileUtilWrite = new FileUtilWrite("output.txt");
		fileUtilWrite.write(null);
	}

}

package test.com.medicalmining.participles;

import org.junit.Test;

import kevin.zhang.NLPIR;

public class TestNLPIR {

	@Test
	public void testNLPIRDemo() throws Exception {
		NLPIR nlpir = new NLPIR();
		if (!NLPIR.NLPIR_Init("./file/".getBytes("utf-8"), 1)) {
			System.out.println("NLPIR初始化失败...");
			return;
		}
		String temp = "每天的日报都记得要发送, 以配合经理掌握项目的进度情况.";
		byte[] resBytes = nlpir.NLPIR_ParagraphProcess(temp.getBytes("UTF-8"), 1);
		System.out.println("分词结果: " + new String(resBytes, "UTF-8"));

		String utf8File = "./test/test-utf8.TXT";
		String utf8FileResult = "./test/test-utf8_result.TXT";
		nlpir.NLPIR_FileProcess(utf8File.getBytes("utf-8"), utf8FileResult.getBytes("utf-8"), 1);
		// 退出, 释放资源
		NLPIR.NLPIR_Exit();
	}

	@Test
	public void testNLPIRAddWord() throws Exception {
		NLPIR nlpir = new NLPIR();
		if (!NLPIR.NLPIR_Init("./file/".getBytes("utf-8"), 1)) {
			System.out.println("NLPIR初始化失败...");
			return;
		}
		String temp = "常以发热为首发和主要症状，体温一般高于38℃，"
				+ "常呈持续性高热，可伴有畏寒、肌肉酸痛、关节酸痛、头痛、乏力。在早期，使用退热药可有效;进入进展期，通常难以用退热药控制高热。使用糖皮质激素可对热型造成干扰";
		byte[] resBytes = nlpir.NLPIR_ParagraphProcess(temp.getBytes("UTF-8"), 1);
		System.out.println("分词结果: " + new String(resBytes, "UTF-8"));
		nlpir.NLPIR_AddUserWord("糖皮质激素 n".getBytes("utf-8"));
		byte[] resBytesAddWords = nlpir.NLPIR_ParagraphProcess(temp.getBytes("UTF-8"), 1);
		System.out.println("分词结果: " + new String(resBytesAddWords, "UTF-8"));

	}

}

package test.com.medicalmining.participles;

import java.io.File;

import org.junit.Test;

import com.medicalmining.participles.Participle;

public class TestParticiples {

	@Test
	public void testParticiplesFromFolder() {
		Participle participles = new Participle("wordresult.txt");
		File root = new File("syptomCollection");
		for (File oneFile : root.listFiles()) {
			if (oneFile.isFile()) {
				participles.doParticiple(oneFile.getPath(),"syptomCollectionresult/"+oneFile.getName());
			}
		}
	}

	@Test
	public void testParticiplesFromOneFile() {
//		Participle participles = new Participle("expected.txt");
//		participles.doParticiple("syptomCollection/SARS.txt", "syptomCollectionresult/SARS.txt");
	}

	@Test
	public void testParticiplesInit() {
//		Participle participles = new Participle("expected.txt");
	}

}

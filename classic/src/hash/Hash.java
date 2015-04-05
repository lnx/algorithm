package hash;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Hash {

	static final int MASK = 0x7FFFFFFF;

	static File hashFile(String url, String dir, String prefix, int hashSize) {
		new File(dir).mkdir();
		String filename = String.format("%s%d", prefix, (url.hashCode() & MASK) % hashSize);
		File file = new File(dir + File.separator + filename);
		if (!file.isFile()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	static boolean append(File file, String content) {
		boolean ret = false;
		if (file.isFile() && content != null) {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(file, true));
				bw.append(content);
				ret = true;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bw != null) {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return ret;
	}

}

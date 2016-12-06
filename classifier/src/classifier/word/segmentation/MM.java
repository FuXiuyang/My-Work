package classifier.word.segmentation;

import java.util.HashMap;
import java.util.Vector;

public interface MM {
	static final int MAXLEN = 10;
	void setDic(HashMap<String, String> dic);
	Vector<String> segmentation(String phrase);
}

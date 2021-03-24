package jp.co.izumi;

import java.util.Random;

public class SentenceManager {

	public String JenerateParticle() {
		double punctuation_mark_rate = 0.4;
		String[] punctuation_marks = {"、", "。\n"};
		String[] particles = {
							"が", "の", "を", "に", "へ", "と", "から", "より", "で",
							"の", "に", "と", "や", "し", "やら", "か", "なり", "だの",
							"ばかり", "まで", "だけ", "ほど", "くらい", "など", "なり", "やら", "か", "のみ", "や",
							"は", "も", "こそ", "でも", "しか", "さえ"
							};

		Random random = new Random();
        int index = random.nextInt(100);
        if(index < punctuation_mark_rate*100) {
        	index = random.nextInt(punctuation_marks.length);
        	return punctuation_marks[index];
        }else {
        	index = random.nextInt(particles.length);
            return particles[index];
        }

	}

	public boolean isHiragana(String str) {
		if(str.matches("^[\\u3040-\\u309F]+$")) {
			return true;
		}
		return false;
	}

}

package jp.co.izumi;

import java.util.Scanner;

public class InfiniteMonkeyTheorem {

	public static void main(String[] args) {

		SQLConnecter connecter = new SQLConnecter();
		Scanner scanner = new Scanner(System.in);
		SentenceManager sentence_manager = new SentenceManager();

		String result = "";
		System.out.println("ひらがなで頭文字を入力するだけで文が書けます。");
		while(true) {
			String search_word = scanner.next();
			if(search_word.equals("おわり")) break;
			if(!sentence_manager.isHiragana(search_word)) {
				System.out.println("ひらがな1文字を入力してください。");
			} else {
				result += connecter.SearchByInitial(search_word.charAt(0))[1];
				result += sentence_manager.JenerateParticle();
				System.out.println(result);
			}
		}
		scanner.close();
	}

}

package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.izumi.SentenceManager;

public class SentenceManagerTest {

	@Test
	public void ひらがなを入れたら真が返る() throws Exception {
		SentenceManager s_manager = new SentenceManager();
		boolean expected = true;
		boolean actual = s_manager.isHiragana("あ");
		assertThat(actual, is(expected));
	}

	@Test
	public void カタカナを入れたら偽が返る() throws Exception {
		SentenceManager s_manager = new SentenceManager();
		boolean expected = false;
		boolean actual = s_manager.isHiragana("ア");
		assertThat(actual, is(expected));
	}

	@Test
	public void 英字を入れたら偽が返る() throws Exception {
		SentenceManager s_manager = new SentenceManager();
		boolean expected = false;
		boolean actual = s_manager.isHiragana("a");
		assertThat(actual, is(expected));
	}

	@Test
	public void 半角数字を入れたら偽が返る() throws Exception {
		SentenceManager s_manager = new SentenceManager();
		boolean expected = false;
		boolean actual = s_manager.isHiragana("1");
		assertThat(actual, is(expected));
	}


	@Test
	public void 全角数字を入れたら偽が返る() throws Exception {
		SentenceManager s_manager = new SentenceManager();
		boolean expected = false;
		boolean actual = s_manager.isHiragana("１");
		assertThat(actual, is(expected));
	}

}

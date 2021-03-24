package test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.izumi.SQLConnecter;

public class SQLConnecterTest {

	@Test
	public void あで検索してあから始まる単語を取得できる() throws Exception {
		SQLConnecter sql_connecter = new SQLConnecter();
		String expected = "あ";
		String actual = sql_connecter.SearchByInitial('あ')[0];
		assertThat(actual, is(startsWith(expected)));
	}

}

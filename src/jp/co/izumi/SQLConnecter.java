package jp.co.izumi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SQLConnecter {

	private Statement statement = null;

	public SQLConnecter() {
		// MySQLとの接続
		String database_name = "JP_Vocabulary";
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/"+database_name+"?useSSL=false",
					"root", "hoge");
			System.out.println(database_name+"に接続できました．");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(database_name+"に接続できませんでした．");
		}

		//ステートメントの作成
		try {
			this.statement =  conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Statementの作成に失敗しました．");
		}

	}

	//頭文字で検索->String[]{読み, 本体}
	public String[] SearchByInitial(char initial) {
        ResultSet rs = null;
        String sql = "select * from bunruidb where reading like '" + initial + "%';";
		try {
			rs = this.statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLクエリの実行に失敗しました．");
		}

		List<String[]> resultList = new ArrayList<String[]>();
        try {
			while(rs.next()){
				String[] line = {rs.getString("reading"), rs.getString("heading_body")};
				resultList.add(line);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("カーソル位置にデータがありません．");
		}

        int index = new Random().nextInt(resultList.size());
        String[] result = resultList.get(index);

        return result;

	}

}

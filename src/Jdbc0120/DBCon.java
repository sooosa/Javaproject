package Jdbc0120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	
	// DB에 접속하기위한 메소드 DBConnect()
   public static Connection DBConnect(){
	// DB에 접속정보 저장을위한 Connection
	   Connection con = null;
	   
	   String url = "jdbc:oracle:thin:@localhost:1521:XE";
	   
	   
	   
	   
	   String user= "EHSZM";
	   String password = "1234";
	   
	   try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc6 라이브러리를 현재 소스에 적용
			// 오라클 접속 문구

			con = DriverManager.getConnection(url, user, password);
			// con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE";);
			// con은 실제 DB와 Java를 연결해주는 역할

			System.out.println("DB접속 성공");

		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB접속 실패 : 드라이버 로딩 실패!");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB접속 실패 : 계정정보 확인!!");
		}
		// printStackTrace() : 에러 발생시 경로를 찾아준다.

		// DB접속이 정상적으로 되면 접속상태(con)를 리턴해준다.

		return con;

	}

}

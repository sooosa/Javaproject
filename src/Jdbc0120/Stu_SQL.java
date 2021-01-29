package Jdbc0120;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stu_SQL {
	// DB접속을 위한 변수con 선언
	Connection con = null;
	
	// 쿼리문 전송을 위한 변수 선언
	Statement stmt = null;
	PreparedStatement pstmt = null;
	// PreparedStatement : ?를 문자로 인식!
	
	// 조회(select) 결과를 저장하기 위한 변수선언
	ResultSet rs = null;
	
	
	// DB접속을 위한 메소드
	public void connect() {
		con  = DBCon.DBConnect();
		//DBCon클래스의 DBConncet() 메소드의 리턴값(con)을
		// con에 담겠다.
	}
	// DB접속 해제
	public void conClos() {
		try {
			con.close();// DB접속을 끊는거 
			System.out.println("DB접속 해제");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	//학생 등록위한 메소드 insert()
	// insert(STUDTO stu)  : 파라미터로 StuDTO의 내용을 가져온다.
	public void insert(StuDTO stu) {
		String sql ="INSERT INTO STUDTO VALUES(?,?)";// 값을넣어 주어야 한다.
		
		// stu(학생정보) 값과 con(DB연걸)값확인
		System.out.println("학생정보:"+ stu);
		System.out.println("DB연결:"+ con);
		
		//stmt = con.createStatement();
		
		try {// try성공할때
			pstmt= con.prepareStatement(sql);
			
			// 숫자는 물음표 순서대로, 물음표 안에 들어갈 문자 내용
			pstmt.setString(1,stu.getStuName()); // 첫번째?
			pstmt.setInt(2, stu.getStuAge());   // 두번쨰? 
			
			int count =  pstmt.executeUpdate(); // int count 랑 if 안써도 크게 상관없다
			if(count>0) {
				System.out.println("학생등록성공!");
			}else {
				System.out.println("학생등록실패ㅠ.ㅠ");
			}
			
			// try-catch-finally 세트!!
		} catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			// try : 정상적으로 작동할때
			// catch : 오류가 발생할때(예외초리가 발생할때)
			// Exception : 예외처리
			// finally : 정상적으로 작동하거나 예외처리 발생해도 
			//           상관없이 무조건 작동
		}
		try {
			pstmt .close();
		} catch (SQLException se) {
		  se.printStackTrace();
		}
	}
	//학생 정보조회하는 select 메소드()
	public void select() {
		String sql = "SELECT * FROM STUDTO";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // rs에담기
			int i =1;
			
			while(rs.next()) { //조회된 데이터 갯수만큼 반복문실행
								// cardinality(Tuple,Record,Row)
				System.out.println(i+"번째학생정보");
				System.out.println("이름:"+ rs.getNString(1));
				System.out.println("나이 :"+ rs.getInt(2));
				System.out.println();
				i++;//i++:값을1씩더해주는거
			}
		
			
		} catch (SQLException se) {
				se.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
	}
	// 학생정보 수정 메소드 update()
	// update(STUDTO stu) : 메소드안에 StuDTO정보를 가지고있음 
	public void update(StuDTO stu) {
		System.out.println("stu정보:"+stu);
		System.out.println("con :"+con);
		
		String sql ="UPDATE STUDTO SET STUAGE=?"+"WHERE STUNAME=?";
		
		try {
            pstmt= con.prepareStatement(sql);
			pstmt.setInt(1,stu.getStuAge());
			pstmt.setString(2, stu.getStuName());
			int count = pstmt.executeUpdate();
			
			if(count>0) {
				System.out.println("학생정보성공");
			}else {
				System.out.println("학생정보실패ㅠ.ㅠ");
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	    // 학생정보 삭제 메소드 delete()
		// delete(String sName) : 메소드안에 String타입의 sName정보를 가지고있다
	public void delete(String dName) {
		String sql = "DELETE STUDTO WHERE STUNAME=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, dName);
			
			int count = pstmt.executeUpdate();
			
			System.out.println("count 결과:"+ count);
			
			if(count>0) {
				System.out.println("학생정보 삭제성공");
			}else {
				System.out.println("학생정보 삭제실패ㅠ.ㅠ");
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}
	
	
}

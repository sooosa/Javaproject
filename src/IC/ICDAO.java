package IC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ICDAO {

	// DB접속을 위한 변수 선언
	Connection conn = null;

	// 쿼리문 전송을 위한 변수 선언
	PreparedStatement pstmt = null;

	// 조회결과를 저장하기 위한 변수
	ResultSet rs = null;

	// DB접속을 위한 메소드 connect()
	public void connect() {
		conn = DBC.DBConnect();
	}

	// DB접속 해제를 위한 메소드 conClose()
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 1.로그인
	public int Login(String cid, String cpw) {
		String sql = "SELECT * FROM IC WHERE ICID=? AND ICPW =?";
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return result;
	}

	// 2.회원가입
	public void memberJoin(ICDTO dto) {
		String sql = "INSERT INTO IC VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			// ? 안에 값 넣기
			pstmt.setString(1, dto.getcId());
			pstmt.setString(2, dto.getcPw());
			pstmt.setString(3, dto.getcName());
			pstmt.setString(4, dto.getcBirth());
			pstmt.setString(5, dto.getcGender());
			pstmt.setString(6, dto.getcEmail());
			pstmt.setString(7, dto.getcTell());
			pstmt.setString(8, dto.getcAddress());
			pstmt.setString(9, dto.getcAccountnumber());
			pstmt.setInt(10, dto.getcBalance());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 3.회원정보 조회
	public void memberList(ICDTO dto) {
		String sql = "SELECT * FROM IC WHERE ICID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getcId());

			rs = pstmt.executeQuery();

			int i = 1;
			while (rs.next()) {
				System.out.println(i + "번째 회원");
				System.out.println("아이디 : " + rs.getString(1));
				System.out.println("비밀번호 : " + rs.getString(2));
				System.out.println("이름 : " + rs.getString(3));
				System.out.println("생년월일 : " + rs.getString(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("이메일 : " + rs.getString(6));
				System.out.println("전화번호 : " + rs.getString(7));
				System.out.println("주소 : " + rs.getString(8));
				System.out.println();
				i++;

				int result = pstmt.executeUpdate();

				if (result > 0) {
					System.out.println("회원님정보 불러오기");
				} else {
					System.out.println("회원님정보 불러오기 실패");
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	// 4.회원정보 수정
	public void memberModify(ICDTO dto) {
		String sql = "UPDATE IC SET ICPW=?, ICNAME=?, ICBIRTH=?, " + "ICGENDER=?, ICEMAIL=?, ICTELL=?, ICADDRESS=? "
				+ "WHERE ICID=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getcPw());
			pstmt.setString(2, dto.getcName());
			pstmt.setString(3, dto.getcBirth());
			pstmt.setString(4, dto.getcGender());
			pstmt.setString(5, dto.getcEmail());
			pstmt.setString(6, dto.getcTell());
			pstmt.setString(7, dto.getcAddress());
			pstmt.setString(8, dto.getcId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원정보 수정성공!");
			} else {
				System.out.println("회원정보 수정실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 5-1.회원삭제
	public boolean idCheck(String dId, String dPw) {
		String sql = "SELECT ICID FROM IC " + "WHERE ICID=? AND ICPW=?";
		boolean checkResult = false;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dId);
			pstmt.setString(2, dPw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				checkResult = true;
			} else {
				checkResult = false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return checkResult;
	}

	// 5-2.회원삭제
	public void memberDelete(String dId) {
		String sql = "DELETE IC WHERE ICID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dId);
			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원정보 삭제성공!");
			} else {
				System.out.println("회원정보 삭제실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 6.계좌등록
	public void insertClient(ICDTO dto) {
		String sql = "UPDATE IC SET ICACCOUNTNUMBER=?, ICBALANCE=? WHERE ICID=? AND ICPW=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getcAccountnumber());
			pstmt.setInt(2, dto.getcBalance());
			pstmt.setString(3, dto.getcId());
			pstmt.setString(4, dto.getcPw());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("계좌등록성공!");
			} else {
				System.out.println("계좌등록실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 계좌조회
	public int checkBalance(String caccountnumber) {
		String sql = "SELECT ICBALANCE FROM IC WHERE ICACCOUNTNUMBER = ? ";
		int balance = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, caccountnumber);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				balance = rs.getInt(1);
				// balance = rs.getInt("BALANCE");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

		return balance;
	}

	// 계좌입금
	public void deposit(ICDTO dto) {
		String sql = "UPDATE IC SET ICBALANCE = ICBALANCE + ? WHERE ICACCOUNTNUMBER = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getcBalance());
			pstmt.setString(2, dto.getcAccountnumber());

			int result/* 필요없는 데이터 */ = pstmt.executeUpdate();// ← 실제 활용되는 데이터

			if (result > 0) {
				System.out.println("입금 성공");
			} else {
				System.out.println("입금 실패");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void withdraw(String caccountnumber, String icname) {
		String sql1 = "SELECT ICICPRICE FROM ICIC WHERE ICICNAME=?";
		String sql ="UPDATE IC SET ICBALANCE = ICBALANCE - ? WHERE ICACCOUNTNUMBER = ?";
		
		try {
			pstmt = conn.prepareStatement(sql1);
			
			pstmt.setString(1, icname);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int cbalance =rs.getInt(1);
				
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, cbalance);
				pstmt.setString(2, caccountnumber);
				
				int result/* 필요없는 데이터 */ = pstmt.executeUpdate();// ← 실제 활용되는 데이터

				if (result > 0) {
					System.out.println("결제 성공");
				} else {
					System.out.println("결제 실패");
				}
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		
		
		
	}
}
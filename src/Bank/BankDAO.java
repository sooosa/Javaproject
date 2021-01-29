
package Bank;

import java.sql.*;

import IC.DBC;


public class BankDAO {
	
	//DB접속를위한 변수선언
   Connection conn = null;
	
   // 쿼리문 전송을 위한 변수 선언
   PreparedStatement pstmt = null;
   
   // 조회(select) 결과를 저장하기 위한 변수 rs 선언
   ResultSet rs = null;
   
   //  DB접속 메소드 connect()
   public void connect() {
	   conn = DBC.DBConnect();
   }
	
   public void conClose() {
	   
   }
   
	// 고객번호를 생성하기 위한 매소드 clientNumber()
	public int clientNumber() {
	   String sql = "SELECT COUNT(*) FROM BANK";
	   int cNumber = 0;
	   
	   try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			cNumber = rs.getInt(1);
		}
	} catch (SQLException se) {
		se.printStackTrace();
	}
		return cNumber;
		
	}
		
	// 고객정보를 저장하기위한 메소드 insertClient
	public void insertClient(BankDTO client) {
		String sql = "INSERT INTO BANK VALUES(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 물음표안에 값을넣어주기 위해
			pstmt.setInt(1, client.getClientNumber());
			pstmt.setString(2, client.getcName());
			pstmt.setString(3, client.getAccountNumeber());
			pstmt.setInt(4, client.getBalance());
			
			int result = pstmt.executeUpdate();
			
			if(result>0){
				System.out.println("고객등록 성공^ㅁ^");
			}else {
				System.out.println("고객등록실패ㅜ.ㅜ");
			}
			
		} catch (SQLException se) {
		se.printStackTrace();
		}
	}
	// 입금 메소드 deposit()
	public void deposit(BankDTO client) {
		
		System.out.println("입력한 계좌번호와 입급액확인");
		System.out.println(client);
	
	String sql = "UPDATE BANK SET BALANCE = BALANCE + ? WHERE ACCOUNTNUMBER = ?";
    
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,client.getBalance());
		pstmt.setNString(2, client.getAccountNumeber());
		
		int result = pstmt.executeUpdate();// 실제로 DB하는pstmt.executeUpdate
		
		if(result>0) {
			System.out.println("입금성공^.^"); 
		}else {
			System.out.println("입금실패ㅜ.ㅜ");
		}
		
		
	} catch (SQLException se) {
		se.printStackTrace();
	 }
	}
	
     // 출금 메소드 withdraw
	public void withdraw(String accountNumber,int balance) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE -? WHERE ACCOUNTNUMBER = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, accountNumber);
			
			int result = pstmt.executeUpdate();
			
			if(result<0) {
				System.out.println("출금성공^>^");
			}else {
				System.out.println("출금실패ㅠ>ㅠ");
			}
			
			
		} catch (SQLException se) {
		se.printStackTrace();
		}
	}
	

	
	public int checkBalance(String accountNumber) {// 메소드 자체가 int(integer)값
		String sql = "SELECT BALANCE FROM BANK WHERE ACCOUNTNUMBER=?";
		int balance = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				balance = rs.getInt(1);
				System.out.println("accountNumber : " + accountNumber);
				System.out.println("rsget1 : " + rs.getInt(1));
				// balance = rs.getInt(balance);
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		return balance;
	}
	
	
   
	public boolean checkAccount(String accountNumber) {// 데이터 타입은 같게해줘야한다
		String sql = "SELECT ACCOUNTNUMBER FROM BANK WHERE ACCOUNTNUMBER=?";
		boolean cAccount = false;
		
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cAccount = true;
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		
		return cAccount;
	}

	// 송금 메소드 send()
	// 보내는 사람 계좌번호, 받는사람계좌번호, 송금액의 정보를 매개변수로 담아서 넘어옴
	public void send(String sAccountNumber, String rAccountNumber, int balance) {
		// 받는사람는  돈이 + : 입금
	    // 보내는 사람 돈이 - : 출금
		withdraw1(sAccountNumber,balance);
		deposit1(rAccountNumber, balance);
		System.out.println("출금성공");
		
		
	}	
		public void withdraw1(String accountNumber,int balance) {
			String sql = "UPDATE BANK SET BALANCE = BALANCE -? WHERE ACCOUNTNUMBER = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, balance);
				pstmt.setString(2, accountNumber);
				
				int result = pstmt.executeUpdate();
				
			} catch (SQLException se) {
			se.printStackTrace();
			}
		}
	
	
	public void deposit1(String accountNumber,int balance) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE +? WHERE ACCOUNTNUMBER = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, accountNumber);
			
			int result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
		se.printStackTrace();
		}
	}
	
	
	
}

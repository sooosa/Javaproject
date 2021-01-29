package Bank;

public class BankDTO {

	private int clientNumber;   //고객번호
	private String cName;       // 고객이름
	private String accountNumeber; // 계좌번호
	private int balance;       //잔액
	
	
	
	
	// getter,setter
	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getAccountNumeber() {
		return accountNumeber;
	}
	public void setAccountNumeber(String accountNumeber) {
		this.accountNumeber = accountNumeber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//toString
	@Override
	public String toString() {
		return "BankDTO [clientNumber=" + clientNumber + ", cName=" + cName + ", accountNumeber=" + accountNumeber
				+ ", balance=" + balance + "]";
	}
	
	//생성자
	public BankDTO() {
		super();
	}
	
	// 매개변수
	public BankDTO(int clientNumber, String cName, String accountNumeber, int balance) {
		super();
		this.clientNumber = clientNumber;
		this.cName = cName;
		this.accountNumeber = accountNumeber;
		this.balance = balance;
	}
	
	
	
}//end class

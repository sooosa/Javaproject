package IC;

public class ICDTO {

	// 회원가입 정보 필드
	private String cId; // 아이디
	private String cPw; // 비밀번호
	private String cName; // 이름
	private String cBirth; // 생년월일
	private String cGender; // 성별
	private String cEmail; // 이메일
	private String cTell; // 휴대전화
	private String cAddress;// 주소
	private String cAccountnumber;// 계좌번호
	private int cBalance;//잔액
	//상품정보
	private String icCode; // 상품번호
	private String icName; // 상품이름
	private int icPrice; // 상품가격
	private int icStock; // 상품재고
	private String icSize; // 상품사이즈
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcPw() {
		return cPw;
	}
	public void setcPw(String cPw) {
		this.cPw = cPw;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcBirth() {
		return cBirth;
	}
	public void setcBirth(String cBirth) {
		this.cBirth = cBirth;
	}
	public String getcGender() {
		return cGender;
	}
	public void setcGender(String cGender) {
		this.cGender = cGender;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcTell() {
		return cTell;
	}
	public void setcTell(String cTell) {
		this.cTell = cTell;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getcAccountnumber() {
		return cAccountnumber;
	}
	public void setcAccountnumber(String cAccountnumber) {
		this.cAccountnumber = cAccountnumber;
	}
	public int getcBalance() {
		return cBalance;
	}
	public void setcBalance(int cBalance) {
		this.cBalance = cBalance;
	}
	public String getIcCode() {
		return icCode;
	}
	public void setIcCode(String icCode) {
		this.icCode = icCode;
	}
	public String getIcName() {
		return icName;
	}
	public void setIcName(String icName) {
		this.icName = icName;
	}
	public int getIcPrice() {
		return icPrice;
	}
	public void setIcPrice(int icPrice) {
		this.icPrice = icPrice;
	}
	public int getIcStock() {
		return icStock;
	}
	public void setIcStock(int icStock) {
		this.icStock = icStock;
	}
	public String getIcSize() {
		return icSize;
	}
	public void setIcSize(String icSize) {
		this.icSize = icSize;
	}
	@Override
	public String toString() {
		return "ICDTO [cId=" + cId + ", cPw=" + cPw + ", cName=" + cName + ", cBirth=" + cBirth + ", cGender=" + cGender
				+ ", cEmail=" + cEmail + ", cTell=" + cTell + ", cAddress=" + cAddress + ", cAccountnumber="
				+ cAccountnumber + ", cBalance=" + cBalance + ", icCode=" + icCode + ", icName=" + icName + ", icPrice="
				+ icPrice + ", icStock=" + icStock + ", icSize=" + icSize + "]";
	}
	public ICDTO() {
		super();
		
	}
	public ICDTO(String cId, String cPw, String cName, String cBirth, String cGender, String cEmail, String cTell,
			String cAddress, String cAccountnumber, int cBalance, String icCode, String icName, int icPrice,
			int icStock, String icSize) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cName = cName;
		this.cBirth = cBirth;
		this.cGender = cGender;
		this.cEmail = cEmail;
		this.cTell = cTell;
		this.cAddress = cAddress;
		this.cAccountnumber = cAccountnumber;
		this.cBalance = cBalance;
		this.icCode = icCode;
		this.icName = icName;
		this.icPrice = icPrice;
		this.icStock = icStock;
		this.icSize = icSize;
	}
	
	
}		
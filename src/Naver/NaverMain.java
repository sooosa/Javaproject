package Naver;

import java.util.Scanner;

public class NaverMain {
// 프론트엔드 , 나중에 웹페이지로 대체
	public static void main(String[] args) {
		
	    // 서버를 개발하는 NaverDAO클래스
		NaverDAO server = new NaverDAO();
		
		// 회원가입 정보를 담고있는 NaverDTO
		NaverDTO naver = new NaverDTO();
		
		Scanner sc = new Scanner (System.in);
		
		// 프로그램 실행을 위한 변수 run
		boolean run = true;
		
		// 항목을 선택할때 필요한변수 menu
		int menu = 0;
		
		// while문을 이용하여 프로그램실행
		while(run) {
			System.out.println("================================");
			System.out.println("1.DB접속   2.DB접속해제");
			System.out.println("3.회원가입  4.회원조회");
			System.out.println("5.회원수정  6.회원삭제");
			System.out.println("7.프로그램종료");
			System.out.println("==================================");
			System.out.print("황목선택>>");
			menu = sc.nextInt();
			
			// 입력받은 항목을 실행하기위한 switch 문
			switch(menu) {
			case 1:
				server.connect();
				break;
			case 2:
				server.conClose();
				break;
			case 3:
				System.out.println("수정할회원아이디>>");
				
				System.out.println("아이디>>");
				String nid = sc.next();
				naver.setnId(nid);
				
				System.out.println("비밀번호>>");
				String npw = sc.next();
				
				System.out.println("비밀번호 확인>>");
				String npwc = sc.next();
				
				if(npw.equals(npwc)) {
					System.out.println("사용가능한비밀번호");
					
				}else {
					System.out.println("비밀번호가 틀렸습니다");
					break;
				}
				
				System.out.println("이름>>");
				String nname = sc.next();
				naver.setnName(nname);
				
				System.out.println("생년월일>>");
				
				System.out.println("연도>>");
				String nyer = sc.next();
				
				System.out.println("월>>");
				String nmon = sc.next();
				
				System.out.println("일>>");
				String nday = sc.next();
				
				System.out.println("생년월일확인:");
				System.out.println(nyer+nmon+nday);
				naver.setnBirth(nyer+nmon+nday);
				
				System.out.println("이메일>>");
				String nemaill= sc.next();
				naver.setnEmail(nemaill);
				
				System.out.println("성별>>");
				String ngen = sc.next();
				naver.setnGender(ngen);
				
				System.out.println("휴대번호>>");
				String nphone = sc.next();
				naver.setnPhone(nphone);
	
				break;
				
			case 4:
				// 아이디랑 비밀번호를 입력받아서
				// admin 아이디만 조회 하기
				server.memberList();
				break;
				
			case 5:
               System.out.println("회원정보를 입력해주세여");
				
				System.out.println("아이디>>");
				nid = sc.next();
				naver.setnId(nid);
				
				System.out.println("비밀번호>>");
				npw = sc.next();
				
				System.out.println("비밀번호 확인>>");
				npwc = sc.next();
				
				if(npw.equals(npwc)) {
					System.out.println("사용가능한비밀번호");
					
				}else {
					System.out.println("비밀번호가 틀렸습니다");
					break;
				}
				
				System.out.println("이름>>");
				nname = sc.next();
				naver.setnName(nname);
				
				System.out.println("생년월일>>");
				System.out.println("연도>>");
				 nyer = sc.next();
				
				System.out.println("월>>");
				 nmon = sc.next();
				
				System.out.println("일>>");
				 nday = sc.next();
				
				System.out.println("생년월일확인:");
				System.out.println(nyer+nmon+nday);
				naver.setnBirth(nyer+nmon+nday);
				
				System.out.println("이메일>>");
				 nemaill= sc.next();
				naver.setnEmail(nemaill);
				
				System.out.println("성별>>");
			    ngen = sc.next();
				naver.setnGender(ngen);
				
				System.out.println("휴대번호>>");
				nphone = sc.next();
				naver.setnPhone(nphone);
		
				server.memberModify(naver);
				
				break;
				
			case 6:
				System.out.println("삭제할 회원 아이디조회");
				
				System.out.println("삭제할 아이디>>");
				String did = sc.next();
				
				System.out.print("비밀번호");
				String dpw = sc.next();
				
				boolean check = server.idCheck(did,dpw);
				// boolean 타입의변수 check선언
				// server(NaverDAO)에서 did와dpw의 정보를 담은
				// boolean 타입의 메소드 id check생성
				
				if(check) {
					server.memberDelete(did);
				}else {
					System.out.println("아이디와 비빌번호가 일치하지 않습니다.");
				}
				
				break;
			case 7:
				run = false;
				// run이 trued이기 때문에 반복문이실행
				// run이 false로 바꾸면 반목문이 종료된다.
				break;
				default:
					System.out.println("다시 입력하세요ㅠ.ㅠ");
					break;
			
			
			}//end switch
			
		}//end while
		
	}//end main
}//end class
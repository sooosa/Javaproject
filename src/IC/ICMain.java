package IC;

import java.util.Scanner;

import javax.swing.Icon;

import Bank.BankDTO;

public class ICMain {

	public static void main(String[] args) {
		
	
		// 회원가입 정보를 담고 있는 NaverDTO클래스
				ICDTO dto = new ICDTO();

				// 서버를 개발하는 NaverDAO클래스
				ICDAO dao = new ICDAO();

				Scanner sc = new Scanner(System.in);

				// 프로그램 실행을 위한 변수 run
				boolean run = true;

				// 항목을 선택할 때 필요한 변수 menu
				int menu = 0;
				// while문을 이용하여 프로그램 실행
				System.out.println("('/ _____  _____  ___  ___        _  _ /');\r\n" + 
				           "('/|_   _|/  __ \\ |  \\/  |       | || |/');\r\n" + 
				           "('/  | |  | /  \\/ | .  . |  __ _ | || |/');\r\n" + 
				           "('/  | |  | |     | |\\/| | / _` || || |/');\r\n" + 
				           " ('/ | |_ | \\__/\\ | |  | || (_| || || |/');\r\n" + 
				          " ('/\\___/  \\____/ \\_|  |_/ \\__,_||_||_|/');\r\n" + 
			                 	"                                    ");
                     
				while (run) {
					
					
                                    
					System.out.println("어서오세요.");
					System.out.println("IC에 오신걸 환영합니다.");
					System.out.println("회원가입 후 로그인해서 사용해주세요.");
					
					System.out.println("==========================================");
					System.out.println("1.로그인 		2.회원가입		3.회원조회 ");
					System.out.println("4.회원수정		5.회원삭제		6.계좌등록");
					System.out.println("7.계좌조회		8.계좌입금		9.메뉴");
					System.out.println("10.기업정보	11.회사정보	12.매장찾기");
					System.out.println("13.고객서비스	14.이벤트		15.로그아웃");
					System.out.println("==========================================");
					System.out.println();
					System.out.print("항목 선택 >> ");			
					menu = sc.nextInt();
					

					switch (menu) {
					case 1:
						dao.connect();
						System.out.println("회원님 정보를 입력해주세요!");
						
						System.out.print("아이디 >> ");
						String cid = sc.next();				
						
						System.out.print("비밀번호 >> ");
						String cpw = sc.next();
						
						int login = dao.Login(cid,cpw);
						
						if(login>0) {
							System.out.println("로그인");
						} else {
							System.out.println("ID와  PW를 확인해주세요!");
						}
						
						
						break;
															
					case 2:		
						dao.connect();
						System.out.println("회원님 정보를 입력해주세요!");

						System.out.print("아이디 >> ");
						cid = sc.next();
						dto.setcId(cid);

						System.out.print("비밀번호 >> ");
						cpw = sc.next();

						System.out.print("비밀번호 확인 >> ");
						String icpwc = sc.next();

						if (cpw.equals(icpwc)) {
							System.out.println("사용가능한 비밀번호");
							dto.setcPw(cpw);
						} else {
							System.out.println("비밀번호가 틀렸습니다.");
							break;
						}
						System.out.print("이름 >> ");
						String cname = sc.next();
						dto.setcName(cname);

						System.out.println("생년월일");
						System.out.print("연도 >> ");
						String cyear = sc.next();

						System.out.print("월 >> ");
						String cmon = sc.next();

						System.out.print("일 >> ");
						String cday = sc.next();

						System.out.print("생년월일 확인 : ");
						System.out.println(cyear + cmon + cday);
						dto.setcBirth(cyear + cmon + cday);

						System.out.print("성별 >> ");
						String cgen = sc.next();
						dto.setcGender(cgen);

						System.out.print("이메일 >> ");
						String cemail = sc.next();
						dto.setcEmail(cemail);

						System.out.print("전화번호 >> ");
						String ctell = sc.next();
						dto.setcTell(ctell);

						System.out.print("주소 >> ");
						String caddress = sc.next();
						dto.setcAddress(caddress);

						dao.memberJoin(dto);
							
						dao.conClose();
						break;

					case 3:
						System.out.print("조회할 회원 아이디 >> ");
						cid = sc.next();
						dto.setcId(cid);
						
						dao.memberList(dto);
						
						break;

					case 4:
						System.out.println("회원님 정보를 입력해주세요!");
						
						System.out.print("수정할 회원 아이디 >> ");
						cid = sc.next();
						dto.setcId(cid);

						System.out.print("비밀번호 >> ");
						cpw = sc.next();

						System.out.print("비밀번호 확인 >> ");
						icpwc = sc.next();

						if (cpw.equals(icpwc)) {
							System.out.println("사용가능한 비밀번호");
							dto.setcPw(cpw);
						} else {
							System.out.println("비밀번호가 틀렸습니다.");
							break;
						}
						System.out.print("이름 >> ");
						cname = sc.next();
						dto.setcName(cname);

						System.out.println("생년월일");
						System.out.print("연도 >> ");
						cyear = sc.next();

						System.out.print("월 >> ");
						cmon = sc.next();

						System.out.print("일 >> ");
						cday = sc.next();

						System.out.print("생년월일 확인 : ");
						System.out.println(cyear + cmon + cday);
						dto.setcBirth(cyear + cmon + cday);

						System.out.print("성별 >> ");
						cgen = sc.next();
						dto.setcGender(cgen);

						System.out.print("이메일 >> ");
						cemail = sc.next();
						dto.setcEmail(cemail);

						System.out.print("전화번호 >> ");
						ctell = sc.next();
						dto.setcTell(ctell);

						System.out.print("주소 >> ");
						caddress = sc.next();
						dto.setcAddress(caddress);
						
						dao.memberModify(dto);				
						break;

					case 5:
						System.out.println("삭제할 회원 아이디 조회!");

						System.out.print("삭제할 아이디 >> ");
						String dId = sc.next();

						System.out.print("비밀번호 >> ");
						String dPw = sc.next();

						boolean check = dao.idCheck(dId, dPw);

						if (check) {
							dao.memberDelete(dId);
						} else {
							System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
						}

						break;

					case 6:				
						System.out.println("회원님 계좌를 입력해주세요!");
						
						System.out.print("계좌번호 등록할 아이디 >> ");
						cid = sc.next();
						
						System.out.print("비밀번호 >> ");
						cpw = sc.next();
						
						System.out.print("계좌번호 >> ");
						String caccountnumber = sc.next();
						dto.setcAccountnumber(caccountnumber);
						
						System.out.print("입금>> ");
						int cbalance = sc.nextInt();
						dto.setcBalance(cbalance);
						
						dao.insertClient(dto);
						
						break;
						
					case 7:				
						System.out.println("계좌번호 >>");
						caccountnumber = sc.next();
						
						cbalance = dao.checkBalance(caccountnumber);
						
						System.out.println("잔액조회 : " + cbalance);	
						break;
						
					case 8:				
						System.out.println("계좌번호 >>");
						caccountnumber = sc.next();
						
						System.out.println("입금액 >>");
						cbalance = sc.nextInt();
						
						
						dto.setcAccountnumber(caccountnumber);
						dto.setcBalance(cbalance);
						
						dao.deposit(dto);
						
						break;
						
					case 9:	
						boolean crun = true;
						int cmenu = 0;
						
						while(crun) {
							System.out.println("메뉴를 선택하세요.");
							System.out.println("==========================");
							System.out.println("1.남자	2.여자	3.아동");
							System.out.println("==========================");
							System.out.println();
							System.out.print("항목 선택 >> ");
							cmenu = sc.nextInt();
							switch(cmenu) {
							case 1:
								boolean crun1 = true;
								int cmenu1 = 0;
								
								while(crun1) {
									System.out.println("상품을 선택해주세요");
									System.out.println("=========================");
									System.out.println("1.후디 & 맨투맨 2.티셔츠 & 셔츠 ");
									System.out.println("3.아우터 4.팬츠& 데님");
									System.out.println("=========================");
									System.out.println();
									System.out.print("항목 선택 >> ");
									cmenu1 = sc.nextInt();
									switch(cmenu1) {
									case 1:
										System.out.println("상품을 선택해주세요");
										System.out.println("1.후디:" +28000);	
										System.out.println("2.프린팅후디:" +33000);
										System.out.println("3.짚업후디:" +38000);
										System.out.println("4.프린팅짚업후디:" +43000);
										System.out.println("5.맨투맨:" +25000);
										System.out.println("6.프린팅맨투맨:" +30000);
										
										System.out.print("상품 이름 >> ");
										String icname = sc.next();	
										
										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();
										
										dao.withdraw(caccountnumber ,icname);
										
										break;
									case 2:
										System.out.println("1.티셔츠:" +15000);
										System.out.println("2.프린팅 티셔츠:" +20000);
										System.out.println("3.긴팔 티셔츠:" +18000);
										System.out.println("4.프린팅 긴팔 티셔츠:" +23000);
										System.out.println("5.셔츠:" +18000);
										System.out.println("6.체크셔츠:" +20000);
										System.out.println();
										System.out.print("항목 선택 >> ");
										
										System.out.print("상품 이름 >> ");
									     icname = sc.next();	
										
										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();
										
										dao.withdraw(caccountnumber ,icname);
										
										break;
									case 3:
										System.out.println("1.패딩:" +120000);
										System.out.println("2.롱패딩:" +180000);
										System.out.println("3.조끼패딩:" +70000);
										System.out.println();
										System.out.print("항목 선택 >> ");
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);

										break;
									case 4:
										System.out.println("1.슬림팬츠:" +28000);
										System.out.println("2.조거팬츠:" +30000);
										System.out.println("3.배기팬츠:" +28000);
										System.out.println("4.래큘러팬츠:" +29000);
										System.out.println("5.슬림진:" +30000);
										System.out.println("6.진:" +30000);
										System.out.println("7.래큘러진:" +32000);
										System.out.println();
										System.out.print("항목 선택 >> ");
										
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);

										
										
										break;
									case 5:
										crun1 = false;
										System.out.println("뒤로가기!.!");
										break;
									default:
										System.out.println("다시 입력하세요!");
										break;
									}
								}
							case 2:
								boolean crun2 = true;
								int cmenu2 = 0;
								
								while(crun2) {
									System.out.println("상품을 선택해주세요");
									System.out.println("===========================");
									System.out.println("1.후디 & 맨투맨 2.티셔츠 & 셔츠 ");
									System.out.println("3.탑 &블라우스  4.아우터");
									System.out.println("3.팬츠& 데님 6.스커드");
									System.out.println("===========================");
									System.out.println();
									System.out.print("항목 선택 >> ");
									cmenu2 = sc.nextInt();
									
									switch(cmenu2) {							
									case 1:
										System.out.println("1.후디:28000");
										System.out.println("2.프린팅후디:33000");
										System.out.println("3.짚업후디:38000");
										System.out.println("4.프린팅짚업후디:43000");
										System.out.println("5.맨투맨:25000");
										System.out.println("6.프린팅맨투맨:" +30000);
										System.out.println();
										System.out.print("상품 이름을 선택 >> ");	
										String icname =sc.next();
										
										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);
																		
										break;
									case 2:
										System.out.println("1.티셔츠:" +15000);
										System.out.println("2.프린팅 티셔츠:" +20000);
										System.out.println("3.긴팔 티셔츠:" +18000);
										System.out.println("4.프린팅 긴팔 티셔츠:" +23000);
										System.out.println("5.셔츠:" +18000);
										System.out.println("6.체크셔츠:" +20000);
									
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);
										
										break;
									case 3:
										System.out.println("1.탑:" +15000);
										System.out.println("2.스포츠 탑:" +20000);
										System.out.println("3.프린팅 탑:" +20000);
										System.out.println("4.블라우스:" +18000);
										
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);
										
										break;
									case 4:
										System.out.println("1.패딩:" +120000);
										System.out.println("2.롱패딩:" +180000);
										System.out.println("3.조끼패딩:" +70000);	
										
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);
										
										break;
									case 5:
										System.out.println("1.슬림팬츠:" +28000);
										System.out.println("2.조거팬츠:" +30000);
										System.out.println("3.배기팬츠:" +28000);
										System.out.println("4.래큘러팬츠:"+29000);
										System.out.println("5.슬림진:" +30000);
										System.out.println("6.진:" +30000);
										System.out.println("7.래큘러진:" + 32000);
										
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);
										
										
										break;
									case 6:
										System.out.println("1.숏스커드: " + 23000);
										System.out.println("2.스커트: " + 25000);
										System.out.println("3.롱스커트:" + 28000);	
										
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);
										
										break;
									case 7:
										crun2 = false;
										System.out.println("뒤로가기!.!");
										break;
									default:
										System.out.println("다시 입력하세요!");
										break;
									}
								}					
							case 3:
								boolean crun3 = true;
								int cmenu3 = 0;
								
								while(crun3) {
									System.out.println("상품을 선택해주세요");
									System.out.println("===================");
									System.out.println("1.베이비(0-4세)");
									System.out.println("2.리틀키즈(4-7세)");
									System.out.println("3.주니어(8-13세)");
									System.out.println("===================");
									System.out.println();
									System.out.print("항목 선택 >> ");
									cmenu3 = sc.nextInt();
									switch(cmenu3) {
									case 1:
										System.out.println("1.신생아복 세트: " + 10000);
										System.out.println("2.파자마슈트 : " + 15000);
										

										System.out.print("상품 이름 >> ");
										String icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);
										
										break;
									case 2:
										System.out.println("1.유아복 세트 : " + 15000);
										System.out.println("2.유아파자마슈트 : " + 20000);
										
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);

										
										break;
									case 3:
										System.out.println("1.아동복 세트: " + 20000);
										System.out.println("2.아동파자마슈트 : " + 25000);
										
										System.out.print("상품 이름 >> ");
										icname = sc.next();

										System.out.println("계좌번호 >>");
										caccountnumber = sc.next();

										dao.withdraw(caccountnumber, icname);
										
										
										break;
									case 4:
										crun3 = false;
										System.out.println("뒤로가기!.!");
										break;
									default:
										System.out.println("다시 입력하세요!");
										break;
									}
								}
							case 4:
								crun1 = false;
								System.out.println("뒤로가기!.!");
								break;
							default:
								System.out.println("다시 입력하세요!");
								break;
							}
						}
						
						break;
						
					case 10:		
						System.out.println("기업정보");
						System.out.println();
						System.out.println("이 사이트의 콘텐츠는 저작권 보호를 받고 있는 IC의 자산입니다.");
						System.out.println("IC의 경영 이념은 패션과 품질을 지속 가능한 방법으로 가장 합리적인 가격에 제공하는 것입니다.");
						System.out.println(" IC은 최초 설립된 1947년 이후부터 세계 패션 업계를 선도하는 탁월한 기업의 하나로 성장하였습니다.");
						
						break;
						
					case 11:
						System.out.println("회사정보");
						System.out.println();
						System.out.println("법인명 아이씨 주식회사 | 통신판매업신고번호: 제 2019 인천 미추홀 1004 호");
						System.out.println("사업자등록번호: 032-00-00700 | 대표자 김두환 ");
						System.out.println("인천광역시 미추홀구 학익 682, 학익타워 4 층 03161 ");
						System.out.println("대표번호 080-828-2828 | icia.kr@ic.com");
						break;
						
					case 12:			
						System.out.println("매장찾기");
						System.out.println();
						System.out.println("인천광역시 미추홀구 매소홀로488번길 6-32 태승빌딩 1층");
						System.out.println("롯데백화점 서울 영등포구 경인로 846 4층");
						
						break;
						
					case 13:				
						System.out.println("고객서비스");
						System.out.println();
						System.out.println("저희 IC을 이용해주셔서 감사합니다.");
						System.out.println();
						System.out.println("문의");
						System.out.println("언제든지 연락 주십시오.");
						System.out.println();
						System.out.println("고객센터 운영시간:");
						System.out.println("월요일-일요일: 9am – 9pm ");
						System.out.println("(연중무휴)");
						System.out.println();
						System.out.println("전화 연락:");
						System.out.println("080-828-2828 (무료 전화)");
						System.out.println();
						System.out.println("메일 보내기:");
						System.out.println("iciaic.kr@ic.com ");
						System.out.println();
						System.out.println("언제든지 메일 보내 주시면 24시간 이내에 답변 드리겠습니다.");
						System.out.println("메일을 보내주실 때에는 IC에 *등록된 이메일 주소, 이름, 전화번호*를 입력해  주세요.");
						System.out.println("(등록된 이메일 계정이 없으실 경우, 회신 받으실 개인 이메일 주소를 입력해 주세요.)");
						System.out.println("주문 관련 문의 시, 주문 번호를 기재해 주시면 좀 더 정확한 안내 도와 드릴 수 있습니다.");
						System.out.println();
						System.out.println("*SSG.COM에서 구매하신 IC상품 및 서비스 관련 문의는 SSG고객 센터로 문의 주시기 바랍니다.");
						System.out.println();
						System.out.println("고객 서비스에 연락하실 경우, 고객님의 개인정보는 당사의 개인정보 보호정책에 따라 취급됩니다.");
						break;
						
					case 14:				
						System.out.println("이벤트");
						System.out.println("준비중 입니다.");
						break;
						
				
					case 15:
						run = false;
						System.out.println("프로그램을 종료합니다!");
						dao.conClose();
						break;
					default:
						System.out.println("다시 입력하세요!");
						break;

					} // end switch

				} // end while
				
		
		
	}
}
	
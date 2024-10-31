import  org.junit.jupiter.api.*;

public class JUnitCycleTest {


    @BeforeAll
    static void beforeAll(){
        //전체 테스트를 시작하기전에 1회 실행
        // static  키워드 사용이유
        // 객체를 생성하지 않고도 호출될 수있음
        //:클래스가 로드될때 한번만 실행
        System.out.println("@BeforeAll");
    }
    //테스트 케이스를 시작하기전에 실행
    @BeforeEach
    public  void beforeEach(){
        System.out.println("@BeforeEach");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test(){
        System.out.println("test2");
    }
    @Test
    public void test3(){
        System.out.println("test3");
    }
    //전체 테스트를 마치고 종료하기전 1회 실행하기 떄문에
    @AfterAll
   static void afterAll(){
        System.out.println("@AfterAll");
    }

    @AfterEach
    // 테스트 케이스를 종료하기 전마닫 실행
    public void afterEach(){
        System.out.println("@AfterEach");
    }
}
// @Before -> 클래스 레벨 설정
//@BeforeEach > @Test>  @AfterEach가 테스트 개수만큼 반복
//@AfterALl 클래스 레벨 정리

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @DisplayName("1+2는 3이다")
    //@DisplayName 테스트이름을 명시

    @Test
    //Test 해당 에너테이션 붙인 메서드는 테스트를 수행하는 메서드
    public  void junitTest(){
        int a =1;
        int b =3;
        int sum =3;

        //assertEquals - JUnit에서 제공하는 검증 메서드
        //첫번째 인자값이 - 기대하는 갑사
        //두 번째 인자  - "실제로" 검증할 값
        Assertions.assertEquals(sum,a+b);
    }

}

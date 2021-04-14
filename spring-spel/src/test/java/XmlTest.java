import cn.su.spel.domain.Inventor;
import cn.su.spel.domain.MyMessage;
import cn.su.spel.domain.NumberGuess;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author SuZuQi
 * @title: XmlTest
 * @projectName testSpel
 * @description: TODO
 * @date 2021/3/29
 */
public class XmlTest {

    private ApplicationContext context ;

    {
        context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml") ;
    }
    @Test
    public void test1(){
        System.out.println(context.getBean(Inventor.class));
    }

    @Test
    public void test2(){
        System.out.println(context.getBean(NumberGuess.class));
    }

    @Test
    public void test3(){
        System.out.println(context.getBean(MyMessage.class));
    }

}

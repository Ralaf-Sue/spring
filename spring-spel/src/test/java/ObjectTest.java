import cn.su.spel.domain.Inventor;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.GregorianCalendar;

/**
 * 1、获取解析器
 * 2、根据解析器，设定表达式
 * 3、根据表达式，传入对象，获取结果
 */
public class ObjectTest {


    @Test
    public void test1(){
        GregorianCalendar c = new GregorianCalendar();
        c.set(1994,7,16);
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        ExpressionParser parser = new SpelExpressionParser() ;
        Expression exp = parser.parseExpression("name") ;
        System.out.println(exp.getValue(tesla));
        Expression exp1 = parser.parseExpression("name == 'Nikola Tesla'") ;
        Boolean value = exp1.getValue(tesla,Boolean.class);
        System.out.println(value);
    }

    @Test
    public void test2(){
        GregorianCalendar c = new GregorianCalendar();
        c.set(1994,7,16);
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        ExpressionParser parser = new SpelExpressionParser() ;
        Expression exp = parser.parseExpression("birth.getTime") ;
        System.out.println(exp.getValue(tesla));
    }


}

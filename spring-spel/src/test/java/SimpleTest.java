import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;

/**
 * @author SuZuQi
 * @title: SimpleTest
 * @projectName testSpel
 * @description: TODO
 * @date 2021/3/25
 */
public class SimpleTest {


    @Test
    public void test1(){
        ExpressionParser parser = new SpelExpressionParser() ;
        Expression exp = parser.parseExpression("'hello world'");
        String value = exp.getValue(String.class);
        System.out.println(value);

    }

    @Test
    public void test2(){
        ExpressionParser parser = new SpelExpressionParser() ;
        Expression exp = parser.parseExpression("'hello world'.concat('!')");
        String value = exp.getValue(String.class);
        System.out.println(value);
    }

    @Test
    public void test3(){
        ExpressionParser parser = new SpelExpressionParser() ;
        Expression exp = parser.parseExpression("'hello world'+'!'");
        String value = exp.getValue(String.class);
        System.out.println(value);
    }

    @Test
    public void test4(){
        ExpressionParser parser = new SpelExpressionParser() ;
        Expression exp = parser.parseExpression("'hello world'.bytes");
        byte[] value = (byte[])exp.getValue();
        System.out.println(Arrays.toString(value));
    }

    @Test
    public void test5(){
        ExpressionParser parser = new SpelExpressionParser() ;
        Expression exp = parser.parseExpression("'hello world'.bytes.length");
       Integer value =exp.getValue(Integer.class);
        System.out.println(value);
    }

    @Test
    public void test6(){
        ExpressionParser parser = new SpelExpressionParser() ;
        Expression exp = parser.parseExpression("new String('aaa').toUpperCase");
        String value =exp.getValue(String.class);
        System.out.println(value);
    }



}

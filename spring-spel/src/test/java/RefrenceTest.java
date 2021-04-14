import cn.su.spel.domain.MyMessage;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.DataBindingMethodResolver;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author SuZuQi
 * @title: RefrenceTest
 * @projectName testSpel
 * @description: TODO
 * @date 2021/3/29
 */
public class RefrenceTest {

    ExpressionParser parser = null;
    EvaluationContext context;

    {
        parser = new SpelExpressionParser();
        context = new SimpleEvaluationContext.Builder().withMethodResolvers(DataBindingMethodResolver.forInstanceMethodInvocation()).build();
//        context = SimpleEvaluationContext.forPropertyAccessors(new BeanExpressionContextAccessor()).build();
//       context = SimpleEvaluationContext.forReadWriteDataBinding().build() ;
        context.setVariable("test11", new MyMessage());
        context.setVariable("aaa", "testaaa");
    }

    @Test
    public void test1() {
        List numbers = (List) parser.parseExpression("{1,2,3,4}").getValue(context);
        List join = (List) parser.parseExpression("{{1,2,5},{3,4}}").getValue(context);
        System.out.println(join);
        System.out.println(numbers);
    }

    @Test
    public void test2() {

        List join = (List) parser.parseExpression("{{1,2,5},{3,4}}").getValue(context);  //[[1, 2, 5], [3, 4]]
        System.out.println(join);
    }

    @Test
    public void test3() {
//        System.currentTimeMillis()
        Map map = (Map) parser.parseExpression("{'aaa':11,'bb':'ccc'}").getValue(context);
        System.out.println(map);

    }

    //实例化数组
    @Test
    public void test4() {
        int[] arr = (int[]) parser.parseExpression("new int[3]").getValue(context);
        System.out.println(arr.length);
        int[] arr1 = (int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
        System.out.println(Arrays.toString(arr1));
        int[][] arr2 = (int[][]) parser.parseExpression("new int[2][3]").getValue(context);
        System.out.println(arr2.length);
        System.out.println(arr2[0].length);
    }

    @Test
    public void test5() {
        String text = (String) parser.parseExpression("T(cn.su.spel.domain.MyMessage).tryAppend('world')").getValue();
        System.out.println(new MyMessage().add());
        String text1 = (String) parser.parseExpression("#test11.add()").getValue(context);
        System.out.println(text);
        System.out.println(text1);
    }

    @Test
    public void test6() {
        boolean trueValue = parser.parseExpression(
                "'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        System.out.println(trueValue);
        boolean falseValue = parser.parseExpression(
                "'xyz' instanceof T(Integer)").getValue(Boolean.class);
        System.out.println(falseValue);
    }

    @Test
    public void test7() {
        boolean trueValue = parser.parseExpression("1 ne  2").getValue(Boolean.class);
        System.out.println(trueValue);
    }


    @Test
    public void test8() {
        MyMessage value = parser.parseExpression("new cn.su.spel.domain.MyMessage()").getValue(MyMessage.class);
        System.out.println(value);
    }

    @Test
    public void testVariable() {
        Object value = parser.parseExpression("#test11.append('aaa')").getValue(context);
        System.out.println(value);
    }

    @Test
    public void test9() {
        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17));

        // create parser and set variable 'primes' as the array of integers
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("primes", primes);

       // all prime numbers > 10 from the list (using selection ?{...})
        // evaluates to [11, 13, 17]
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
                "#primes.?[#this>10]").getValue(context);
        System.out.println(primesGreaterThanTen);
        Object ll =  parser.parseExpression(
                "#root").getValue(context);
        System.out.println(ll.getClass().getTypeName());
    }


}

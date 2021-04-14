import cn.su.spel.domain.MyMessage;
import cn.su.spel.domain.Simple;
import javafx.beans.property.SimpleListProperty;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.List;

/**
 * @author SuZuQi
 * @title: EvaluationContextTest
 * @projectName testSpel
 * @description: TODO
 * @date 2021/3/25
 */
public class EvaluationContextTest {

    /**
     * 使用解析器，给嵌套对象的属性赋值
     */
    @Test
    public void test1(){
        Simple simple = new Simple() ;
        simple.getList().add(true);
        EvaluationContext evaluationContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        ExpressionParser parser = new SpelExpressionParser() ;
        parser.parseExpression("list[0]").setValue(evaluationContext,simple,false);
        System.out.println(simple.getList());
    }

    @Test
    public void test2(){
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
                this.getClass().getClassLoader());
        ExpressionParser parser = new SpelExpressionParser(config) ;
        MyMessage message = new MyMessage();
        Expression exp = parser.parseExpression("payload");
        System.out.println(exp.getValue(message));
    }



}

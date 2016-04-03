package de.timoh.logicinterpreter.objects;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class AndExpressionTest {

    @Test
    public void reduceBothSidesFalse() {
        Expression leftSide = BooleanConstants.FALSE;
        Expression rightSide = BooleanConstants.FALSE;
        Expression reducedExpression = new AndExpression(leftSide, rightSide).reduce();

        Assert.assertEquals(BooleanConstants.FALSE, reducedExpression);
    }

    @Test
    public void reduceEitherSideFalse() {
        Expression leftSide = BooleanConstants.FALSE;
        Expression rightSide = BooleanConstants.TRUE;
        Expression reducedExpression = new AndExpression(leftSide, rightSide).reduce();

        Assert.assertEquals(BooleanConstants.FALSE, reducedExpression);

        leftSide = BooleanConstants.TRUE;
        rightSide = BooleanConstants.FALSE;
        reducedExpression = new AndExpression(leftSide, rightSide).reduce();

        Assert.assertEquals(BooleanConstants.FALSE, reducedExpression);
    }

    @Test
    public void reduceBothSidesTrue() {
        Expression leftSide = BooleanConstants.TRUE;
        Expression rightSide = BooleanConstants.TRUE;
        Expression reducedExpression = new AndExpression(leftSide, rightSide).reduce();

        Assert.assertEquals(BooleanConstants.TRUE, reducedExpression);
    }

    @Test
    public void invertTest() throws Exception {
        Expression leftSide = new IdentifierExpression("left");
        Expression rightSide = new IdentifierExpression("right");
        Expression invertedExpression = new AndExpression(leftSide, rightSide).invert();

        Assert.assertEquals(new OrExpression(leftSide.invert(), rightSide.invert()), invertedExpression);
    }
}

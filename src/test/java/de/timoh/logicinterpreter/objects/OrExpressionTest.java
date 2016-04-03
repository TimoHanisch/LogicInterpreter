package de.timoh.logicinterpreter.objects;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class OrExpressionTest {

    @Test
    public void reduceBothSidesFalse() {
        Expression leftSide = BooleanConstants.FALSE;
        Expression rightSide = BooleanConstants.FALSE;
        Expression reducedExpression = new OrExpression(leftSide, rightSide).reduce();

        Assert.assertEquals(BooleanConstants.FALSE, reducedExpression);
    }

    @Test
    public void reduceEitherSideFalse() {
        Expression leftSide = BooleanConstants.FALSE;
        Expression rightSide = BooleanConstants.TRUE;
        Expression reducedExpression = new OrExpression(leftSide, rightSide).reduce();

        Assert.assertEquals(BooleanConstants.TRUE, reducedExpression);

        leftSide = BooleanConstants.TRUE;
        rightSide = BooleanConstants.FALSE;
        reducedExpression = new OrExpression(leftSide, rightSide).reduce();

        Assert.assertEquals(BooleanConstants.TRUE, reducedExpression);
    }

    @Test
    public void reduceBothSidesTrue() {
        Expression leftSide = BooleanConstants.TRUE;
        Expression rightSide = BooleanConstants.TRUE;
        Expression reducedExpression = new OrExpression(leftSide, rightSide).reduce();

        Assert.assertEquals(BooleanConstants.TRUE, reducedExpression);
    }

    @Test
    public void invertTest() throws Exception {
        Expression leftSide = new IdentifierExpression("left");
        Expression rightSide = new IdentifierExpression("right");
        Expression invertedExpression = new OrExpression(leftSide, rightSide).invert();

        Assert.assertEquals(new AndExpression(leftSide.invert(), rightSide.invert()), invertedExpression);
    }
}
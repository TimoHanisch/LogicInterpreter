package de.timoh.logicinterpreter;


import de.timoh.logicinterpreter.objects.AndExpression;
import de.timoh.logicinterpreter.objects.IdentifierExpression;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class LogicInterpreterTest {

    @Test
    public void simpleInputTest1() {
        String input = "a OR FALSE";
        String expected = "a";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "FALSE OR a";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest2() {
        String input = "a OR TRUE";
        String expected = "TRUE";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "TRUE OR a";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest3() {
        String input = "a AND FALSE";
        String expected = "FALSE";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "FALSE AND a";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest4() {
        String input = "a AND TRUE";
        String expected = "a";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "TRUE AND a";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest5() {
        String input = "a OR a";
        String expected = "a";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest7() {
        String input = "a AND a";
        String expected = "a";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest8() {
        String input = "a AND NOT a";
        String expected = "FALSE";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "NOT a AND a";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest9() {
        String input = "NOT NOT a";
        String expected = "a";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest10() {
        String input = "a OR a AND b";
        String expected = "a";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "a OR b AND a";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "a AND b OR a";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "b AND a OR a";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest11() {
        String input = "a OR NOT a AND b";
        String expected = "a OR b";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest12() {
        String input = "(a OR b) AND (a OR c)";
        String expected = "a OR b AND c";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void simpleInputTest13() {
        String input = "NOT (a AND b)";
        String expected = "(NOT a OR NOT b)";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);

        input = "NOT (a OR b)";
        expected = "(NOT a AND NOT b)";
        output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void difficultTest1() {
        String input = "NOT (A OR B) AND NOT (C OR D OR E) OR NOT (A OR B)";
        String expected = "(NOT A AND NOT B)";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void difficultTest2() {
        String input = "NOT(NOT(a OR b)OR NOT (NOT (a AND b)))";
        String expected = "((a OR b) AND (NOT a OR NOT b))";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.evaluateString(input);
        Assert.assertEquals(input, expected, output);
    }

    @Test
    public void difficultTest3() {
        String input = "A AND B OR A AND B AND C OR A AND B AND C AND D OR A AND B AND C AND D AND E OR A AND B AND C AND D AND E AND F";
        String expected = "A AND B";
        LogicInterpreter logicInterpreter = new LogicInterpreter();
        String output = logicInterpreter.substitute(input, new AndExpression(new IdentifierExpression("A"), new IdentifierExpression("B")), new IdentifierExpression("X"));
        Assert.assertEquals(input, expected, output);
    }
}
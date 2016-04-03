package de.timoh.logicinterpreter.parser;

import de.timoh.logicinterpreter.objects.*;
import de.timoh.logicinterpreter.parser.generated.LogicBaseListener;
import de.timoh.logicinterpreter.parser.generated.LogicParser;
import de.timoh.logicinterpreter.utils.ExpressionType;

import java.util.Stack;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class LogicEvaluator extends LogicBaseListener {

    private Stack<Expression> expressionStack = new Stack<>();

    private Stack<Boolean> encapsulationStack = new Stack<>();

    private Expression finalExpression;

    @Override
    public void enterLogic_stmt(LogicParser.Logic_stmtContext ctx) {
        ExpressionType expressionType = ExpressionType.evaluate(ctx);
        switch (expressionType) {
            case AND:
                encapsulationStack.push(Boolean.FALSE);
                break;
            case OR:
                encapsulationStack.push(Boolean.FALSE);
                break;
            case IDENTIFIER:
                encapsulationStack.push(Boolean.FALSE);
                break;
            case TRUE:
                encapsulationStack.push(Boolean.FALSE);
                break;
            case FALSE:
                encapsulationStack.push(Boolean.FALSE);
                break;
            case NOT:
                encapsulationStack.push(Boolean.FALSE);
                break;
            case ENAPSULATED:
                encapsulationStack.push(Boolean.TRUE);
                break;
            case ERROR:
                throw new RuntimeException("Something went wrong!");
        }
    }

    @Override
    public void exitLogic_stmt(LogicParser.Logic_stmtContext ctx) {
        ExpressionType expressionType = ExpressionType.evaluate(ctx);
        encapsulationStack.pop();
        switch (expressionType) {
            case AND:
                Expression andRightSide = expressionStack.pop();
                Expression andLeftSide = expressionStack.pop();
                Expression andExpression = encapsulationStack.isEmpty() || !encapsulationStack.peek() ? new AndExpression(andLeftSide, andRightSide) : new AndExpression(andLeftSide, andRightSide, true);
                expressionStack.push(andExpression);
                break;
            case OR:
                Expression orRightSide = expressionStack.pop();
                Expression orLeftSide = expressionStack.pop();
                Expression orExpression = encapsulationStack.isEmpty() || !encapsulationStack.peek() ? new OrExpression(orLeftSide, orRightSide) : new OrExpression(orLeftSide, orRightSide, true);
                expressionStack.push(orExpression);
                break;
            case IDENTIFIER:
                expressionStack.push(new IdentifierExpression(ctx.getText()));
                break;
            case TRUE:
                expressionStack.push(BooleanConstants.TRUE);
                break;
            case FALSE:
                expressionStack.push(BooleanConstants.FALSE);
                break;
            case NOT:
                expressionStack.push(new NotExpression(expressionStack.pop()));
                break;
            case ERROR:
                throw new RuntimeException("Something went wrong!");
        }
    }

    public void clean() {
        expressionStack.clear();
        encapsulationStack.clear();
        finalExpression = null;
    }

    public Expression getExpression() {
        if (expressionStack.isEmpty() && finalExpression == null) {
            throw new RuntimeException("No expression to evaluate");
        } else if (expressionStack.isEmpty()) {
            return finalExpression;
        }
        finalExpression = expressionStack.pop();
        return finalExpression;
    }
}

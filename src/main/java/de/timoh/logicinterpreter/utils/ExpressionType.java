package de.timoh.logicinterpreter.utils;

import de.timoh.logicinterpreter.parser.generated.LogicParser;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public enum ExpressionType {
    AND, OR, IDENTIFIER, TRUE, FALSE, NOT, ENAPSULATED, ERROR;

    public static ExpressionType evaluate(LogicParser.Logic_stmtContext expressionContext) {
        if (expressionContext.AND() != null) {
            return AND;
        } else if (expressionContext.OR() != null) {
            return OR;
        } else if (expressionContext.TRUE() != null) {
            return TRUE;
        } else if (expressionContext.FALSE() != null) {
            return FALSE;
        } else if (expressionContext.Identifier() != null) {
            return IDENTIFIER;
        } else if (expressionContext.LEFT_PARREN() != null || expressionContext.RIGHT_PARREN() != null) {
            return ENAPSULATED;
        } else if (expressionContext.NOT() != null) {
            return NOT;
        }
        return ERROR;
    }
}

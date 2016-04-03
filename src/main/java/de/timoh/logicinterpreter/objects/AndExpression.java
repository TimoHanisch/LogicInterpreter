package de.timoh.logicinterpreter.objects;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class AndExpression extends BinaryExpression {

    public AndExpression(Expression leftExpression, Expression rightExpression, boolean encapsulated) {
        super(leftExpression, rightExpression, encapsulated);
    }

    public AndExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public Expression reduce() {
        Expression leftReduced = getLeftExpression().reduce();
        Expression rightReduced = getRightExpression().reduce();
        if (leftReduced.equals(BooleanConstants.FALSE) || rightReduced.equals(BooleanConstants.FALSE)) {
            return BooleanConstants.FALSE;
        } else if (leftReduced.equals(BooleanConstants.TRUE) && rightReduced.equals(BooleanConstants.TRUE)) {
            return BooleanConstants.TRUE;
        } else if (leftReduced.equals(BooleanConstants.TRUE)) {
            return rightReduced;
        } else if (rightReduced.equals(BooleanConstants.TRUE)) {
            return leftReduced;
        } else if (leftReduced.equals(rightReduced)) {
            return leftReduced;
        } else if (leftReduced.equals(new NotExpression(rightReduced))) {
            return BooleanConstants.FALSE;
        } else if (rightReduced.equals(new NotExpression(leftReduced))) {
            return BooleanConstants.FALSE;
        } else if (leftReduced instanceof OrExpression && rightReduced instanceof OrExpression) {
            OrExpression leftOr = (OrExpression) leftReduced;
            OrExpression rightOr = (OrExpression) rightReduced;
            if (leftOr.getLeftExpression().equals(rightOr.getLeftExpression())) {
                return new OrExpression(leftOr.getLeftExpression(), new AndExpression(leftOr.getRightExpression(), rightOr.getRightExpression()));
            } else if (leftOr.getLeftExpression().equals(rightOr.getRightExpression())) {
                return new OrExpression(leftOr.getLeftExpression(), new AndExpression(leftOr.getRightExpression(), rightOr.getLeftExpression()));
            } else if (leftOr.getRightExpression().equals(rightOr.getLeftExpression())) {
                return new OrExpression(leftOr.getRightExpression(), new AndExpression(leftOr.getLeftExpression(), rightOr.getRightExpression()));
            } else if (leftOr.getRightExpression().equals(rightOr.getRightExpression())) {
                return new OrExpression(leftOr.getRightExpression(), new AndExpression(leftOr.getLeftExpression(), rightOr.getLeftExpression()));
            }
        }
        return isEncapsulated() ? new AndExpression(leftReduced, rightReduced, true) : new AndExpression(leftReduced, rightReduced);
    }

    @Override
    public Expression invert() {
        return new OrExpression(getLeftExpression().invert(), getRightExpression().invert(), isEncapsulated());
    }

    @Override
    public Expression substitute(Expression expression, Expression substitute) {
        if (this.equals(expression)) {
            return substitute;
        }
        return new AndExpression(getLeftExpression().substitute(expression, substitute), getRightExpression().substitute(expression, substitute), isEncapsulated());
    }

    @Override
    public String toString() {
        return String.format(isEncapsulated() ? "(%s AND %s)" : "%s AND %s", getLeftExpression().toString(), getRightExpression().toString());
    }
}

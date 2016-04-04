package de.timoh.logicinterpreter.objects;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class OrExpression extends BinaryExpression {

    public OrExpression(Expression leftExpression, Expression rightExpression, boolean encapsulated) {
        super(leftExpression, rightExpression, encapsulated);
    }

    public OrExpression(Expression leftExpression, Expression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public Expression reduce() {
        Expression leftReduced = getLeftExpression().reduce();
        Expression rightReduced = getRightExpression().reduce();
        if (leftReduced.equals(rightReduced) || leftReduced.equals(BooleanConstants.TRUE) || rightReduced.equals(BooleanConstants.FALSE)) {
            return leftReduced;
        } else if (leftReduced.equals(BooleanConstants.FALSE) || rightReduced.equals(BooleanConstants.TRUE)) {
            return rightReduced;
        } else if (leftReduced.equals(new NotExpression(rightReduced))) {
            return BooleanConstants.TRUE;
        } else if (rightReduced.equals(new NotExpression(leftReduced))) {
            return BooleanConstants.TRUE;
        } else if (leftReduced instanceof AndExpression && ((AndExpression) leftReduced).contains(rightReduced)) {
            return rightReduced;
        } else if (rightReduced instanceof AndExpression && ((AndExpression) rightReduced).contains(leftReduced)) {
            return leftReduced;
        } else if (leftReduced instanceof AndExpression && ((AndExpression) leftReduced).getLeftExpression().equals(new NotExpression(rightReduced))) {
            return new OrExpression(((AndExpression) leftReduced).getRightExpression(), rightReduced, isEncapsulated());
        } else if (leftReduced instanceof AndExpression && ((AndExpression) leftReduced).getRightExpression().equals(new NotExpression(rightReduced))) {
            return new OrExpression(((AndExpression) leftReduced).getLeftExpression(), rightReduced, isEncapsulated());
        } else if (rightReduced instanceof AndExpression && ((AndExpression) rightReduced).getLeftExpression().equals(new NotExpression(leftReduced))) {
            return new OrExpression(leftReduced, ((AndExpression) rightReduced).getRightExpression(), isEncapsulated());
        } else if (rightReduced instanceof AndExpression && ((AndExpression) rightReduced).getRightExpression().equals(new NotExpression(leftReduced))) {
            return new OrExpression(leftReduced, ((AndExpression) rightReduced).getLeftExpression(), isEncapsulated());
        }
        return new OrExpression(leftReduced, rightReduced, isEncapsulated());
    }

    @Override
    public Expression invert() {
        return new AndExpression(getLeftExpression().invert(), getRightExpression().invert(), isEncapsulated());
    }

    @Override
    public Expression substitute(Expression expression, Expression substitute) {
        if (this.equals(expression)) {
            return substitute;
        }
        return new OrExpression(getLeftExpression().substitute(expression, substitute), getRightExpression().substitute(expression, substitute), isEncapsulated());
    }

    @Override
    public String getPrettyString() {
        return String.format("%s OR %s", getLeftExpression().toString(), getRightExpression().toString());
    }

    @Override
    public String toString() {
        return String.format(isEncapsulated() ? "(%s OR %s)" : "%s OR %s", getLeftExpression().toString(), getRightExpression().toString());
    }
}

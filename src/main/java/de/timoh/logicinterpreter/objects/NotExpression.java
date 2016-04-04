package de.timoh.logicinterpreter.objects;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class NotExpression extends UnaryExpression {

    public NotExpression(Expression expression) {
        super(expression);
    }

    @Override
    public Expression reduce() {
        return getExpression().reduce().invert();
    }

    @Override
    public Expression invert() {
        return getExpression();
    }

    @Override
    public Expression substitute(Expression expression, Expression substitute) {
        if (this.equals(expression)) {
            return substitute;
        }
        return new NotExpression(getExpression().substitute(expression, substitute));
    }

    @Override
    public String getPrettyString() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("NOT %s", getExpression().toString());
    }
}

package de.timoh.logicinterpreter.objects;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public abstract class UnaryExpression implements Expression {

    private Expression expression;

    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public boolean equals(Object o) {
        return !(o == null || getClass() != o.getClass()) && (this == o || this.toString().equalsIgnoreCase(o.toString()));
    }
}

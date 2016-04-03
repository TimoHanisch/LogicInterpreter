package de.timoh.logicinterpreter.objects;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class IdentifierExpression implements Expression {

    private String value;

    public IdentifierExpression(String value) {
        this.value = value;
    }

    @Override
    public Expression reduce() {
        return this;
    }

    @Override
    public Expression invert() {
        return new NotExpression(this);
    }

    @Override
    public Expression substitute(Expression expression, Expression substitute) {
        if(this.equals(expression)) {
            return substitute;
        }
        return this;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return !(o == null || getClass() != o.getClass()) && (this == o || this.toString().equalsIgnoreCase(o.toString()));
    }
}

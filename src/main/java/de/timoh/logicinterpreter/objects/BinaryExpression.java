package de.timoh.logicinterpreter.objects;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
abstract class BinaryExpression implements Expression {

    private boolean encapsulated = false;
    private Expression leftExpression;
    private Expression rightExpression;

    BinaryExpression(Expression leftExpression, Expression rightExpression, boolean encapsulated) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.encapsulated = encapsulated;
    }

    BinaryExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    Expression getLeftExpression() {
        return leftExpression;
    }

    Expression getRightExpression() {
        return rightExpression;
    }

    boolean isEncapsulated() {
        return encapsulated;
    }

    @Override
    public boolean equals(Object o) {
        return !(o == null || getClass() != o.getClass()) && (this == o || this.toString().equalsIgnoreCase(o.toString()));
    }
}

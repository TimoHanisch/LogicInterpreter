package de.timoh.logicinterpreter.objects;

/**
 * Created on 05.03.2016.
 *
 * @author Timo Hanisch
 */
public interface Expression {

    Expression reduce();

    Expression invert();

    Expression substitute(Expression expression, Expression substitute);

    String getPrettyString();
}

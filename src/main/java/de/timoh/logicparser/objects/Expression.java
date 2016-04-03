package de.timoh.logicparser.objects;

/**
 * Created on 05.03.2016.
 * @author Timo Hanisch
 */
public interface Expression {

    Expression reduce();

    Expression invert();

    Expression evaluate();
}

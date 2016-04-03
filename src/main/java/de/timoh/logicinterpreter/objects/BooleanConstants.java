package de.timoh.logicinterpreter.objects;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class BooleanConstants {

    public static final Expression FALSE = new FalseExpression();
    public static final Expression TRUE = new TrueExpression();

    /**
     * Created on 03.04.2016.
     *
     * @author Timo Hanisch
     */
    private static class FalseExpression implements Expression {

        private FalseExpression() {
        }

        @Override
        public Expression reduce() {
            return this;
        }

        @Override
        public Expression invert() {
            return TRUE;
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
            return "FALSE";
        }
    }

    /**
     * Created on 03.04.2016.
     *
     * @author Timo Hanisch
     */
    private static class TrueExpression implements Expression {

        private TrueExpression() {
        }

        @Override
        public Expression reduce() {
            return this;
        }

        @Override
        public Expression invert() {
            return FALSE;
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
            return "TRUE";
        }
    }
}

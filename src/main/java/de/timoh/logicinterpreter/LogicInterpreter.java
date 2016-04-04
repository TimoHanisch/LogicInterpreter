package de.timoh.logicinterpreter;

import de.timoh.logicinterpreter.objects.Expression;
import de.timoh.logicinterpreter.parser.LogicEvaluator;
import de.timoh.logicinterpreter.parser.generated.LogicLexer;
import de.timoh.logicinterpreter.parser.generated.LogicParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created on 03.04.2016.
 *
 * @author Timo Hanisch
 */
public class LogicInterpreter {

    private ParseTreeWalker walker = new ParseTreeWalker();
    private LogicEvaluator evaluator = new LogicEvaluator();

    public String evaluateString(String input) {
        evaluator.clean();
        LogicParser.ParseContext context = generateParseContext(new ANTLRInputStream(input));
        walker.walk(evaluator, context);
        return evaluate(evaluator.getExpression());
    }

    public String evaluateFile(String inputFilePath) throws IOException {
        evaluator.clean();
        LogicParser.ParseContext context = generateParseContext(new ANTLRFileStream(inputFilePath));
        walker.walk(evaluator, context);
        return evaluate(evaluator.getExpression());
    }

    private LogicParser.ParseContext generateParseContext(CharStream inputStream) {
        Lexer lexer = new LogicLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LogicParser parser = new LogicParser(tokens);
        return parser.parse();
    }

    private String evaluate(Expression evaluatorExpression) {
        return evaluatorExpression.reduce().getPrettyString();
    }
}

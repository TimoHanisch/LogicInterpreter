// Generated from Logic.g4 by ANTLR 4.5

package de.timoh.logicparser.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogicParser}.
 */
public interface LogicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LogicParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(LogicParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(LogicParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicParser#logic_stmt}.
	 * @param ctx the parse tree
	 */
	void enterLogic_stmt(LogicParser.Logic_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicParser#logic_stmt}.
	 * @param ctx the parse tree
	 */
	void exitLogic_stmt(LogicParser.Logic_stmtContext ctx);
}
// Generated from Logic.g4 by ANTLR 4.5

package de.timoh.logicparser.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_PARREN=1, RIGHT_PARREN=2, NOT=3, AND=4, OR=5, Identifier=6, SKIP=7;
	public static final int
		RULE_parse = 0, RULE_logic_stmt = 1;
	public static final String[] ruleNames = {
		"parse", "logic_stmt"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'NOT'", "'AND'", "'OR'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LEFT_PARREN", "RIGHT_PARREN", "NOT", "AND", "OR", "Identifier", 
		"SKIP"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Logic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LogicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(LogicParser.EOF, 0); }
		public Logic_stmtContext logic_stmt() {
			return getRuleContext(Logic_stmtContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(5);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PARREN) | (1L << NOT) | (1L << Identifier))) != 0)) {
				{
				setState(4);
				logic_stmt(0);
				}
			}

			setState(7);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logic_stmtContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(LogicParser.NOT, 0); }
		public List<Logic_stmtContext> logic_stmt() {
			return getRuleContexts(Logic_stmtContext.class);
		}
		public Logic_stmtContext logic_stmt(int i) {
			return getRuleContext(Logic_stmtContext.class,i);
		}
		public TerminalNode LEFT_PARREN() { return getToken(LogicParser.LEFT_PARREN, 0); }
		public TerminalNode RIGHT_PARREN() { return getToken(LogicParser.RIGHT_PARREN, 0); }
		public TerminalNode Identifier() { return getToken(LogicParser.Identifier, 0); }
		public TerminalNode AND() { return getToken(LogicParser.AND, 0); }
		public TerminalNode OR() { return getToken(LogicParser.OR, 0); }
		public Logic_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterLogic_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitLogic_stmt(this);
		}
	}

	public final Logic_stmtContext logic_stmt() throws RecognitionException {
		return logic_stmt(0);
	}

	private Logic_stmtContext logic_stmt(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logic_stmtContext _localctx = new Logic_stmtContext(_ctx, _parentState);
		Logic_stmtContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_logic_stmt, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(10);
				match(NOT);
				setState(11);
				logic_stmt(4);
				}
				break;
			case LEFT_PARREN:
				{
				setState(12);
				match(LEFT_PARREN);
				setState(13);
				logic_stmt(0);
				setState(14);
				match(RIGHT_PARREN);
				}
				break;
			case Identifier:
				{
				setState(16);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(27);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(25);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new Logic_stmtContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logic_stmt);
						setState(19);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(20);
						match(AND);
						setState(21);
						logic_stmt(4);
						}
						break;
					case 2:
						{
						_localctx = new Logic_stmtContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logic_stmt);
						setState(22);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(23);
						match(OR);
						setState(24);
						logic_stmt(3);
						}
						break;
					}
					} 
				}
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return logic_stmt_sempred((Logic_stmtContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logic_stmt_sempred(Logic_stmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t!\4\2\t\2\4\3\t"+
		"\3\3\2\5\2\b\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\24\n\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\2\3\4\4\2\4\2\2"+
		"#\2\7\3\2\2\2\4\23\3\2\2\2\6\b\5\4\3\2\7\6\3\2\2\2\7\b\3\2\2\2\b\t\3\2"+
		"\2\2\t\n\7\2\2\3\n\3\3\2\2\2\13\f\b\3\1\2\f\r\7\5\2\2\r\24\5\4\3\6\16"+
		"\17\7\3\2\2\17\20\5\4\3\2\20\21\7\4\2\2\21\24\3\2\2\2\22\24\7\b\2\2\23"+
		"\13\3\2\2\2\23\16\3\2\2\2\23\22\3\2\2\2\24\35\3\2\2\2\25\26\f\5\2\2\26"+
		"\27\7\6\2\2\27\34\5\4\3\6\30\31\f\4\2\2\31\32\7\7\2\2\32\34\5\4\3\5\33"+
		"\25\3\2\2\2\33\30\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36"+
		"\5\3\2\2\2\37\35\3\2\2\2\6\7\23\33\35";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
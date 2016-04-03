// Generated from Logic.g4 by ANTLR 4.5

package de.timoh.logicparser.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_PARREN=1, RIGHT_PARREN=2, NOT=3, AND=4, OR=5, Identifier=6, SKIP=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LEFT_PARREN", "RIGHT_PARREN", "NOT", "AND", "OR", "Identifier", "LetterOrDigit", 
		"SKIP", "WS", "LINE_COMMENT"
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


	public LogicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Logic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return LetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean LetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return Character.isJavaIdentifierPart(_input.LA(-1));
		case 1:
			return Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tI\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3"+
		"\7\7\7)\n\7\f\7\16\7,\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\64\n\b\3\t\3\t"+
		"\5\t8\n\t\3\t\3\t\3\n\3\n\3\13\3\13\7\13@\n\13\f\13\16\13C\13\13\3\13"+
		"\5\13F\n\13\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\t\23\2\25"+
		"\2\3\2\b\7\2&&\62;C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802\udc01\3\2"+
		"\udc02\ue001\5\2\13\f\16\17\"\"\4\2\f\f\17\17K\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\3\27\3"+
		"\2\2\2\5\31\3\2\2\2\7\33\3\2\2\2\t\37\3\2\2\2\13#\3\2\2\2\r&\3\2\2\2\17"+
		"\63\3\2\2\2\21\67\3\2\2\2\23;\3\2\2\2\25=\3\2\2\2\27\30\7*\2\2\30\4\3"+
		"\2\2\2\31\32\7+\2\2\32\6\3\2\2\2\33\34\7P\2\2\34\35\7Q\2\2\35\36\7V\2"+
		"\2\36\b\3\2\2\2\37 \7C\2\2 !\7P\2\2!\"\7F\2\2\"\n\3\2\2\2#$\7Q\2\2$%\7"+
		"T\2\2%\f\3\2\2\2&*\5\17\b\2\')\5\17\b\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2"+
		"*+\3\2\2\2+\16\3\2\2\2,*\3\2\2\2-\64\t\2\2\2./\n\3\2\2/\64\6\b\2\2\60"+
		"\61\t\4\2\2\61\62\t\5\2\2\62\64\6\b\3\2\63-\3\2\2\2\63.\3\2\2\2\63\60"+
		"\3\2\2\2\64\20\3\2\2\2\658\5\23\n\2\668\5\25\13\2\67\65\3\2\2\2\67\66"+
		"\3\2\2\289\3\2\2\29:\b\t\2\2:\22\3\2\2\2;<\t\6\2\2<\24\3\2\2\2=A\7%\2"+
		"\2>@\n\7\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BE\3\2\2\2CA\3\2\2"+
		"\2DF\7\17\2\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\f\2\2H\26\3\2\2\2\b\2"+
		"*\63\67AE\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
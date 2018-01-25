// Generated from src/edu/cabrillo/vmware/parsers/CLI.g4 by ANTLR 4.4

	package edu.cabrillo.vmware.parsers;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CLILexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, STRING=18, RTYPE=19, PATH=20, EOL=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"STRING", "RTYPE", "PATH", "PATHPART", "EOL", "WS"
	};


	public CLILexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CLI.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u00fc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\7"+
		"\23\u00b2\n\23\f\23\16\23\u00b5\13\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e1\n\24\3\25\6\25\u00e4"+
		"\n\25\r\25\16\25\u00e5\3\25\3\25\3\26\3\26\3\26\7\26\u00ed\n\26\f\26\16"+
		"\26\u00f0\13\26\3\27\3\27\5\27\u00f4\n\27\3\30\6\30\u00f7\n\30\r\30\16"+
		"\30\u00f8\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\2-\27/\30\3\2\6"+
		"\3\2$$\6\2\62;C\\c|~~\3\2\61\61\4\2\13\13\"\"\u0105\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\58\3\2\2\2\7;\3"+
		"\2\2\2\tA\3\2\2\2\13H\3\2\2\2\rO\3\2\2\2\17V\3\2\2\2\21^\3\2\2\2\23f\3"+
		"\2\2\2\25r\3\2\2\2\27z\3\2\2\2\31\177\3\2\2\2\33\u0086\3\2\2\2\35\u008d"+
		"\3\2\2\2\37\u0094\3\2\2\2!\u009d\3\2\2\2#\u00a4\3\2\2\2%\u00ad\3\2\2\2"+
		"\'\u00e0\3\2\2\2)\u00e3\3\2\2\2+\u00e9\3\2\2\2-\u00f1\3\2\2\2/\u00f6\3"+
		"\2\2\2\61\62\7t\2\2\62\63\7g\2\2\63\64\7d\2\2\64\65\7q\2\2\65\66\7q\2"+
		"\2\66\67\7v\2\2\67\4\3\2\2\289\7<\2\29:\7\61\2\2:\6\3\2\2\2;<\7o\2\2<"+
		"=\7m\2\2=>\7f\2\2>?\7k\2\2?@\7t\2\2@\b\3\2\2\2AB\7e\2\2BC\7t\2\2CD\7g"+
		"\2\2DE\7c\2\2EF\7v\2\2FG\7g\2\2G\n\3\2\2\2HI\7o\2\2IJ\7q\2\2JK\7f\2\2"+
		"KL\7p\2\2LM\7g\2\2MN\7v\2\2N\f\3\2\2\2OP\7f\2\2PQ\7g\2\2QR\7n\2\2RS\7"+
		"p\2\2ST\7g\2\2TU\7v\2\2U\16\3\2\2\2VW\7c\2\2WX\7f\2\2XY\7f\2\2YZ\7f\2"+
		"\2Z[\7k\2\2[\\\7u\2\2\\]\7m\2\2]\20\3\2\2\2^_\7r\2\2_`\7q\2\2`a\7y\2\2"+
		"ab\7g\2\2bc\7t\2\2cd\7q\2\2de\7p\2\2e\22\3\2\2\2fg\7n\2\2gh\7k\2\2hi\7"+
		"p\2\2ij\7m\2\2jk\7g\2\2kl\7f\2\2lm\7e\2\2mn\7n\2\2no\7q\2\2op\7p\2\2p"+
		"q\7g\2\2q\24\3\2\2\2rs\7o\2\2st\7k\2\2tu\7i\2\2uv\7t\2\2vw\7c\2\2wx\7"+
		"v\2\2xy\7g\2\2y\26\3\2\2\2z{\7o\2\2{|\7q\2\2|}\7x\2\2}~\7g\2\2~\30\3\2"+
		"\2\2\177\u0080\7f\2\2\u0080\u0081\7g\2\2\u0081\u0082\7n\2\2\u0082\u0083"+
		"\7g\2\2\u0083\u0084\7v\2\2\u0084\u0085\7g\2\2\u0085\32\3\2\2\2\u0086\u0087"+
		"\7o\2\2\u0087\u0088\7m\2\2\u0088\u0089\7u\2\2\u0089\u008a\7p\2\2\u008a"+
		"\u008b\7c\2\2\u008b\u008c\7r\2\2\u008c\34\3\2\2\2\u008d\u008e\7t\2\2\u008e"+
		"\u008f\7g\2\2\u008f\u0090\7p\2\2\u0090\u0091\7c\2\2\u0091\u0092\7o\2\2"+
		"\u0092\u0093\7g\2\2\u0093\36\3\2\2\2\u0094\u0095\7r\2\2\u0095\u0096\7"+
		"q\2\2\u0096\u0097\7y\2\2\u0097\u0098\7g\2\2\u0098\u0099\7t\2\2\u0099\u009a"+
		"\7q\2\2\u009a\u009b\7h\2\2\u009b\u009c\7h\2\2\u009c \3\2\2\2\u009d\u009e"+
		"\7c\2\2\u009e\u009f\7f\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7p\2\2\u00a1"+
		"\u00a2\7g\2\2\u00a2\u00a3\7v\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7u\2\2\u00a5"+
		"\u00a6\7j\2\2\u00a6\u00a7\7w\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7f\2\2"+
		"\u00a9\u00aa\7q\2\2\u00aa\u00ab\7y\2\2\u00ab\u00ac\7p\2\2\u00ac$\3\2\2"+
		"\2\u00ad\u00b3\7$\2\2\u00ae\u00b2\n\2\2\2\u00af\u00b0\7^\2\2\u00b0\u00b2"+
		"\7$\2\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b6\u00b7\7$\2\2\u00b7&\3\2\2\2\u00b8\u00b9\7x\2\2\u00b9\u00e1"+
		"\7o\2\2\u00ba\u00bb\7h\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7n\2\2\u00bd"+
		"\u00be\7f\2\2\u00be\u00bf\7g\2\2\u00bf\u00e1\7t\2\2\u00c0\u00c1\7g\2\2"+
		"\u00c1\u00c2\7p\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5"+
		"\7v\2\2\u00c5\u00e1\7{\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7p\2\2\u00c8"+
		"\u00c9\7c\2\2\u00c9\u00ca\7r\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7j\2\2"+
		"\u00cc\u00cd\7q\2\2\u00cd\u00e1\7v\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0"+
		"\7q\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7i\2\2\u00d3"+
		"\u00d4\7t\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6\7w\2\2\u00d6\u00e1\7r\2\2"+
		"\u00d7\u00d8\7f\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7v\2\2\u00da\u00db"+
		"\7c\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7q\2\2\u00de"+
		"\u00df\7t\2\2\u00df\u00e1\7g\2\2\u00e0\u00b8\3\2\2\2\u00e0\u00ba\3\2\2"+
		"\2\u00e0\u00c0\3\2\2\2\u00e0\u00c6\3\2\2\2\u00e0\u00ce\3\2\2\2\u00e0\u00d7"+
		"\3\2\2\2\u00e1(\3\2\2\2\u00e2\u00e4\5+\26\2\u00e3\u00e2\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00e8\7\61\2\2\u00e8*\3\2\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00ee"+
		"\t\3\2\2\u00eb\u00ed\n\4\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef,\3\2\2\2\u00f0\u00ee\3\2\2\2"+
		"\u00f1\u00f3\7\f\2\2\u00f2\u00f4\7\17\2\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4.\3\2\2\2\u00f5\u00f7\t\5\2\2\u00f6\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fb\b\30\2\2\u00fb\60\3\2\2\2\n\2\u00b1\u00b3\u00e0\u00e5"+
		"\u00ee\u00f3\u00f8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
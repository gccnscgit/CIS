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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, STRING=16, RTYPE=17, 
		PATH=18, EOL=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "STRING", "RTYPE", "PATH", 
		"PATHPART", "EOL", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u00e9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u009f\n\21\f\21\16\21"+
		"\u00a2\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u00ce\n\22\3\23\6\23\u00d1\n\23\r\23\16\23\u00d2\3"+
		"\23\3\23\3\24\3\24\3\24\7\24\u00da\n\24\f\24\16\24\u00dd\13\24\3\25\3"+
		"\25\5\25\u00e1\n\25\3\26\6\26\u00e4\n\26\r\26\16\26\u00e5\3\26\3\26\2"+
		"\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\2)\25+\26\3\2\6\3\2$$\6\2\62;C\\c|~~\3\2\61\61"+
		"\4\2\13\13\"\"\u00f2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5"+
		"\62\3\2\2\2\79\3\2\2\2\tB\3\2\2\2\13J\3\2\2\2\rS\3\2\2\2\17Z\3\2\2\2\21"+
		"a\3\2\2\2\23g\3\2\2\2\25n\3\2\2\2\27z\3\2\2\2\31\u0081\3\2\2\2\33\u0088"+
		"\3\2\2\2\35\u008f\3\2\2\2\37\u0092\3\2\2\2!\u009a\3\2\2\2#\u00cd\3\2\2"+
		"\2%\u00d0\3\2\2\2\'\u00d6\3\2\2\2)\u00de\3\2\2\2+\u00e3\3\2\2\2-.\7o\2"+
		"\2./\7q\2\2/\60\7x\2\2\60\61\7g\2\2\61\4\3\2\2\2\62\63\7f\2\2\63\64\7"+
		"g\2\2\64\65\7n\2\2\65\66\7g\2\2\66\67\7v\2\2\678\7g\2\28\6\3\2\2\29:\7"+
		"u\2\2:;\7j\2\2;<\7w\2\2<=\7v\2\2=>\7f\2\2>?\7q\2\2?@\7y\2\2@A\7p\2\2A"+
		"\b\3\2\2\2BC\7r\2\2CD\7q\2\2DE\7y\2\2EF\7g\2\2FG\7t\2\2GH\7q\2\2HI\7p"+
		"\2\2I\n\3\2\2\2JK\7r\2\2KL\7q\2\2LM\7y\2\2MN\7g\2\2NO\7t\2\2OP\7q\2\2"+
		"PQ\7h\2\2QR\7h\2\2R\f\3\2\2\2ST\7e\2\2TU\7t\2\2UV\7g\2\2VW\7c\2\2WX\7"+
		"v\2\2XY\7g\2\2Y\16\3\2\2\2Z[\7o\2\2[\\\7q\2\2\\]\7f\2\2]^\7p\2\2^_\7g"+
		"\2\2_`\7v\2\2`\20\3\2\2\2ab\7o\2\2bc\7m\2\2cd\7f\2\2de\7k\2\2ef\7t\2\2"+
		"f\22\3\2\2\2gh\7c\2\2hi\7f\2\2ij\7f\2\2jk\7p\2\2kl\7g\2\2lm\7v\2\2m\24"+
		"\3\2\2\2no\7n\2\2op\7k\2\2pq\7p\2\2qr\7m\2\2rs\7g\2\2st\7f\2\2tu\7e\2"+
		"\2uv\7n\2\2vw\7q\2\2wx\7p\2\2xy\7g\2\2y\26\3\2\2\2z{\7t\2\2{|\7g\2\2|"+
		"}\7d\2\2}~\7q\2\2~\177\7q\2\2\177\u0080\7v\2\2\u0080\30\3\2\2\2\u0081"+
		"\u0082\7f\2\2\u0082\u0083\7g\2\2\u0083\u0084\7n\2\2\u0084\u0085\7p\2\2"+
		"\u0085\u0086\7g\2\2\u0086\u0087\7v\2\2\u0087\32\3\2\2\2\u0088\u0089\7"+
		"t\2\2\u0089\u008a\7g\2\2\u008a\u008b\7p\2\2\u008b\u008c\7c\2\2\u008c\u008d"+
		"\7o\2\2\u008d\u008e\7g\2\2\u008e\34\3\2\2\2\u008f\u0090\7<\2\2\u0090\u0091"+
		"\7\61\2\2\u0091\36\3\2\2\2\u0092\u0093\7o\2\2\u0093\u0094\7k\2\2\u0094"+
		"\u0095\7i\2\2\u0095\u0096\7t\2\2\u0096\u0097\7c\2\2\u0097\u0098\7v\2\2"+
		"\u0098\u0099\7g\2\2\u0099 \3\2\2\2\u009a\u00a0\7$\2\2\u009b\u009f\n\2"+
		"\2\2\u009c\u009d\7^\2\2\u009d\u009f\7$\2\2\u009e\u009b\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7$\2\2\u00a4\"\3\2\2\2"+
		"\u00a5\u00a6\7x\2\2\u00a6\u00ce\7o\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9"+
		"\7q\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7f\2\2\u00ab\u00ac\7g\2\2\u00ac"+
		"\u00ce\7t\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7v\2\2"+
		"\u00b0\u00b1\7k\2\2\u00b1\u00b2\7v\2\2\u00b2\u00ce\7{\2\2\u00b3\u00b4"+
		"\7u\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7r\2\2\u00b7"+
		"\u00b8\7u\2\2\u00b8\u00b9\7j\2\2\u00b9\u00ba\7q\2\2\u00ba\u00ce\7v\2\2"+
		"\u00bb\u00bc\7r\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7t\2\2\u00be\u00bf"+
		"\7v\2\2\u00bf\u00c0\7i\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7q\2\2\u00c2"+
		"\u00c3\7w\2\2\u00c3\u00ce\7r\2\2\u00c4\u00c5\7f\2\2\u00c5\u00c6\7c\2\2"+
		"\u00c6\u00c7\7v\2\2\u00c7\u00c8\7c\2\2\u00c8\u00c9\7u\2\2\u00c9\u00ca"+
		"\7v\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7t\2\2\u00cc\u00ce\7g\2\2\u00cd"+
		"\u00a5\3\2\2\2\u00cd\u00a7\3\2\2\2\u00cd\u00ad\3\2\2\2\u00cd\u00b3\3\2"+
		"\2\2\u00cd\u00bb\3\2\2\2\u00cd\u00c4\3\2\2\2\u00ce$\3\2\2\2\u00cf\u00d1"+
		"\5\'\24\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2"+
		"\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\61\2\2\u00d5&\3"+
		"\2\2\2\u00d6\u00d7\7\61\2\2\u00d7\u00db\t\3\2\2\u00d8\u00da\n\4\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc(\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\7\f\2\2\u00df\u00e1"+
		"\7\17\2\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1*\3\2\2\2\u00e2"+
		"\u00e4\t\5\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b\26\2\2\u00e8"+
		",\3\2\2\2\n\2\u009e\u00a0\u00cd\u00d2\u00db\u00e0\u00e5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
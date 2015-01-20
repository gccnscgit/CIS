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
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, STRING=11, RTYPE=12, PATH=13, EOL=14, WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "STRING", "RTYPE", "PATH", "PATHPART", "EOL", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\u00ad\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\7\fl\n\f\f\f\16\fo\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0092\n\r\3\16\6\16\u0095\n\16\r\16"+
		"\16\16\u0096\3\16\3\16\3\17\3\17\3\17\7\17\u009e\n\17\f\17\16\17\u00a1"+
		"\13\17\3\20\3\20\5\20\u00a5\n\20\3\21\6\21\u00a8\n\21\r\21\16\21\u00a9"+
		"\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\2\37\20!\21\3\2\6\3\2$$\6\2\62;C\\c|~~\3\2\61\61\4\2\13\13"+
		"\"\"\u00b5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2"+
		"\5(\3\2\2\2\7/\3\2\2\2\t\66\3\2\2\2\13=\3\2\2\2\r@\3\2\2\2\17G\3\2\2\2"+
		"\21M\3\2\2\2\23T\3\2\2\2\25[\3\2\2\2\27g\3\2\2\2\31\u0091\3\2\2\2\33\u0094"+
		"\3\2\2\2\35\u009a\3\2\2\2\37\u00a2\3\2\2\2!\u00a7\3\2\2\2#$\7o\2\2$%\7"+
		"q\2\2%&\7x\2\2&\'\7g\2\2\'\4\3\2\2\2()\7f\2\2)*\7g\2\2*+\7n\2\2+,\7g\2"+
		"\2,-\7v\2\2-.\7g\2\2.\6\3\2\2\2/\60\7f\2\2\60\61\7g\2\2\61\62\7n\2\2\62"+
		"\63\7p\2\2\63\64\7g\2\2\64\65\7v\2\2\65\b\3\2\2\2\66\67\7t\2\2\678\7g"+
		"\2\289\7p\2\29:\7c\2\2:;\7o\2\2;<\7g\2\2<\n\3\2\2\2=>\7<\2\2>?\7\61\2"+
		"\2?\f\3\2\2\2@A\7e\2\2AB\7t\2\2BC\7g\2\2CD\7c\2\2DE\7v\2\2EF\7g\2\2F\16"+
		"\3\2\2\2GH\7o\2\2HI\7m\2\2IJ\7f\2\2JK\7k\2\2KL\7t\2\2L\20\3\2\2\2MN\7"+
		"o\2\2NO\7q\2\2OP\7f\2\2PQ\7p\2\2QR\7g\2\2RS\7v\2\2S\22\3\2\2\2TU\7c\2"+
		"\2UV\7f\2\2VW\7f\2\2WX\7p\2\2XY\7g\2\2YZ\7v\2\2Z\24\3\2\2\2[\\\7n\2\2"+
		"\\]\7k\2\2]^\7p\2\2^_\7m\2\2_`\7g\2\2`a\7f\2\2ab\7e\2\2bc\7n\2\2cd\7q"+
		"\2\2de\7p\2\2ef\7g\2\2f\26\3\2\2\2gm\7$\2\2hl\n\2\2\2ij\7^\2\2jl\7$\2"+
		"\2kh\3\2\2\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2"+
		"\2pq\7$\2\2q\30\3\2\2\2rs\7x\2\2s\u0092\7o\2\2tu\7h\2\2uv\7q\2\2vw\7n"+
		"\2\2wx\7f\2\2xy\7g\2\2y\u0092\7t\2\2z{\7g\2\2{|\7p\2\2|}\7v\2\2}~\7k\2"+
		"\2~\177\7v\2\2\177\u0092\7{\2\2\u0080\u0081\7u\2\2\u0081\u0082\7p\2\2"+
		"\u0082\u0083\7c\2\2\u0083\u0084\7r\2\2\u0084\u0085\7u\2\2\u0085\u0086"+
		"\7j\2\2\u0086\u0087\7q\2\2\u0087\u0092\7v\2\2\u0088\u0089\7r\2\2\u0089"+
		"\u008a\7q\2\2\u008a\u008b\7t\2\2\u008b\u008c\7v\2\2\u008c\u008d\7i\2\2"+
		"\u008d\u008e\7t\2\2\u008e\u008f\7q\2\2\u008f\u0090\7w\2\2\u0090\u0092"+
		"\7r\2\2\u0091r\3\2\2\2\u0091t\3\2\2\2\u0091z\3\2\2\2\u0091\u0080\3\2\2"+
		"\2\u0091\u0088\3\2\2\2\u0092\32\3\2\2\2\u0093\u0095\5\35\17\2\u0094\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\7\61\2\2\u0099\34\3\2\2\2\u009a\u009b\7\61"+
		"\2\2\u009b\u009f\t\3\2\2\u009c\u009e\n\4\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\36\3\2\2"+
		"\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\7\f\2\2\u00a3\u00a5\7\17\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5 \3\2\2\2\u00a6\u00a8\t\5\2\2"+
		"\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\21\2\2\u00ac\"\3\2\2\2\n\2"+
		"km\u0091\u0096\u009f\u00a4\u00a9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
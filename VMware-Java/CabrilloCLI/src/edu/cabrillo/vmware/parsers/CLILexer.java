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
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, STRING=12, RTYPE=13, PATH=14, EOL=15, WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "STRING", "RTYPE", "PATH", "PATHPART", "EOL", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22\u00c0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\rv\n\r\f"+
		"\r\16\ry\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00a5\n\16\3\17\6\17\u00a8\n\17\r\17\16\17\u00a9\3\17"+
		"\3\17\3\20\3\20\3\20\7\20\u00b1\n\20\f\20\16\20\u00b4\13\20\3\21\3\21"+
		"\5\21\u00b8\n\21\3\22\6\22\u00bb\n\22\r\22\16\22\u00bc\3\22\3\22\2\2\23"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\2!\21#\22\3\2\6\3\2$$\6\2\62;C\\c|~~\3\2\61\61\4\2\13\13\"\"\u00c9"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2"+
		"\2\5*\3\2\2\2\7\61\3\2\2\2\t8\3\2\2\2\13?\3\2\2\2\rB\3\2\2\2\17I\3\2\2"+
		"\2\21O\3\2\2\2\23V\3\2\2\2\25]\3\2\2\2\27i\3\2\2\2\31q\3\2\2\2\33\u00a4"+
		"\3\2\2\2\35\u00a7\3\2\2\2\37\u00ad\3\2\2\2!\u00b5\3\2\2\2#\u00ba\3\2\2"+
		"\2%&\7o\2\2&\'\7q\2\2\'(\7x\2\2()\7g\2\2)\4\3\2\2\2*+\7f\2\2+,\7g\2\2"+
		",-\7n\2\2-.\7g\2\2./\7v\2\2/\60\7g\2\2\60\6\3\2\2\2\61\62\7f\2\2\62\63"+
		"\7g\2\2\63\64\7n\2\2\64\65\7p\2\2\65\66\7g\2\2\66\67\7v\2\2\67\b\3\2\2"+
		"\289\7t\2\29:\7g\2\2:;\7p\2\2;<\7c\2\2<=\7o\2\2=>\7g\2\2>\n\3\2\2\2?@"+
		"\7<\2\2@A\7\61\2\2A\f\3\2\2\2BC\7e\2\2CD\7t\2\2DE\7g\2\2EF\7c\2\2FG\7"+
		"v\2\2GH\7g\2\2H\16\3\2\2\2IJ\7o\2\2JK\7m\2\2KL\7f\2\2LM\7k\2\2MN\7t\2"+
		"\2N\20\3\2\2\2OP\7o\2\2PQ\7q\2\2QR\7f\2\2RS\7p\2\2ST\7g\2\2TU\7v\2\2U"+
		"\22\3\2\2\2VW\7c\2\2WX\7f\2\2XY\7f\2\2YZ\7p\2\2Z[\7g\2\2[\\\7v\2\2\\\24"+
		"\3\2\2\2]^\7n\2\2^_\7k\2\2_`\7p\2\2`a\7m\2\2ab\7g\2\2bc\7f\2\2cd\7e\2"+
		"\2de\7n\2\2ef\7q\2\2fg\7p\2\2gh\7g\2\2h\26\3\2\2\2ij\7o\2\2jk\7k\2\2k"+
		"l\7i\2\2lm\7t\2\2mn\7c\2\2no\7v\2\2op\7g\2\2p\30\3\2\2\2qw\7$\2\2rv\n"+
		"\2\2\2st\7^\2\2tv\7$\2\2ur\3\2\2\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2"+
		"\2\2xz\3\2\2\2yw\3\2\2\2z{\7$\2\2{\32\3\2\2\2|}\7x\2\2}\u00a5\7o\2\2~"+
		"\177\7h\2\2\177\u0080\7q\2\2\u0080\u0081\7n\2\2\u0081\u0082\7f\2\2\u0082"+
		"\u0083\7g\2\2\u0083\u00a5\7t\2\2\u0084\u0085\7g\2\2\u0085\u0086\7p\2\2"+
		"\u0086\u0087\7v\2\2\u0087\u0088\7k\2\2\u0088\u0089\7v\2\2\u0089\u00a5"+
		"\7{\2\2\u008a\u008b\7u\2\2\u008b\u008c\7p\2\2\u008c\u008d\7c\2\2\u008d"+
		"\u008e\7r\2\2\u008e\u008f\7u\2\2\u008f\u0090\7j\2\2\u0090\u0091\7q\2\2"+
		"\u0091\u00a5\7v\2\2\u0092\u0093\7r\2\2\u0093\u0094\7q\2\2\u0094\u0095"+
		"\7t\2\2\u0095\u0096\7v\2\2\u0096\u0097\7i\2\2\u0097\u0098\7t\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7w\2\2\u009a\u00a5\7r\2\2\u009b\u009c\7f\2\2"+
		"\u009c\u009d\7c\2\2\u009d\u009e\7v\2\2\u009e\u009f\7c\2\2\u009f\u00a0"+
		"\7u\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3\7t\2\2\u00a3"+
		"\u00a5\7g\2\2\u00a4|\3\2\2\2\u00a4~\3\2\2\2\u00a4\u0084\3\2\2\2\u00a4"+
		"\u008a\3\2\2\2\u00a4\u0092\3\2\2\2\u00a4\u009b\3\2\2\2\u00a5\34\3\2\2"+
		"\2\u00a6\u00a8\5\37\20\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\61"+
		"\2\2\u00ac\36\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00b2\t\3\2\2\u00af\u00b1"+
		"\n\4\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3 \3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\7\f\2\2"+
		"\u00b6\u00b8\7\17\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\""+
		"\3\2\2\2\u00b9\u00bb\t\5\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\22"+
		"\2\2\u00bf$\3\2\2\2\n\2uw\u00a4\u00a9\u00b2\u00b7\u00bc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
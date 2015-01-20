// Generated from src/edu/cabrillo/vmware/parsers/CLI.g4 by ANTLR 4.4

	package edu.cabrillo.vmware.parsers;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CLIParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, STRING=11, RTYPE=12, PATH=13, EOL=14, WS=15;
	public static final String[] tokenNames = {
		"<INVALID>", "'move'", "'delete'", "'delnet'", "'rename'", "':/'", "'create'", 
		"'mkdir'", "'modnet'", "'addnet'", "'linkedclone'", "STRING", "RTYPE", 
		"PATH", "EOL", "WS"
	};
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_command = 2, RULE_linkedclone = 3, 
		RULE_move = 4, RULE_rename = 5, RULE_mkdir = 6, RULE_delete = 7, RULE_create = 8, 
		RULE_addnet = 9, RULE_modnet = 10, RULE_delnet = 11, RULE_vrl = 12;
	public static final String[] ruleNames = {
		"file", "line", "command", "linkedclone", "move", "rename", "mkdir", "delete", 
		"create", "addnet", "modnet", "delnet", "vrl"
	};

	@Override
	public String getGrammarFileName() { return "CLI.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	   public RecognitionException haserror = null;

	public CLIParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CLIParser.EOF, 0); }
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << T__0) | (1L << EOL))) != 0)) {
				{
				{
				setState(26); line();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32); match(EOF);
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

	public static class LineContext extends ParserRuleContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public TerminalNode EOL() { return getToken(CLIParser.EOL, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << T__0))) != 0)) {
				{
				setState(34); command();
				}
			}

			setState(37); match(EOL);
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

	public static class CommandContext extends ParserRuleContext {
		public RenameContext rename() {
			return getRuleContext(RenameContext.class,0);
		}
		public DelnetContext delnet() {
			return getRuleContext(DelnetContext.class,0);
		}
		public ModnetContext modnet() {
			return getRuleContext(ModnetContext.class,0);
		}
		public MkdirContext mkdir() {
			return getRuleContext(MkdirContext.class,0);
		}
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public LinkedcloneContext linkedclone() {
			return getRuleContext(LinkedcloneContext.class,0);
		}
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public AddnetContext addnet() {
			return getRuleContext(AddnetContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_command);
		try {
			setState(48);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(39); linkedclone();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(40); move();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(41); rename();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(42); mkdir();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(43); delete();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 6);
				{
				setState(44); create();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 7);
				{
				setState(45); addnet();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 8);
				{
				setState(46); modnet();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 9);
				{
				setState(47); delnet();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class LinkedcloneContext extends ParserRuleContext {
		public List<VrlContext> vrl() {
			return getRuleContexts(VrlContext.class);
		}
		public VrlContext vrl(int i) {
			return getRuleContext(VrlContext.class,i);
		}
		public LinkedcloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkedclone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterLinkedclone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitLinkedclone(this);
		}
	}

	public final LinkedcloneContext linkedclone() throws RecognitionException {
		LinkedcloneContext _localctx = new LinkedcloneContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_linkedclone);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); match(T__0);
			setState(51); vrl();
			setState(52); vrl();
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

	public static class MoveContext extends ParserRuleContext {
		public List<VrlContext> vrl() {
			return getRuleContexts(VrlContext.class);
		}
		public VrlContext vrl(int i) {
			return getRuleContext(VrlContext.class,i);
		}
		public MoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterMove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitMove(this);
		}
	}

	public final MoveContext move() throws RecognitionException {
		MoveContext _localctx = new MoveContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_move);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); match(T__9);
			setState(55); vrl();
			setState(56); vrl();
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

	public static class RenameContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public TerminalNode STRING() { return getToken(CLIParser.STRING, 0); }
		public RenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterRename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitRename(this);
		}
	}

	public final RenameContext rename() throws RecognitionException {
		RenameContext _localctx = new RenameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(T__6);
			setState(59); vrl();
			setState(60); match(STRING);
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

	public static class MkdirContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public TerminalNode STRING() { return getToken(CLIParser.STRING, 0); }
		public MkdirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mkdir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterMkdir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitMkdir(this);
		}
	}

	public final MkdirContext mkdir() throws RecognitionException {
		MkdirContext _localctx = new MkdirContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mkdir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(T__3);
			setState(63); vrl();
			setState(64); match(STRING);
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

	public static class DeleteContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitDelete(this);
		}
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_delete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(T__8);
			setState(67); vrl();
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

	public static class CreateContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitCreate(this);
		}
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_create);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); match(T__4);
			setState(70); vrl();
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

	public static class AddnetContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public TerminalNode STRING() { return getToken(CLIParser.STRING, 0); }
		public AddnetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addnet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterAddnet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitAddnet(this);
		}
	}

	public final AddnetContext addnet() throws RecognitionException {
		AddnetContext _localctx = new AddnetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_addnet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(T__1);
			setState(73); vrl();
			setState(74); match(STRING);
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

	public static class ModnetContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public TerminalNode STRING() { return getToken(CLIParser.STRING, 0); }
		public ModnetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modnet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterModnet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitModnet(this);
		}
	}

	public final ModnetContext modnet() throws RecognitionException {
		ModnetContext _localctx = new ModnetContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_modnet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(T__2);
			setState(77); vrl();
			setState(78); match(STRING);
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

	public static class DelnetContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public TerminalNode STRING() { return getToken(CLIParser.STRING, 0); }
		public DelnetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delnet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterDelnet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitDelnet(this);
		}
	}

	public final DelnetContext delnet() throws RecognitionException {
		DelnetContext _localctx = new DelnetContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_delnet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(T__7);
			setState(81); vrl();
			setState(82); match(STRING);
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

	public static class VrlContext extends ParserRuleContext {
		public TerminalNode RTYPE() { return getToken(CLIParser.RTYPE, 0); }
		public TerminalNode PATH() { return getToken(CLIParser.PATH, 0); }
		public VrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vrl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterVrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitVrl(this);
		}
	}

	public final VrlContext vrl() throws RecognitionException {
		VrlContext _localctx = new VrlContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_vrl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); match(RTYPE);
			setState(85); match(T__5);
			setState(86); match(PATH);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21[\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3\3\5\3"+
		"&\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\63\n\4\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2W\2\37\3\2"+
		"\2\2\4%\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\n8\3\2\2\2\f<\3\2\2\2\16@\3"+
		"\2\2\2\20D\3\2\2\2\22G\3\2\2\2\24J\3\2\2\2\26N\3\2\2\2\30R\3\2\2\2\32"+
		"V\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3"+
		"\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7\2\2\3#\3\3\2\2\2$&\5\6\4\2%$\3\2\2"+
		"\2%&\3\2\2\2&\'\3\2\2\2\'(\7\20\2\2(\5\3\2\2\2)\63\5\b\5\2*\63\5\n\6\2"+
		"+\63\5\f\7\2,\63\5\16\b\2-\63\5\20\t\2.\63\5\22\n\2/\63\5\24\13\2\60\63"+
		"\5\26\f\2\61\63\5\30\r\2\62)\3\2\2\2\62*\3\2\2\2\62+\3\2\2\2\62,\3\2\2"+
		"\2\62-\3\2\2\2\62.\3\2\2\2\62/\3\2\2\2\62\60\3\2\2\2\62\61\3\2\2\2\63"+
		"\7\3\2\2\2\64\65\7\f\2\2\65\66\5\32\16\2\66\67\5\32\16\2\67\t\3\2\2\2"+
		"89\7\3\2\29:\5\32\16\2:;\5\32\16\2;\13\3\2\2\2<=\7\6\2\2=>\5\32\16\2>"+
		"?\7\r\2\2?\r\3\2\2\2@A\7\t\2\2AB\5\32\16\2BC\7\r\2\2C\17\3\2\2\2DE\7\4"+
		"\2\2EF\5\32\16\2F\21\3\2\2\2GH\7\b\2\2HI\5\32\16\2I\23\3\2\2\2JK\7\13"+
		"\2\2KL\5\32\16\2LM\7\r\2\2M\25\3\2\2\2NO\7\n\2\2OP\5\32\16\2PQ\7\r\2\2"+
		"Q\27\3\2\2\2RS\7\5\2\2ST\5\32\16\2TU\7\r\2\2U\31\3\2\2\2VW\7\16\2\2WX"+
		"\7\7\2\2XY\7\17\2\2Y\33\3\2\2\2\5\37%\62";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
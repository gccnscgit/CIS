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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, STRING=16, RTYPE=17, 
		PATH=18, EOL=19, WS=20;
	public static final String[] tokenNames = {
		"<INVALID>", "'move'", "'delete'", "'shutdown'", "'poweron'", "'poweroff'", 
		"'create'", "'modnet'", "'mkdir'", "'addnet'", "'linkedclone'", "'reboot'", 
		"'delnet'", "'rename'", "':/'", "'migrate'", "STRING", "RTYPE", "PATH", 
		"EOL", "WS"
	};
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_command = 2, RULE_linkedclone = 3, 
		RULE_move = 4, RULE_rename = 5, RULE_mkdir = 6, RULE_delete = 7, RULE_create = 8, 
		RULE_addnet = 9, RULE_modnet = 10, RULE_delnet = 11, RULE_migrate = 12, 
		RULE_poweron = 13, RULE_poweroff = 14, RULE_shutdown = 15, RULE_reboot = 16, 
		RULE_vrl = 17;
	public static final String[] ruleNames = {
		"file", "line", "command", "linkedclone", "move", "rename", "mkdir", "delete", 
		"create", "addnet", "modnet", "delnet", "migrate", "poweron", "poweroff", 
		"shutdown", "reboot", "vrl"
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__13) | (1L << T__12) | (1L << T__11) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__0) | (1L << EOL))) != 0)) {
				{
				{
				setState(36); line();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42); match(EOF);
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
			setState(45);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__13) | (1L << T__12) | (1L << T__11) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__0))) != 0)) {
				{
				setState(44); command();
				}
			}

			setState(47); match(EOL);
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
		public ModnetContext modnet() {
			return getRuleContext(ModnetContext.class,0);
		}
		public PoweroffContext poweroff() {
			return getRuleContext(PoweroffContext.class,0);
		}
		public MkdirContext mkdir() {
			return getRuleContext(MkdirContext.class,0);
		}
		public ShutdownContext shutdown() {
			return getRuleContext(ShutdownContext.class,0);
		}
		public MigrateContext migrate() {
			return getRuleContext(MigrateContext.class,0);
		}
		public RebootContext reboot() {
			return getRuleContext(RebootContext.class,0);
		}
		public DelnetContext delnet() {
			return getRuleContext(DelnetContext.class,0);
		}
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public LinkedcloneContext linkedclone() {
			return getRuleContext(LinkedcloneContext.class,0);
		}
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public PoweronContext poweron() {
			return getRuleContext(PoweronContext.class,0);
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
			setState(63);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(49); linkedclone();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(50); move();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(51); rename();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(52); mkdir();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(53); delete();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(54); create();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(55); addnet();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 8);
				{
				setState(56); modnet();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 9);
				{
				setState(57); delnet();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 10);
				{
				setState(58); migrate();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 11);
				{
				setState(59); poweron();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 12);
				{
				setState(60); poweroff();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 13);
				{
				setState(61); shutdown();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 14);
				{
				setState(62); reboot();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(T__5);
			setState(66); vrl();
			setState(67); vrl();
			setState(69);
			_la = _input.LA(1);
			if (_la==RTYPE) {
				{
				setState(68); vrl();
				}
			}

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
			setState(71); match(T__14);
			setState(72); vrl();
			setState(73); vrl();
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
			setState(75); match(T__2);
			setState(76); vrl();
			setState(77); match(STRING);
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
			setState(79); match(T__7);
			setState(80); vrl();
			setState(81); match(STRING);
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
			setState(83); match(T__13);
			setState(84); vrl();
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
			setState(86); match(T__9);
			setState(87); vrl();
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
		public TerminalNode STRING(int i) {
			return getToken(CLIParser.STRING, i);
		}
		public List<TerminalNode> STRING() { return getTokens(CLIParser.STRING); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); match(T__6);
			setState(90); vrl();
			setState(91); match(STRING);
			setState(94);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(92); match(STRING);
				setState(93); match(STRING);
				}
			}

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
			setState(96); match(T__8);
			setState(97); vrl();
			setState(98); match(STRING);
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
			setState(100); match(T__3);
			setState(101); vrl();
			setState(102); match(STRING);
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

	public static class MigrateContext extends ParserRuleContext {
		public List<VrlContext> vrl() {
			return getRuleContexts(VrlContext.class);
		}
		public VrlContext vrl(int i) {
			return getRuleContext(VrlContext.class,i);
		}
		public MigrateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_migrate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterMigrate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitMigrate(this);
		}
	}

	public final MigrateContext migrate() throws RecognitionException {
		MigrateContext _localctx = new MigrateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_migrate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(T__0);
			setState(105); vrl();
			setState(106); vrl();
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

	public static class PoweronContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public PoweronContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_poweron; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterPoweron(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitPoweron(this);
		}
	}

	public final PoweronContext poweron() throws RecognitionException {
		PoweronContext _localctx = new PoweronContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_poweron);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(T__11);
			setState(109); vrl();
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

	public static class PoweroffContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public PoweroffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_poweroff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterPoweroff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitPoweroff(this);
		}
	}

	public final PoweroffContext poweroff() throws RecognitionException {
		PoweroffContext _localctx = new PoweroffContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_poweroff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(T__10);
			setState(112); vrl();
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

	public static class ShutdownContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public ShutdownContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shutdown; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterShutdown(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitShutdown(this);
		}
	}

	public final ShutdownContext shutdown() throws RecognitionException {
		ShutdownContext _localctx = new ShutdownContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_shutdown);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(T__12);
			setState(115); vrl();
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

	public static class RebootContext extends ParserRuleContext {
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public RebootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reboot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterReboot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitReboot(this);
		}
	}

	public final RebootContext reboot() throws RecognitionException {
		RebootContext _localctx = new RebootContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_reboot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(T__4);
			setState(118); vrl();
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
		enterRule(_localctx, 34, RULE_vrl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(RTYPE);
			setState(121); match(T__1);
			setState(122); match(PATH);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\5\3\60\n\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5"+
		"\3\5\3\5\3\5\5\5H\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13a\n\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\2\2\24\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2}\2)\3\2\2\2\4/\3\2\2\2\6A"+
		"\3\2\2\2\bC\3\2\2\2\nI\3\2\2\2\fM\3\2\2\2\16Q\3\2\2\2\20U\3\2\2\2\22X"+
		"\3\2\2\2\24[\3\2\2\2\26b\3\2\2\2\30f\3\2\2\2\32j\3\2\2\2\34n\3\2\2\2\36"+
		"q\3\2\2\2 t\3\2\2\2\"w\3\2\2\2$z\3\2\2\2&(\5\4\3\2\'&\3\2\2\2(+\3\2\2"+
		"\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\2\2\3-\3\3\2\2\2.\60\5"+
		"\6\4\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\7\25\2\2\62\5\3\2\2\2"+
		"\63B\5\b\5\2\64B\5\n\6\2\65B\5\f\7\2\66B\5\16\b\2\67B\5\20\t\28B\5\22"+
		"\n\29B\5\24\13\2:B\5\26\f\2;B\5\30\r\2<B\5\32\16\2=B\5\34\17\2>B\5\36"+
		"\20\2?B\5 \21\2@B\5\"\22\2A\63\3\2\2\2A\64\3\2\2\2A\65\3\2\2\2A\66\3\2"+
		"\2\2A\67\3\2\2\2A8\3\2\2\2A9\3\2\2\2A:\3\2\2\2A;\3\2\2\2A<\3\2\2\2A=\3"+
		"\2\2\2A>\3\2\2\2A?\3\2\2\2A@\3\2\2\2B\7\3\2\2\2CD\7\f\2\2DE\5$\23\2EG"+
		"\5$\23\2FH\5$\23\2GF\3\2\2\2GH\3\2\2\2H\t\3\2\2\2IJ\7\3\2\2JK\5$\23\2"+
		"KL\5$\23\2L\13\3\2\2\2MN\7\17\2\2NO\5$\23\2OP\7\22\2\2P\r\3\2\2\2QR\7"+
		"\n\2\2RS\5$\23\2ST\7\22\2\2T\17\3\2\2\2UV\7\4\2\2VW\5$\23\2W\21\3\2\2"+
		"\2XY\7\b\2\2YZ\5$\23\2Z\23\3\2\2\2[\\\7\13\2\2\\]\5$\23\2]`\7\22\2\2^"+
		"_\7\22\2\2_a\7\22\2\2`^\3\2\2\2`a\3\2\2\2a\25\3\2\2\2bc\7\t\2\2cd\5$\23"+
		"\2de\7\22\2\2e\27\3\2\2\2fg\7\16\2\2gh\5$\23\2hi\7\22\2\2i\31\3\2\2\2"+
		"jk\7\21\2\2kl\5$\23\2lm\5$\23\2m\33\3\2\2\2no\7\6\2\2op\5$\23\2p\35\3"+
		"\2\2\2qr\7\7\2\2rs\5$\23\2s\37\3\2\2\2tu\7\5\2\2uv\5$\23\2v!\3\2\2\2w"+
		"x\7\r\2\2xy\5$\23\2y#\3\2\2\2z{\7\23\2\2{|\7\20\2\2|}\7\24\2\2}%\3\2\2"+
		"\2\7)/AG`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
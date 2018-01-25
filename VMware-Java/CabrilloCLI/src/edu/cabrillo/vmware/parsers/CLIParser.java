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
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, STRING=18, RTYPE=19, PATH=20, EOL=21, WS=22;
	public static final String[] tokenNames = {
		"<INVALID>", "'reboot'", "':/'", "'mkdir'", "'create'", "'modnet'", "'delnet'", 
		"'adddisk'", "'poweron'", "'linkedclone'", "'migrate'", "'move'", "'delete'", 
		"'mksnap'", "'rename'", "'poweroff'", "'addnet'", "'shutdown'", "STRING", 
		"RTYPE", "PATH", "EOL", "WS"
	};
	public static final int
		RULE_file = 0, RULE_line = 1, RULE_command = 2, RULE_linkedclone = 3, 
		RULE_move = 4, RULE_rename = 5, RULE_mkdir = 6, RULE_delete = 7, RULE_create = 8, 
		RULE_addnet = 9, RULE_adddisk = 10, RULE_modnet = 11, RULE_delnet = 12, 
		RULE_migrate = 13, RULE_poweron = 14, RULE_poweroff = 15, RULE_shutdown = 16, 
		RULE_reboot = 17, RULE_mksnap = 18, RULE_vrl = 19;
	public static final String[] ruleNames = {
		"file", "line", "command", "linkedclone", "move", "rename", "mkdir", "delete", 
		"create", "addnet", "adddisk", "modnet", "delnet", "migrate", "poweron", 
		"poweroff", "shutdown", "reboot", "mksnap", "vrl"
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
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TerminalNode EOF() { return getToken(CLIParser.EOF, 0); }
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__14) | (1L << T__13) | (1L << T__12) | (1L << T__11) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << T__0) | (1L << EOL))) != 0)) {
				{
				{
				setState(40); line();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46); match(EOF);
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
		public TerminalNode EOL() { return getToken(CLIParser.EOL, 0); }
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
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
			setState(49);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__14) | (1L << T__13) | (1L << T__12) | (1L << T__11) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << T__0))) != 0)) {
				{
				setState(48); command();
				}
			}

			setState(51); match(EOL);
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
		public CreateContext create() {
			return getRuleContext(CreateContext.class,0);
		}
		public PoweroffContext poweroff() {
			return getRuleContext(PoweroffContext.class,0);
		}
		public PoweronContext poweron() {
			return getRuleContext(PoweronContext.class,0);
		}
		public AdddiskContext adddisk() {
			return getRuleContext(AdddiskContext.class,0);
		}
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public ModnetContext modnet() {
			return getRuleContext(ModnetContext.class,0);
		}
		public MksnapContext mksnap() {
			return getRuleContext(MksnapContext.class,0);
		}
		public MkdirContext mkdir() {
			return getRuleContext(MkdirContext.class,0);
		}
		public LinkedcloneContext linkedclone() {
			return getRuleContext(LinkedcloneContext.class,0);
		}
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public DelnetContext delnet() {
			return getRuleContext(DelnetContext.class,0);
		}
		public MigrateContext migrate() {
			return getRuleContext(MigrateContext.class,0);
		}
		public AddnetContext addnet() {
			return getRuleContext(AddnetContext.class,0);
		}
		public ShutdownContext shutdown() {
			return getRuleContext(ShutdownContext.class,0);
		}
		public RebootContext reboot() {
			return getRuleContext(RebootContext.class,0);
		}
		public RenameContext rename() {
			return getRuleContext(RenameContext.class,0);
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
			setState(69);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); linkedclone();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(54); move();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55); rename();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(56); mkdir();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57); delete();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 6);
				{
				setState(58); create();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 7);
				{
				setState(59); addnet();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 8);
				{
				setState(60); adddisk();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 9);
				{
				setState(61); modnet();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 10);
				{
				setState(62); delnet();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 11);
				{
				setState(63); migrate();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 12);
				{
				setState(64); poweron();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 13);
				{
				setState(65); poweroff();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 14);
				{
				setState(66); shutdown();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 15);
				{
				setState(67); reboot();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 16);
				{
				setState(68); mksnap();
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
			setState(71); match(T__8);
			setState(72); vrl();
			setState(73); vrl();
			setState(75);
			_la = _input.LA(1);
			if (_la==RTYPE) {
				{
				setState(74); vrl();
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
			setState(77); match(T__6);
			setState(78); vrl();
			setState(79); vrl();
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
			setState(81); match(T__3);
			setState(82); vrl();
			setState(83); match(STRING);
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
			setState(85); match(T__14);
			setState(86); vrl();
			setState(87); match(STRING);
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
			setState(89); match(T__5);
			setState(90); vrl();
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
			setState(92); match(T__13);
			setState(93); vrl();
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
		public TerminalNode STRING(int i) {
			return getToken(CLIParser.STRING, i);
		}
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
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
			setState(95); match(T__1);
			setState(96); vrl();
			setState(97); match(STRING);
			setState(100);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(98); match(STRING);
				setState(99); match(STRING);
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

	public static class AdddiskContext extends ParserRuleContext {
		public TerminalNode STRING(int i) {
			return getToken(CLIParser.STRING, i);
		}
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public List<TerminalNode> STRING() { return getTokens(CLIParser.STRING); }
		public AdddiskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adddisk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterAdddisk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitAdddisk(this);
		}
	}

	public final AdddiskContext adddisk() throws RecognitionException {
		AdddiskContext _localctx = new AdddiskContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_adddisk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(T__10);
			setState(103); vrl();
			setState(104); match(STRING);
			setState(105); match(STRING);
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
		enterRule(_localctx, 22, RULE_modnet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); match(T__12);
			setState(108); vrl();
			setState(109); match(STRING);
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
		enterRule(_localctx, 24, RULE_delnet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(T__11);
			setState(112); vrl();
			setState(113); match(STRING);
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
		enterRule(_localctx, 26, RULE_migrate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(T__7);
			setState(116); vrl();
			setState(117); vrl();
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
		enterRule(_localctx, 28, RULE_poweron);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(T__9);
			setState(120); vrl();
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
		enterRule(_localctx, 30, RULE_poweroff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(T__2);
			setState(123); vrl();
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
		enterRule(_localctx, 32, RULE_shutdown);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(T__0);
			setState(126); vrl();
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
		enterRule(_localctx, 34, RULE_reboot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(T__16);
			setState(129); vrl();
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

	public static class MksnapContext extends ParserRuleContext {
		public TerminalNode STRING(int i) {
			return getToken(CLIParser.STRING, i);
		}
		public VrlContext vrl() {
			return getRuleContext(VrlContext.class,0);
		}
		public List<TerminalNode> STRING() { return getTokens(CLIParser.STRING); }
		public MksnapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mksnap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).enterMksnap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CLIListener ) ((CLIListener)listener).exitMksnap(this);
		}
	}

	public final MksnapContext mksnap() throws RecognitionException {
		MksnapContext _localctx = new MksnapContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mksnap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(T__4);
			setState(132); vrl();
			setState(133); match(STRING);
			setState(134); match(STRING);
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
		enterRule(_localctx, 38, RULE_vrl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); match(RTYPE);
			setState(137); match(T__15);
			setState(138); match(PATH);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u008f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3"+
		"\5\3\64\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4H\n\4\3\5\3\5\3\5\3\5\5\5N\n\5\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\5\13g\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\2\2\26"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\2\u008d\2-\3\2\2\2\4\63"+
		"\3\2\2\2\6G\3\2\2\2\bI\3\2\2\2\nO\3\2\2\2\fS\3\2\2\2\16W\3\2\2\2\20[\3"+
		"\2\2\2\22^\3\2\2\2\24a\3\2\2\2\26h\3\2\2\2\30m\3\2\2\2\32q\3\2\2\2\34"+
		"u\3\2\2\2\36y\3\2\2\2 |\3\2\2\2\"\177\3\2\2\2$\u0082\3\2\2\2&\u0085\3"+
		"\2\2\2(\u008a\3\2\2\2*,\5\4\3\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2"+
		"\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\2\2\3\61\3\3\2\2\2\62\64\5\6\4\2\63\62"+
		"\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7\27\2\2\66\5\3\2\2\2\67H\5"+
		"\b\5\28H\5\n\6\29H\5\f\7\2:H\5\16\b\2;H\5\20\t\2<H\5\22\n\2=H\5\24\13"+
		"\2>H\5\26\f\2?H\5\30\r\2@H\5\32\16\2AH\5\34\17\2BH\5\36\20\2CH\5 \21\2"+
		"DH\5\"\22\2EH\5$\23\2FH\5&\24\2G\67\3\2\2\2G8\3\2\2\2G9\3\2\2\2G:\3\2"+
		"\2\2G;\3\2\2\2G<\3\2\2\2G=\3\2\2\2G>\3\2\2\2G?\3\2\2\2G@\3\2\2\2GA\3\2"+
		"\2\2GB\3\2\2\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\7\3\2\2\2IJ\7"+
		"\13\2\2JK\5(\25\2KM\5(\25\2LN\5(\25\2ML\3\2\2\2MN\3\2\2\2N\t\3\2\2\2O"+
		"P\7\r\2\2PQ\5(\25\2QR\5(\25\2R\13\3\2\2\2ST\7\20\2\2TU\5(\25\2UV\7\24"+
		"\2\2V\r\3\2\2\2WX\7\5\2\2XY\5(\25\2YZ\7\24\2\2Z\17\3\2\2\2[\\\7\16\2\2"+
		"\\]\5(\25\2]\21\3\2\2\2^_\7\6\2\2_`\5(\25\2`\23\3\2\2\2ab\7\22\2\2bc\5"+
		"(\25\2cf\7\24\2\2de\7\24\2\2eg\7\24\2\2fd\3\2\2\2fg\3\2\2\2g\25\3\2\2"+
		"\2hi\7\t\2\2ij\5(\25\2jk\7\24\2\2kl\7\24\2\2l\27\3\2\2\2mn\7\7\2\2no\5"+
		"(\25\2op\7\24\2\2p\31\3\2\2\2qr\7\b\2\2rs\5(\25\2st\7\24\2\2t\33\3\2\2"+
		"\2uv\7\f\2\2vw\5(\25\2wx\5(\25\2x\35\3\2\2\2yz\7\n\2\2z{\5(\25\2{\37\3"+
		"\2\2\2|}\7\21\2\2}~\5(\25\2~!\3\2\2\2\177\u0080\7\23\2\2\u0080\u0081\5"+
		"(\25\2\u0081#\3\2\2\2\u0082\u0083\7\3\2\2\u0083\u0084\5(\25\2\u0084%\3"+
		"\2\2\2\u0085\u0086\7\17\2\2\u0086\u0087\5(\25\2\u0087\u0088\7\24\2\2\u0088"+
		"\u0089\7\24\2\2\u0089\'\3\2\2\2\u008a\u008b\7\25\2\2\u008b\u008c\7\4\2"+
		"\2\u008c\u008d\7\26\2\2\u008d)\3\2\2\2\7-\63GMf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
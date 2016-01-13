package edu.cabrillo.vmware;

import java.io.IOException;
import java.util.LinkedList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.gnu.readline.Readline;
import org.gnu.readline.ReadlineLibrary;

import com.vmware.sso.client.utils.Utils;

import edu.cabrillo.vmware.parsers.CLILexer;
import edu.cabrillo.vmware.parsers.CLIParser;
import edu.cabrillo.vmware.parsers.CLIParser.FileContext;

public class Main {

	private static final String x_vsp_server = "https://vcenter-6-0.cis.cabrillo.edu/sdk";
	
	private static void usage() {
		System.out.println("usage: cli [-u <username>] [<script>]");
	}

	private static FileContext parse(ANTLRInputStream input) {
		CLILexer lex = new CLILexer(input);
		lex.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
					int line, int charPositionInLine,
					String msg, RecognitionException e) {
				throw e;
			}
		});
		CommonTokenStream tokens = new CommonTokenStream(lex);
		final CLIParser par = new CLIParser(tokens);
		par.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
					int line, int charPositionInLine,
					String msg, RecognitionException e) {
				par.haserror = e;
			}
		});

		FileContext ctx = par.file();
		if (par.haserror != null) {
			throw par.haserror;
		}
		return ctx;		
	}

	private static void exec(FileContext ctx) {
		ParseTreeWalker walker = new ParseTreeWalker();
		Runtime interp = new Runtime();
		walker.walk(interp, ctx);
	}

	public static void initReadline() {
		Readline.load(ReadlineLibrary.Editline);
		// TODO: Make a completer.
	}

	private static void connect(String username, String password) {		
		Utils.trustAllHttpsCertificates();
		SSOSession sess = SSOSession.get();
		sess.setUrl(x_vsp_server);
		sess.generate();
		sess.setUsername(username);
		sess.setPassword(password);
		sess.connect();
	}
	
	public static void main(String[] argv) {		
		FileContext ctx;
		initReadline();

		LinkedList<String> args = new LinkedList<String>();
		for (String arg : argv) {
			args.add(arg);
		}
		
		if (System.console() == null) {
			System.out.println("No console. No password.");
			return;
		}

		String username;
		if (args.size() > 0 && "-u".equals(args.get(0))) {
			if (args.size() < 2) {
				usage();
				return;
			}
			username = args.get(1);
			args.remove(0);
			args.remove(0);
		}else{
			username = System.console().readLine("login: ");
		}

		String password = null;
		if (password == null) {
			password = String.valueOf(System.console().readPassword("password: "));
		}
		
		// Try to defer logging in as long as possible. Login is very slow...
		
		try {
			if (args.size() == 0) {
				try {
					while (true) {
						String command = Readline.readline("# ");
						if (command == null || command.matches("^\\s*$")) {
							continue; 
						}else if ("exit".equals(command) || "quit".equals(command)) {
							System.out.println("Goodbye");
							return;
						}
						try {
							ctx = parse(new ANTLRInputStream(command));
							connect(username, password);
							exec(ctx);
						} catch (RecognitionException e) {
							System.out.println("Parse error.");
						} catch (Throwable e) {
							System.out.println("Error: " + e.getMessage());
						}
					}
				} catch (IOException e) {
					System.out.println("");
					System.out.println("Goodbye");
					return;
				}
			}else if (args.size() == 1) {
				ANTLRInputStream is;
				try {
					is = new ANTLRFileStream(args.get(0));
				} catch (IOException e) {
					System.out.println("Error opening file: " + args.get(0));
					return;
				}
				ctx = parse(is);
				connect(username, password);
				exec(ctx);
			}else{
				usage();
				return; 
			}
		} finally {
			try {
				// SSOSession.get().logout();
			} catch (Exception e) {
				//ignore..
			}				
		}
	}
}

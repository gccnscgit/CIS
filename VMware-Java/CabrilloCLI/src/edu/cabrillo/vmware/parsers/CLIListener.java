// Generated from src/edu/cabrillo/vmware/parsers/CLI.g4 by ANTLR 4.4

	package edu.cabrillo.vmware.parsers;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CLIParser}.
 */
public interface CLIListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CLIParser#reboot}.
	 * @param ctx the parse tree
	 */
	void enterReboot(@NotNull CLIParser.RebootContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#reboot}.
	 * @param ctx the parse tree
	 */
	void exitReboot(@NotNull CLIParser.RebootContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#move}.
	 * @param ctx the parse tree
	 */
	void enterMove(@NotNull CLIParser.MoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#move}.
	 * @param ctx the parse tree
	 */
	void exitMove(@NotNull CLIParser.MoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#linkedclone}.
	 * @param ctx the parse tree
	 */
	void enterLinkedclone(@NotNull CLIParser.LinkedcloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#linkedclone}.
	 * @param ctx the parse tree
	 */
	void exitLinkedclone(@NotNull CLIParser.LinkedcloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#poweron}.
	 * @param ctx the parse tree
	 */
	void enterPoweron(@NotNull CLIParser.PoweronContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#poweron}.
	 * @param ctx the parse tree
	 */
	void exitPoweron(@NotNull CLIParser.PoweronContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(@NotNull CLIParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(@NotNull CLIParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#poweroff}.
	 * @param ctx the parse tree
	 */
	void enterPoweroff(@NotNull CLIParser.PoweroffContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#poweroff}.
	 * @param ctx the parse tree
	 */
	void exitPoweroff(@NotNull CLIParser.PoweroffContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#addnet}.
	 * @param ctx the parse tree
	 */
	void enterAddnet(@NotNull CLIParser.AddnetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#addnet}.
	 * @param ctx the parse tree
	 */
	void exitAddnet(@NotNull CLIParser.AddnetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#delete}.
	 * @param ctx the parse tree
	 */
	void enterDelete(@NotNull CLIParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#delete}.
	 * @param ctx the parse tree
	 */
	void exitDelete(@NotNull CLIParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(@NotNull CLIParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(@NotNull CLIParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#adddisk}.
	 * @param ctx the parse tree
	 */
	void enterAdddisk(@NotNull CLIParser.AdddiskContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#adddisk}.
	 * @param ctx the parse tree
	 */
	void exitAdddisk(@NotNull CLIParser.AdddiskContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#modnet}.
	 * @param ctx the parse tree
	 */
	void enterModnet(@NotNull CLIParser.ModnetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#modnet}.
	 * @param ctx the parse tree
	 */
	void exitModnet(@NotNull CLIParser.ModnetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#mksnap}.
	 * @param ctx the parse tree
	 */
	void enterMksnap(@NotNull CLIParser.MksnapContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#mksnap}.
	 * @param ctx the parse tree
	 */
	void exitMksnap(@NotNull CLIParser.MksnapContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#vrl}.
	 * @param ctx the parse tree
	 */
	void enterVrl(@NotNull CLIParser.VrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#vrl}.
	 * @param ctx the parse tree
	 */
	void exitVrl(@NotNull CLIParser.VrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull CLIParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull CLIParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#delnet}.
	 * @param ctx the parse tree
	 */
	void enterDelnet(@NotNull CLIParser.DelnetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#delnet}.
	 * @param ctx the parse tree
	 */
	void exitDelnet(@NotNull CLIParser.DelnetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#rename}.
	 * @param ctx the parse tree
	 */
	void enterRename(@NotNull CLIParser.RenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#rename}.
	 * @param ctx the parse tree
	 */
	void exitRename(@NotNull CLIParser.RenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#create}.
	 * @param ctx the parse tree
	 */
	void enterCreate(@NotNull CLIParser.CreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#create}.
	 * @param ctx the parse tree
	 */
	void exitCreate(@NotNull CLIParser.CreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#mkdir}.
	 * @param ctx the parse tree
	 */
	void enterMkdir(@NotNull CLIParser.MkdirContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#mkdir}.
	 * @param ctx the parse tree
	 */
	void exitMkdir(@NotNull CLIParser.MkdirContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#shutdown}.
	 * @param ctx the parse tree
	 */
	void enterShutdown(@NotNull CLIParser.ShutdownContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#shutdown}.
	 * @param ctx the parse tree
	 */
	void exitShutdown(@NotNull CLIParser.ShutdownContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLIParser#migrate}.
	 * @param ctx the parse tree
	 */
	void enterMigrate(@NotNull CLIParser.MigrateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLIParser#migrate}.
	 * @param ctx the parse tree
	 */
	void exitMigrate(@NotNull CLIParser.MigrateContext ctx);
}
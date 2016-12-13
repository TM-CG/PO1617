/** @version $Id: ProgramCommand.java,v 1.2 2016/11/19 13:48:19 ist424870 Exp $ */
package pex.app.evaluator;

import pex.Manager;
import pex.operators.Program;
import pt.tecnico.po.ui.Command;
import pex.Interpreter;

/**
 * Commands for programs.
 */
public abstract class ProgramCommand extends Command<Program> {
  /** The context of the program. */
  protected Interpreter _interpreter;
  
  /**
   * @param label 
   * @param interpreter
   * @param receiver
   */
  public ProgramCommand(String label, Interpreter interpreter, Program receiver) {
    super(label, receiver);
    _interpreter = interpreter;
  }

}

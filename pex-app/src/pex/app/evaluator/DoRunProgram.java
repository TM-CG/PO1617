/** @version $Id: DoRunProgram.java,v 1.5 2016/12/09 00:24:03 ist424870 Exp $ */
package pex.app.evaluator;

import pex.operators.Program;
import pex.Interpreter;
import pex.app.EvaluatorVisitor;

/**
 * Run program.
 */
public class DoRunProgram extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoRunProgram(Interpreter interpreter, Program receiver) {
    super(Label.RUN_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute(){
    _interpreter.runProgram(_receiver, new EvaluatorVisitor(_interpreter));
  }

}

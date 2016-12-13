/** @version $Id: DoShowProgram.java,v 1.5 2016/12/09 00:24:03 ist424870 Exp $ */
package pex.app.evaluator;

//FIXME import core classes
import pex.Interpreter;
import pex.operators.Program;
import pex.app.ToStringVisitor;
/**
 * Show program (present code).
 */
public class DoShowProgram extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowProgram(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute(){
	   _display.popup((String) _receiver.accept(new ToStringVisitor()).getValue());
  }

}

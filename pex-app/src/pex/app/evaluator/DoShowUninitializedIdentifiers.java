/** @version $Id: DoShowUninitializedIdentifiers.java,v 1.3 2016/12/09 02:04:41 ist424870 Exp $ */
package pex.app.evaluator;

import pex.operators.Program;
import pex.Interpreter;
import pex.app.UninitIdentifierVisitor;
/**
 * Show uninitialized identifiers.
 */
public class DoShowUninitializedIdentifiers extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowUninitializedIdentifiers(Interpreter interpreter, Program receiver) {
    super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
      UninitIdentifierVisitor visitor = new UninitIdentifierVisitor();
      _receiver.accept(visitor);
      String identifiers = "";
      for(String s: visitor.getIdentifiers())
        identifiers+= s + "\n";
      _display.popup(identifiers);
  }
}

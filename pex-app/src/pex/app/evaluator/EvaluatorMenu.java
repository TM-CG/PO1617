/** @version $Id: EvaluatorMenu.java,v 1.2 2016/11/19 13:48:19 ist424870 Exp $ */
package pex.app.evaluator;

import pex.Interpreter;
import pex.operators.Program;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

/**
 * Menu for program manipulation.
 */
public class EvaluatorMenu extends Menu {

  /**
   * @param interpreter 
   * @param receiver
   */
  public EvaluatorMenu(Interpreter interpreter, Program receiver) {
    super(Label.TITLE,
        new Command<?>[] { //
            new DoShowProgram(interpreter, receiver), //
            new DoRunProgram(interpreter, receiver), //
            new DoAddExpression(interpreter, receiver), //
            new DoReplaceExpression(interpreter, receiver), //
            new DoShowAllIdentifiers(interpreter, receiver), //
            new DoShowUninitializedIdentifiers(interpreter, receiver), //
        });
  }

}

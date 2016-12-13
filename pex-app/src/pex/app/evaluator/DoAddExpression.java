/** @version $Id: DoAddExpression.java,v 1.3 2016/12/09 00:58:42 ist424870 Exp $ */
package pex.app.evaluator;

import pex.Interpreter;
import pex.app.BadExpressionException;
import pex.app.BadPositionException;
import pex.operators.Program;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pex.ParserException;
import pex.exceptions.BadNumberException;
import pex.app.BadPositionException;
import pex.app.BadExpressionException;
import pex.Expression;

/**
 * Add expression.
 */
public class DoAddExpression extends ProgramCommand {
  /** Input field. */
  Input<Integer> _position;

  /** Input field. */
  Input<String> _description;

  /**
   * @param interpreter
   * @param receiver
   */
  public DoAddExpression(Interpreter interpreter, Program receiver) {
    super(Label.ADD_EXPRESSION, interpreter, receiver);
    _position = _form.addIntegerInput(Message.requestPosition());
    _description = _form.addStringInput(Message.requestExpression());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try{
      Expression expression = _interpreter.parse(_description.value());
      _receiver.addExpression(_position.value(), expression);
    }catch(BadNumberException e){
      throw new BadPositionException(_position.value());
    }catch(ParserException e){
      throw new BadExpressionException(_description.value());
    }
  }
}

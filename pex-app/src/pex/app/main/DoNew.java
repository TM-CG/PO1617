/** @version $Id: DoNew.java,v 1.7 2016/12/08 17:57:40 ist424870 Exp $ */
package pex.app.main;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.DialogException;


/**
 * Open a new interpreter.
 */
public class DoNew extends Command<Manager> {
  /** Input field. */
  Input<Boolean> _shouldSave;

  /**
   * @param receiver
   */
  public DoNew(Manager receiver) {
    super(Label.NEW, receiver);
    _shouldSave = _form.addBooleanInput(Message.saveBeforeExit());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
	   _receiver.doNewInterpreter();
  }
}

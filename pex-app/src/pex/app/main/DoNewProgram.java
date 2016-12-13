/** @version $Id: DoNewProgram.java,v 1.3 2016/11/21 04:06:55 ist424870 Exp $ */
package pex.app.main;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Create new program.
 */
public class DoNewProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _programName;

  /**
   * @param receiver
   */
  public DoNewProgram(Manager receiver) {
    super(Label.NEW_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
	_form.parse();  
	_receiver.doNewProgram(_programName.value());
  //FIXME implement
  }

}

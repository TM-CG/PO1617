/** @version $Id: DoManageProgram.java,v 1.3 2016/11/21 05:23:24 ist424870 Exp $ */
package pex.app.main;

import pex.Manager;
import pex.app.evaluator.EvaluatorMenu;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Menu;
import pex.exceptions.ProgramNotFoundException;

/**
 * Open menu for managing programs.
 */
public class DoManageProgram extends Command<Manager> {
	/** Input field. */
	Input<String> _program;

	/**
	 * @param receiver
	 */
	public DoManageProgram(Manager receiver) {
		super(Label.MANAGE_PROGRAM, receiver);
		_program = _form.addStringInput(Message.requestProgramId());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
		public final void execute() {
			_form.parse();
			try{
				EvaluatorMenu menu = new EvaluatorMenu(_receiver.getInterpreter(), _receiver.doManageProgram(_program.value()));
				menu.open(); 
			}catch(ProgramNotFoundException e){
				_display.popup(Message.noSuchProgram(_program.value()));
			}	
						//FIXME implement
		}
}

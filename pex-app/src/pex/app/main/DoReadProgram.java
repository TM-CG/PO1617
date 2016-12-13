/** @version $Id: DoReadProgram.java,v 1.5 2016/12/08 17:57:40 ist424870 Exp $ */
package pex.app.main;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import java.io.IOException;
import java.io.FileNotFoundException;
import pex.app.BadFileException;
import pex.ParserException;

/**
 * Read existing program.
 */
public class DoReadProgram extends Command<Manager> {
	/** Input field. */
	Input<String> _filename;

	/**
	 * @param receiver
	 */
	public DoReadProgram(Manager receiver) {
		super(Label.READ_PROGRAM, receiver);
		_filename = _form.addStringInput(Message.programFileName());
	}

	/** @see pt.tecnico.po.ui.Command#execute()
	 * @throws BadFileException
	 */
	@Override
		public final void execute() throws BadFileException{
			_form.parse();
			try{
				_receiver.doReadProgram(_filename.value());
			}catch(ParserException e){throw new BadFileException(_filename.value());}
		}

}

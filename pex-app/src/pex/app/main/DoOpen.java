/** @version $Id: DoOpen.java,v 1.5 2016/11/21 04:06:55 ist424870 Exp $ */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Open existing interpreter.
 */
public class DoOpen extends Command<Manager> {
	/** Input field. */
	Input<String> _filename;

	/**
	 * @param receiver
	 */
	public DoOpen(Manager receiver) {
		super(Label.OPEN, receiver);
		_filename = _form.addStringInput(Message.openFile());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
		public final void execute() {
			_form.parse();
			try{
				_receiver.openInterpreter(_filename.value());
			}catch(FileNotFoundException e){
				_display.popup(Message.fileNotFound());		
			}catch(IOException e){
			}catch(ClassNotFoundException e){}
		}
}

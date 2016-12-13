/** @version $Id: DoSave.java,v 1.5 2016/11/21 08:03:31 ist424870 Exp $ */
package pex.app.main;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<Manager> {
	/** Input field. */
	Input<String> _filename;

	/**
	 * @param receiver
	 */
	public DoSave(Manager receiver) {
		super(Label.SAVE, receiver);
		_filename = _form.addStringInput(Message.newSaveAs());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
		public final void execute(){
			try{
				if(_receiver.getInterpreter()!=null && _receiver.validName())
					_receiver.save();
				else{
					_form.parse();
					_receiver.save(_filename.value());
				}
			}catch(IOException e){}
		}
}	

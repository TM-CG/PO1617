/** @version $Id: DoWriteProgram.java,v 1.7 2016/12/09 00:24:03 ist424870 Exp $ */
package pex.app.main;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pex.exceptions.ProgramNotFoundException;
import java.io.IOException;
import pex.app.ToStringVisitor;

/**
 * Write (save) program to file.
 */
public class DoWriteProgram extends Command<Manager> {
  /** Input field. */
  Input<String> _programName;
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoWriteProgram(Manager receiver) {
    super(Label.WRITE_PROGRAM, receiver);
    _programName = _form.addStringInput(Message.requestProgramId());
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
  	_form.parse();
  	try{
  		_receiver.doWriteProgram(_programName.value(), _filename.value(), new ToStringVisitor());
      	}catch(ProgramNotFoundException e){
  		      _display.popup(Message.noSuchProgram(_programName.value()));
  	    }catch(IOException e){e.printStackTrace();}
    }
}

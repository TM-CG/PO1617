package pex;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import pex.operators.Program;
import pex.exceptions.ProgramNotFoundException;

public class Manager{
	private Interpreter _currentInterpreter;
//	private boolean _unsaved = true;
	private String _filename;


	public Manager(){
		_currentInterpreter = new Interpreter();
		_filename = "";
	}

//	public boolean isUnsaved(){ return _unsaved;}

	public boolean validName(){
		return (!_filename.equals(""));
	}

	public Interpreter getInterpreter(){
		return _currentInterpreter;
	}

	public void doNewInterpreter(){
		_currentInterpreter = new Interpreter();
		_filename = "";
	//	_unsaved = true;
	}

	public void openInterpreter(String name) throws IOException, ClassNotFoundException{
		_filename = name;
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(_filename)));
		_currentInterpreter = (Interpreter) ois.readObject();
		ois.close();
	//	_unsaved = true;
	}


	public void save(String name) throws IOException{
		if(!name.equals("")){
			_filename = name;
			save();
		}
	}

	public void save() throws IOException{
		if(_currentInterpreter != null ){
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_filename)));
			oos.writeObject(_currentInterpreter);
			oos.close();
//			_unsaved = false;
		}
	}

	public void doNewProgram(String programName){
		_currentInterpreter.newProgram(programName);
//		_unsaved = true;
	}

	public void doReadProgram(String programName) throws ParserException{
		_currentInterpreter.readProgram(programName);
//		_unsaved = true;
	}

  public void doReadProgram(String programName, String file) throws ParserException{
		_currentInterpreter.readProgram(programName, file);
//              _unsaved = true;
        }

	public void doWriteProgram(String programName, String programFileName, Visitor visitor) throws IOException, ProgramNotFoundException{
		_currentInterpreter.writeProgram(programName, programFileName, visitor);
//		_unsaved = true;
	}

	public Program doManageProgram(String programName) throws ProgramNotFoundException{
		return _currentInterpreter.manageProgram(programName);

	}
}

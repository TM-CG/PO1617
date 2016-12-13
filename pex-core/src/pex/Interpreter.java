package pex;

import java.io.Serializable;
import java.util.HashMap;
import java.io.FileNotFoundException;
import pex.operators.Program;
import pex.exceptions.ExtraneousDataAtEndOfInputException;
import pex.exceptions.EndOfInputException;
import pex.exceptions.MissingClosingParenthesisException;
import pex.exceptions.UnknownOperationException;
import pex.exceptions.BadNumberException;
import pex.exceptions.BadExpressionException;
import pex.exceptions.ProgramNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import pex.atomic.StringLiteral;
import pex.Visitor;
import pex.atomic.Identifier;
import pex.atomic.IntegerLiteral;

/**
 * An expressions can be evaluated to produce a value.
 */
public class Interpreter implements Serializable {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 201608281352L;
	private Parser _parser ;
	private HashMap<String, Program> _programs;
	private HashMap<String, Value<?>> _identifiers;

	public Interpreter(){
		_parser = new Parser();
		_programs = new HashMap<String, Program>();
		_identifiers = new HashMap<String, Value<?>>();
	}

	public Value<?> getIdentifier(Identifier identifier){
		if(!_identifiers.containsKey(identifier.getName()))
			_identifiers.put(identifier.getName(), new IntegerLiteral(0));
		return _identifiers.get(identifier.getName());
	}

	public void setIdentifier(Identifier identifier, Value<?> value){
		_identifiers.put(identifier.getName(), value);
	}

	public Expression parse(String description) throws ParserException{
		return _parser.parse(description);
	}

	public void newProgram(String programName){
		Program _program = new Program();
		_programs.put(programName, _program);
	}

	public void readProgram(String programFileName) throws ParserException{
		try{
			Program _program = _parser.parseProgramFile(programFileName);
			_programs.put(programFileName, _program);
	  }catch(ExtraneousDataAtEndOfInputException e){
	 	 throw new ParserException();
	  }catch(EndOfInputException e){
	 	 throw new ParserException();
	  }catch(MissingClosingParenthesisException e){
	 	 throw new ParserException();
	  }catch(UnknownOperationException e){
	 	 throw new ParserException();
	  }catch(BadNumberException e){
	 	 throw new ParserException();
	  }catch(BadExpressionException e){
	 	 throw new ParserException();
	  }
	 }

	 public void readProgram(String programFileName, String file) throws
	  ParserException{
   	try{
    	Program _program = _parser.parseProgramFile(file);
      _programs.put(programFileName, _program);
  	 }catch(ExtraneousDataAtEndOfInputException e){
			 throw new ParserException();
	   }catch(EndOfInputException e){
			 throw new ParserException();
	   }catch(MissingClosingParenthesisException e){
			 throw new ParserException();
	   }catch(UnknownOperationException e){
			 throw new ParserException();
	   }catch(BadNumberException e){
			 throw new ParserException();
	   }catch(BadExpressionException e){
			 throw new ParserException();
		 }
	}

	public Program getProgram(String programName){
		return _programs.get(programName);
	}


	public void writeProgram(String programName, String programFileName,
	Visitor visitor) throws IOException, ProgramNotFoundException{
		if(_programs.containsKey(programName) == false){
				throw new ProgramNotFoundException();
			}
		else{
			Program program = _programs.get(programName);
			PrintWriter pw = new PrintWriter(new FileWriter(programFileName));
			pw.write((String) program.accept(visitor).getValue());
			pw.close();
		}
}

	public Program manageProgram(String programName) throws
	 ProgramNotFoundException{
			if(_programs.containsKey(programName) == false){ throw new
				ProgramNotFoundException();}
			else{
				return  _programs.get(programName);
				}
			}

	 public Value<?> runProgram(Program programName, Visitor vst){
		 return programName.accept(vst);
	 }
}

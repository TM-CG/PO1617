/* $Id: ParserException.java,v 1.1 2016/10/14 18:13:10 david Exp $ */
package pex;

import pex.exceptions.InterpreterException;

/**
 * Class for representing a syntax error problem.
 */
public class ParserException extends InterpreterException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608241029L;

  /**
   * Default constructor
   */
  public ParserException() {
    // do nothing
  }

  /**
   * @param description
   */
  public ParserException(String description) {
    super(description);
  }

  /**
   * @param cause
   */
  public ParserException(Exception cause) {
    super(cause);
  }

}

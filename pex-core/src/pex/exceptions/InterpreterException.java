/* $Id: InterpreterException.java,v 1.1 2016/10/14 18:13:10 david Exp $ */
package pex.exceptions;

/**
 * Class for representing a syntax error problem.
 */
public class InterpreterException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608241029L;

  /**
   * Default constructor
   */
  public InterpreterException() {
    // do nothing
  }

  /**
   * @param description
   */
  public InterpreterException(String description) {
    super(description);
  }

  /**
   * @param cause
   */
  public InterpreterException(Exception cause) {
    super(cause);
  }

}

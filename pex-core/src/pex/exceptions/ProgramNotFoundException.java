package pex.exceptions;

/**
 * Class for representing a syntax error problem.
 */
public class ProgramNotFoundException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608241029L;

  /**
   * Default constructor
   */
  public ProgramNotFoundException() {
    // do nothing
  }

  /**
   * @param description
   */
  public ProgramNotFoundException(String description) {
    super(description);
  }

  /**
   * @param cause
   */
  public ProgramNotFoundException(Exception cause) {
    super(cause);
  }

}

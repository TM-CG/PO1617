/* $Id: UnknownOperationException.java,v 1.1 2016/10/14 18:13:10 david Exp $ */
package pex.exceptions;

import pex.ParserException;

/**
 * Exception for representing unknown operation errors.
 */
public class UnknownOperationException extends ParserException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608241029L;

  /** Original literal expression description. */
  String _description;

  /**
   * @param description
   */
  public UnknownOperationException(String description) {
    _description = description;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return _description;
  }

}

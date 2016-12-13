/* $Id: BadFileException.java,v 1.1 2016/11/21 10:42:18 ist424870 Exp $ */
package pex.app;

import pt.tecnico.po.ui.DialogException;

/**
 * Exception for representing problems in interpreting a program file.
 */
@SuppressWarnings("nls")
public class BadFileException extends DialogException {
  
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608241029L;
  
  /** Original leaf expression. */
  String _description;

  /**
   * @param description
   */
  public BadFileException(String description) {
    _description = description;
  }
  
  /**
   * @return the description
   */
  public String getDescription() {
    return _description;
  }

  /** @see pt.tecnico.po.ui.DialogException#getMessage() */
  @Override
  public String getMessage() {
    return "Problemas no ficheiro: " + _description;
  }
  
}

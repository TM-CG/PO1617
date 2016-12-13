/* $Id: BadPositionException.java,v 1.1 2016/10/14 18:13:09 david Exp $ */
package pex.app;

import pt.tecnico.po.ui.DialogException;

/**
 * Exception for representing format errors.
 */
@SuppressWarnings("nls")
public class BadPositionException extends DialogException {
  
  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608241029L;
  
  /** Original leaf expression. */
  int _position;

  /**
   * @param position
   */
  public BadPositionException(int position) {
    _position = position;
  }
  
  /**
   * @return the position
   */
  public int getPosition() {
    return _position;
  }

  /** @see pt.tecnico.po.ui.DialogException#getMessage() */
  @Override
  public String getMessage() {
    return "Posição inválida: " + _position;
  }
  
}

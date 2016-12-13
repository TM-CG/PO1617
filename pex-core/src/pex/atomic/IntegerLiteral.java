/* $Id: IntegerLiteral.java,v 1.4 2016/12/09 00:24:03 ist424870 Exp $ */
package pex.atomic;

import pex.Value;
import pex.Visitor;

/**
 * Class for describing syntactic tree leaves for holding integer values.
 */
public class IntegerLiteral extends Value<Integer> {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param value
   */
  public IntegerLiteral(int value) {
    super(value);
  }

  public Value<?> accept(Visitor vst){
    return vst.visitIntegerLiteral(this);
  }
}

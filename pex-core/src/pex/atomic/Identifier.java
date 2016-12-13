/* $Id: Identifier.java,v 1.3 2016/12/08 12:26:29 ist424870 Exp $ */
package pex.atomic;

import pex.Expression;
import pex.Value;
import pex.Visitor;

/**
 * Class for describing syntactic tree leaves for holding identifier values.
 */
public class Identifier extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** Identifier name. */
  private String _name;

  /**
   * @param name
   */
  public Identifier(String name) {
    _name = name;
  }

  /**
   * @return the name
   */
  public String getName() {
    return _name;
  }

  @Override
  public String toString(){
    return _name;
  }

  public Value<?> accept(Visitor vst){
    return vst.visitIdentifier(this);
  }
}

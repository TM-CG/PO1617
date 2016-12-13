/* $Id: Not.java,v 1.1 2016/10/14 18:13:10 david Exp $ */
package pex.operators;

import pex.Expression;

/**
 * Class for describing the negation operator
 */
public class Not extends UnaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param argument
   */
  public Not(Expression argument) {
    super(argument);
  }

  //FIXME (possibly) add other methods: e.g. accept, toString, etc.

}

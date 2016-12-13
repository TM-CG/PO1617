/* $Id: Add.java,v 1.1 2016/10/14 18:13:10 david Exp $ */
package pex.operators;

import pex.Expression;

/**
 * Class for describing the sum ('+') operator
 */
public class Add extends BinaryExpression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /**
   * @param first
   * @param second
   */
  public Add(Expression first, Expression second) {
    super(first, second);
  }

  //FIXME (possibly) add other methods: e.g. accept, toString, etc.
}

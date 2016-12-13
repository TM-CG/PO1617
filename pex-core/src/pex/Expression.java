/* $Id: Expression.java,v 1.3 2016/12/08 17:57:40 ist424870 Exp $ */
package pex;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
/**
 * An expressions can be evaluated to produce a value.
 */
public abstract class Expression implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  public abstract String toString();

  public abstract Value<?> accept(Visitor vst);
}

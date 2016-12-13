package pex;

import pex.atomic.StringLiteral;
import pex.operators.Add;
import pex.operators.Mul;
import pex.operators.Not;
import pex.operators.Program;
import pex.operators.Sequence;
import pex.operators.And;
import pex.operators.Div;
import pex.operators.Eq;
import pex.operators.Ge;
import pex.operators.Gt;
import pex.operators.Le;
import pex.operators.Lt;
import pex.operators.Mod;
import pex.operators.Ne;
import pex.operators.Or;
import pex.operators.Set;
import pex.operators.Sub;
import pex.operators.Print;
import pex.operators.If;
import pex.operators.While;
import pex.operators.Call;
import pex.operators.Reads;
import pex.operators.Readi;
import pex.operators.Neg;
import pex.atomic.Identifier;
import pex.atomic.IntegerLiteral;
import pex.atomic.StringLiteral;
import pex.Value;

/**
 * Responsavel por avaliar o valor de uma expressao
 */

public class EvaluatorVisitor extends Visitor{
  public Value<?> visitAdd(Add add){
    return new IntegerLiteral((Integer) add.first().accept(this).getValue()+ (Integer) add.second().accept(this).getValue());
  }

  public Value<?> visitMul(Mul mul){
    return new IntegerLiteral((Integer) mul.first().accept(this).getValue() * (Integer) mul.second().accept(this).getValue());
  }

  public Value<?> visitNot(Not not){
    int valor = (Integer) not.argument().accept(this).getValue();
    if (valor == 0)
      return new IntegerLiteral(1);
    return new IntegerLiteral(0);
  }

  public Value<?> visitProgram(Program program){}

  public Value<?> visitSequence(Sequence sequence){}

  public Value<?> visitAnd(And and){
    if((Integer) and.first().accept(this).getValue() == 0)
      return new IntegerLiteral(0);
    if((Integer) and.second().accept(this).getValue() == 0)
      return new IntegerLiteral(0);
    return new IntegerLiteral(1);
  }

  public Value<?> visitDiv(Div div){
    return new IntegerLiteral((Integer) div.first().accept(this).getValue() / (Integer) div.second().accept(this).getValue());
  }

  public Value<?> visitEq(Eq eq){
    if((Integer) eq.first().accept(this).getValue() == (Integer) eq.second().accept(this).getValue())
      return new IntegerLiteral(1);
    return new IntegerLiteral(0);
  }

  public Value<?> visitGe(Ge ge){
    if((Integer) ge.first().accept(this).getValue() >= (Integer) ge.second().accept(this).getValue())
      return new IntegerLiteral(1);
    return new IntegerLiteral(0);
    }

  public Value<?> visitGt(Gt gt){
    if((Integer) gt.first().accept(this).getValue() > (Integer) gt.second().accept(this).getValue())
      return new IntegerLiteral(1);
    return new IntegerLiteral(0);
  }

  public Value<?> visitLe(Le le){
    if((Integer) le.first().accept(this).getValue() <= (Integer) le.second().accept(this).getValue())
      return new IntegerLiteral(1);
    return new IntegerLiteral(0);
  }

  public Value<?> visitLt(Lt lt){
    if((Integer) lt.first().accept(this).getValue() < (Integer) lt.second().accept(this).getValue())
      return new IntegerLiteral(1);
    return new IntegerLiteral(0);
  }

  public Value<?> visitMod(Mod mod){
    return new IntegerLiteral(abs((Integer) mod.argument().accept(this).getValue()));
  }

  public Value<?> visitNe(Ne ne){}

  public Value<?> visitOr(Or or){}

  public Value<?> visitSet(Set set){}

  public Value<?> visitSub(Sub sub){
    return new IntegerLiteral((Integer) sub.first().accept(this).getValue() - (Integer) sub.second().accept(this).getValue());
  }

  public Value<?> visitPrint(Print print){}

  public Value<?> visitIf(If i){}

  public Value<?> visitWhile(While wh){}

  public Value<?> visitCall(Call call){}

  public Value<?> visitReads(Reads reads){}

  public Value<?> visitReadi(Readi readi){}

  public Value<?> visitNeg(Neg neg){}

  public Value<?> visitIdentifier(Identifier identifier){}

  public Value<Integer> visitIntegerLiteral(IntegerLiteral integer){}

  public Value<?> visitStringLiteral(StringLiteral string){}


}

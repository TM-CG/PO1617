package pex.app;

import pex.Interpreter;
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
import pex.Visitor;
import pex.Expression;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Responsavel por encontrar todos os identificadores
 */

public class UninitIdentifierVisitor extends Visitor{
  private ArrayList<String> _identifiers;
  private ArrayList<String> _sets ;

  public UninitIdentifierVisitor(){
    super();
    _identifiers = new ArrayList<String>();
    _sets = new ArrayList<String>();
  }

  public ArrayList<String> getIdentifiers(){
    Collections.sort(_identifiers);
    return _identifiers;
  }

  public Value<?> visitAdd(Add add){
    add.first().accept(this);
    add.second().accept(this);
    return null;
  }

  public Value<?> visitMul(Mul mul){
    mul.first().accept(this);
    mul.second().accept(this);
    return null;
  }

  public Value<?> visitNot(Not not){
    not.argument().accept(this);
    return null;
  }

  public Value<?> visitProgram(Program program){
    for(Expression e: program.getProgram())
      e.accept(this);
    for(String s : _sets)
      _identifiers.remove(s);
    return null;
  }


  public Value<?> visitSequence(Sequence sequence){
    for(Expression e: sequence.getAll())
      e.accept(this);
    return null;
  }

  public Value<?> visitAnd(And and){
    and.first().accept(this);
    and.second().accept(this);
    return null;
  }

  public Value<?> visitDiv(Div div){
    div.first().accept(this);
    div.second().accept(this);
    return null;
  }

  public Value<?> visitEq(Eq eq){
    eq.first().accept(this);
    eq.second().accept(this);
    return null;
  }

  public Value<?> visitGe(Ge ge){
    ge.first().accept(this);
    ge.second().accept(this);
    return null;
  }

  public Value<?> visitGt(Gt gt){
    gt.first().accept(this);
    gt.second().accept(this);
    return null;
  }

  public Value<?> visitLe(Le le){
    le.first().accept(this);
    le.second().accept(this);
    return null;
  }

  public Value<?> visitLt(Lt lt){
    lt.first().accept(this);
    lt.second().accept(this);
    return null;
  }

  public Value<?> visitMod(Mod mod){
    mod.first().accept(this);
    mod.second().accept(this);
    return null;
  }

  public Value<?> visitNe(Ne ne){
    ne.first().accept(this);
    ne.second().accept(this);
    return null;
  }

  public Value<?> visitOr(Or or){
    or.first().accept(this);
    or.second().accept(this);
    return null;
  }

  public Value<?> visitSet(Set set){
    try{
      set.second().accept(this);
      _sets.add(((Identifier) set.first()).getName());
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitSub(Sub sub){
    sub.first().accept(this);
    sub.second().accept(this);
    return null;
  }

  public Value<?> visitPrint(Print print){
    for(Expression e: print.getAll()){
      e.accept(this);
    }
    return null;
  }

  public Value<?> visitIf(If i){
    i.first().accept(this);
    i.second().accept(this);
    i.third().accept(this);
    return null;
  }

  public Value<?> visitWhile(While wh){
    wh.first().accept(this);
    wh.second().accept(this);
    return null;
  }

  public Value<?> visitCall(Call call){
    call.argument().accept(this);
    return null;
  }

  public Value<?> visitReads(Reads reads){
    return null;
  }

  public Value<?> visitReadi(Readi readi){
    return null;
  }

  public Value<?> visitNeg(Neg neg){
    neg.argument().accept(this);
    return null;
  }

  public Value<?> visitIdentifier(Identifier identifier){
    if(!_identifiers.contains(identifier.getName()))
        _identifiers.add(identifier.getName());
    return null;
  }

  public Value<?> visitIntegerLiteral(IntegerLiteral integer){
    return null;
  }

  public Value<?> visitStringLiteral(StringLiteral string){
    return null;
  }
}

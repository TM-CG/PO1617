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
import pex.Parser;
import pex.Visitor;
import pex.Expression;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Form;
import pt.tecnico.po.ui.Display;

/**
 * Responsavel por avaliar o valor de uma expressao
 */

public class EvaluatorVisitor extends Visitor{
  private Interpreter _currentInterpreter;

  public EvaluatorVisitor(Interpreter interpreter){
    super();
    _currentInterpreter = interpreter;
    }

  public Value<?> visitAdd(Add add){
    try{
      Expression firstExpression = add.first();
      Expression secondExpression = add.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      return new IntegerLiteral(first.getValue() + second.getValue());
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitMul(Mul mul){
    try{
      Expression firstExpression = mul.first();
      Expression secondExpression = mul.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      return new IntegerLiteral(first.getValue() * second.getValue());
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitNot(Not not){
    try{
      Expression argument = not.argument();
      IntegerLiteral valor = (IntegerLiteral) argument.accept(this);
      if (valor.getValue() == 0)
        return new IntegerLiteral(1);
      return new IntegerLiteral(0);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitProgram(Program program){
    Value<?> programValue = new IntegerLiteral(0);
    for(Expression e: program.getProgram())
      programValue = e.accept(this);
    return programValue;
  }

  public Value<?> visitSequence(Sequence sequence){
    Value<?> seq = new IntegerLiteral(0);
    for(Expression e: sequence.getAll())
      seq = e.accept(this);
    return seq;
  }

  public Value<?> visitAnd(And and){
    try{
      Expression firstExpression = and.first();
      Expression secondExpression = and.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      if(first.getValue() == 0)
        return new IntegerLiteral(0);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      if(second.getValue() == 0)
        return new IntegerLiteral(0);
      return new IntegerLiteral(1);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitDiv(Div div){
    try{
      Expression firstExpression = div.first();
      Expression secondExpression = div.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      return new IntegerLiteral(first.getValue() / second.getValue());
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitEq(Eq eq){
    try{
      Expression firstExpression = eq.first();
      Expression secondExpression = eq.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      if(first.getValue() == second.getValue())
        return new IntegerLiteral(1);
      return new IntegerLiteral(0);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitGe(Ge ge){
    try{
      Expression firstExpression = ge.first();
      Expression secondExpression = ge.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      if(first.getValue() >= second.getValue())
        return new IntegerLiteral(1);
      return new IntegerLiteral(0);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

    public Value<?> visitGt(Gt gt){
      try{
        Expression firstExpression = gt.first();
        Expression secondExpression = gt.second();
        IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
        IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
        if(first.getValue() > second.getValue())
          return new IntegerLiteral(1);
        return new IntegerLiteral(0);
      }catch(ClassCastException e){
        e.printStackTrace();
      }
      return null;
    }

  public Value<?> visitLe(Le le){
    try{
      Expression firstExpression = le.first();
      Expression secondExpression = le.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      if(first.getValue() <= second.getValue())
        return new IntegerLiteral(1);
      return new IntegerLiteral(0);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitLt(Lt lt){
    try{
      Expression firstExpression = lt.first();
      Expression secondExpression = lt.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      if(first.getValue() < second.getValue())
        return new IntegerLiteral(1);
      return new IntegerLiteral(0);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitMod(Mod mod){
    try{
      Expression firstExpression = mod.first();
      Expression secondExpression = mod.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      return new IntegerLiteral(first.getValue() % second.getValue());
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitNe(Ne ne){
    try{
      Expression firstExpression = ne.first();
      Expression secondExpression = ne.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      if(first.getValue() == second.getValue())
        return new IntegerLiteral(0);
      return new IntegerLiteral(1);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitOr(Or or){
    try{
      Expression firstExpression = or.first();
      Expression secondExpression = or.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      if(first.getValue() != 0)
        return new IntegerLiteral(1);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      if(second.getValue() != 0)
        return new IntegerLiteral(1);
      return new IntegerLiteral(0);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitSet(Set set){
    try{
      Expression secondExpression = set.second();
      Identifier identifier = (Identifier) set.first();
      Value<?> value = secondExpression.accept(this);
      _currentInterpreter.setIdentifier(identifier, value);
      return value;
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitSub(Sub sub){
    try{
      Expression firstExpression = sub.first();
      Expression secondExpression = sub.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      IntegerLiteral second = (IntegerLiteral) secondExpression.accept(this);
      return new IntegerLiteral(first.getValue() - second.getValue());
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitPrint(Print print){
    String toPrint = "";
    Value<?> valor = new IntegerLiteral(0);
    Display display = new Display();
    for(Expression e: print.getAll()){
      valor = e.accept(this);
      toPrint += valor.toString();
    }
    display.popup(toPrint + "\n");
    return valor;
  }

  public Value<?> visitIf(If i){ //Retificar ambos os casos
    try{
      Expression firstExpression = i.first();
      Expression secondExpression = i.second();
      Expression thirdExpression = i.third();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      if(first.getValue() != 0)
        return secondExpression.accept(this);
      return thirdExpression.accept(this);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitWhile(While wh){
    try{
      Expression firstExpression = wh.first();
      Expression secondExpression = wh.second();
      IntegerLiteral first = (IntegerLiteral) firstExpression.accept(this);
      Value<?> second;
      while(first.getValue() != 0){
        second = secondExpression.accept(this);
        first = (IntegerLiteral) firstExpression.accept(this);
      }
      return new IntegerLiteral(0);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitCall(Call call){
    try{
      Expression argument = call.argument();
      StringLiteral programLiteral = (StringLiteral) argument.accept(this);
      String programName = programLiteral.getValue();
      Program newProgram = _currentInterpreter.getProgram(programName);
      return newProgram.accept(this);
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitReads(Reads reads){
    Form form = new Form();
    Input<String> newString = form.addStringInput("");
    form.parse();
    return new StringLiteral(newString.value());
  }

  public Value<?> visitReadi(Readi readi){
    Form form = new Form();
    Input<Integer> newInteger = form.addIntegerInput("");
    form.parse();
    return new IntegerLiteral(newInteger.value());
  }

  public Value<?> visitNeg(Neg neg){
    try{
      Expression argument = neg.argument();
      IntegerLiteral valor = (IntegerLiteral) argument.accept(this);
      return new IntegerLiteral(-(valor.getValue()));
    }catch(ClassCastException e){
      e.printStackTrace();
    }
    return null;
  }

  public Value<?> visitIdentifier(Identifier identifier){
    return _currentInterpreter.getIdentifier(identifier);
  }

  public Value<?> visitIntegerLiteral(IntegerLiteral integer){
    return integer;
  }

  public Value<?> visitStringLiteral(StringLiteral string){
    return string;
  }
}

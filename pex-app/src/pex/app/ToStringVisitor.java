package pex.app;

import pex.Value;
import pex.Visitor;
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
import pex.Expression;

/**
 * Responsavel por obter a forma de string de uma expressao
 */

public class ToStringVisitor extends Visitor{

	public Value<String> visitAdd(Add add){
		return new StringLiteral("(add " + add.first().accept(this) + " " +
		add.second().accept(this) + ")");
	}

	public Value<String> visitMul(Mul mul){
		return new StringLiteral("(mul " + mul.first().accept(this) + " " +
		mul.second().accept(this) + ")");
	}

	public  Value<String> visitNot(Not not){
		return new StringLiteral("(not " + not.argument().accept(this) + ")");
	}

  public  Value<String> visitProgram(Program program){
		String string = "";
		for(Expression e: program.getProgram()){
			string += e.accept(this) + "\n";
		}
		return new StringLiteral(string);
	}

  public  Value<String> visitSequence(Sequence sequence){
		String string = "(seq";
		for(Expression e: sequence.getAll()){
			string += " " + e.accept(this);
		}
		return new StringLiteral(string + ")");
	}

  public  Value<String> visitAnd(And and){
		return new StringLiteral("(and " + and.first().accept(this) + " " +
		and.second().accept(this) + ")");
	}

	public  Value<String> visitDiv(Div div){
		return new StringLiteral("(div " + div.first().accept(this) + " "
		 + div.second().accept(this) + ")");
	}

  public  Value<String> visitEq(Eq eq){
		return new StringLiteral("(eq " + eq.first().accept(this) + " " +
		 eq.second().accept(this) + ")");
	}

  public  Value<String> visitGe(Ge ge){
		return new StringLiteral("(ge " + ge.first().accept(this) + " " +
		ge.second().accept(this) + ")");
	}

  public  Value<String> visitGt(Gt gt){
		return new StringLiteral("(gt " + gt.first().accept(this) +
		" " + gt.second().accept(this) + ")");
	}

  public  Value<String> visitLe(Le le){
		return new StringLiteral("(le " + le.first().accept(this) + " "
		+ le.second().accept(this) + ")");
	}

  public  Value<String> visitLt(Lt lt){
		return new StringLiteral("(lt " + lt.first().accept(this) + " "
		+ lt.second().accept(this) + ")");
	}

  public  Value<String> visitMod(Mod mod){
		return new StringLiteral("(mod " + mod.first().accept(this) + " "
		+ mod.second().accept(this) + ")");
	}

  public  Value<String> visitNe(Ne ne){
		return new StringLiteral("(ne " + ne.first().accept(this) + " "
		+ ne.second().accept(this) + ")");
	}

	public  Value<String> visitOr(Or or){
		return new StringLiteral("(or " + or.first().accept(this) + " "
		+ or.second().accept(this) + ")");
	}

	public  Value<String> visitSet(Set set){
		return new StringLiteral("(set " + set.first().accept(this) + " "
		+ set.second().accept(this) + ")");
	}

	public  Value<String> visitSub(Sub sub){
		return new StringLiteral("(sub " + sub.first().accept(this) + " "
		+ sub.second().accept(this) + ")");
	}

	public  Value<String> visitPrint(Print print){
		String string = "(print";
		for(Expression e: print.getAll()){
			string += " " + e.accept(this);
		}
		return new StringLiteral(string + ")");
	}

	public  Value<String> visitIf(If i){
		return new StringLiteral("(if " + i.first().accept(this) + " " +
		i.second().accept(this) + " " + i.third().accept(this) + ")");
	}

	public  Value<String> visitWhile(While wh){
		return new StringLiteral("(while " + wh.first().accept(this) + " " +
		wh.second().accept(this) + ")");
	}

	public  Value<String> visitCall(Call call){
		return new StringLiteral(("(call " + call.argument().accept(this) + ")"));
	}

	public  Value<String> visitReads(Reads reads){
		return new StringLiteral("(reads)");
	}

	public  Value<String> visitReadi(Readi readi){
		return new StringLiteral("(readi)");
	}

	public  Value<String> visitNeg(Neg neg){
		return new StringLiteral("(neg " + neg.argument().accept(this) + ")");
	}

	public  Value<String> visitIdentifier(Identifier identifier){
		return new StringLiteral(identifier.getName());
	}

	public  Value<String> visitIntegerLiteral(IntegerLiteral integer){
		return new StringLiteral(integer.getValue().toString());
	}

	public 	Value<String> visitStringLiteral(StringLiteral string){
		return new StringLiteral("\"" + string.getValue() +  "\"");
	}
}

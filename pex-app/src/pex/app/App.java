/** @version $Id: App.java,v 1.4 2016/11/21 10:39:06 ist424870 Exp $ */
package pex.app;

import static pt.tecnico.po.ui.Dialog.IO;
import pex.Manager;
import pex.ParserException;
import pex.app.main.MainMenu;
import pt.tecnico.po.ui.Menu;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Manager receiver = new Manager();

		String datafile = System.getProperty("import"); //$NON-NLS-1$
		if (datafile != null) {
		   try{
		     receiver.doReadProgram("import",datafile);
		//FIXME read import file into core object (use Parser instance)
		} catch (ParserException e) {
		// no behavior described: just present the problem
		e.printStackTrace();
		}
		}
		Menu menu = new MainMenu(receiver);
		menu.open();

		IO.close();
	}

}

/** @version $Id: MainMenu.java,v 1.2 2016/11/19 13:48:19 ist424870 Exp $ */
package pex.app.main;

import pex.Manager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

/**
 * Menu builder.
 */
public class MainMenu extends Menu {

  /**
   * @param receiver
   */
  public MainMenu(Manager receiver) {
    super(Label.TITLE,
        new Command<?>[] { //
            new DoNew(receiver), //
            new DoOpen(receiver), //
            new DoSave(receiver), //
            new DoNewProgram(receiver), //
            new DoReadProgram(receiver), //
            new DoWriteProgram(receiver), //
            new DoManageProgram(receiver), //
        });
  }

}

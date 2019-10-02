package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuActionAdapter implements ActionListener{

    MenuActionAdapter(Windows windows){
        win = windows;
    }

    public void actionPerformed(ActionEvent actionevent){
        win.menuBar.menuEvent(actionevent);
    }

    Windows win;
}
package e2;

import java.awt.event.ActionListener;

import javax.swing.event.MouseInputListener;

public interface Logics {

    public void loss();

    public void setCellPrimaryAction(ActionListener al);
    
    public void setCellSecondaryAction(MouseInputListener m);

    public boolean isGameOver();

    
}

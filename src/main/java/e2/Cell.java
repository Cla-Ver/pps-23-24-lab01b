package e2;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface Cell {

    boolean hit();

    Pair<Integer, Integer> getPosition();

    boolean hasMine();

    boolean hasFlag();

    void setMine(boolean armed);

    void toggleFlag();

    void setPrimaryAction(ActionListener listener);

    void setSecondaryAction(MouseListener listener);

    void show();

    void hide();

    boolean isActive();

    void setCellText(String s);

    String getCellText();


}
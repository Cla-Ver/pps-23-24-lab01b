package e2;


import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class CellImpl extends JButton implements Cell{

    private final Pair<Integer, Integer> position;
    private boolean mine;
    private boolean flag;

    public CellImpl(Pair<Integer, Integer> position, boolean mine) {
        this.position = position;
        this.mine = mine;
    }

    @Override
    public boolean hit() {
        this.doClick();
        return mine;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return position;
    }
    
    @Override
    public boolean hasMine(){
        return mine;
    }

    @Override
    public void setMine(boolean armed){
        mine = armed;
    }

    @Override
    public boolean isActive() {
        return this.isEnabled();
    }

    @Override
    public void setPrimaryAction(ActionListener listener) {
        this.addActionListener(listener);
    }

    @Override
    public void setSecondaryAction(MouseListener listener) {

        this.addMouseListener(listener);
    }

    @Override
    public void show(){
        this.setEnabled(false);
        if(hasMine()){
            this.setText("*");
        }
    }

    public void hide(){
        /*this.setEnabled(false);
        if(hasMine()){
            this.setText("*");
        }*/
    }


    @Override
    public boolean hasFlag() {
        return flag;
    }

    @Override
    public void toggleFlag() {
        flag = !flag;
        if(flag && this.isActive()){
            this.setText("F");
        }
        else {
            this.setText("");
        }
    }

    @Override
    public void setCellText(String s) {
        this.setText(s);
        System.out.println(this.getText());
    }

    @Override
    public String getCellText(){
        return this.getText();
    }

}

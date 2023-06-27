/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author quentinlaporte-chabasse
 */
public class PlayersView extends JPanel{
    
    //Model
    private Game currentGame;
    //Buttons
    
    private JButton begin;
    
    //Add player and plyers list management
    private PlayerListPanel pListPanel;
    
    //Manage the dice 
    private JPanel top = new JPanel();
    private DicePanel dicePanel;
    
    public PlayersView(Game currentGame, BoardView bv) {
        
        //links the Model
        this.currentGame = currentGame;
        
        this.pListPanel = new PlayerListPanel(currentGame);
        //dice panel
        this.dicePanel = new DicePanel(currentGame);
        //Import icon
        ImageIcon runIcon = new ImageIcon("ressources/run.png");
        
        begin = new JButton(runIcon);
        //Top panel which contains dice panel and start button
        this.top.setLayout(new BorderLayout());
        this.top.add(begin, BorderLayout.NORTH);
        this.top.add(dicePanel, BorderLayout.CENTER);
        
        this.begin.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               if(currentGame.getNumberofPlayers() >= 1){
                   pListPanel.playerButtonsEnable(false);
                   bv.paintPlayers(); 
                   dicePanel.enableRollDice();
                   begin.setEnabled(false);
               }

           }
       
       });
        
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        this.add(pListPanel, BorderLayout.CENTER);
        
    }
    
    
}

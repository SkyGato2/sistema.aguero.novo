/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author eduar
 */
public class telaDeFundo extends JDesktopPane {

    public Image imagem;
    
    public telaDeFundo (String imagem) {
        this.imagem = new ImageIcon(imagem).getImage();
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
    }
}


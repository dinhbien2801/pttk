/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import control.ManageController;
import view.Manager_View;

/**
 *
 * @author nguye
 */
public class Main {
    public static void main(String[] args) {
        Manager_View mv =new Manager_View();
        ManageController mvc = new ManageController(mv);
        mv.setVisible(true);
    }
}
 
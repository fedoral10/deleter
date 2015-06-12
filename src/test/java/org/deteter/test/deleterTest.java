/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.deteter.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.commons.io.FileDeleteStrategy;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/**
 *
 * @author Jorge Potosme
 */
public class deleterTest {

    ArrayList<File> lista;

    @Test
    public void delete() {
        lista = new ArrayList<>();
        //File dir = new File("C:\\Users\\JORGE_000\\Desktop\\nexus-oss");
        File dir = new File("c:\\abcdefghijklmnopqrssttuvwxyabcdefghijklmnopqrssttuvwxyabcdefghijklmnopqrssttuvwxyabcdefghijklmnopqrssttuvwxyabcdefghijklmnopqrssttuvwxyabcdefghijklmnopqrssttuvwxyabcdefghijklmnopqrssttuvwxyabcdefghijklmnopqrssttuvwxy");
        //FileUtils.deleteDirectory(dir);
        //FileUtils.deleteDirectory(dir);
        //FileDeleteStrategy.FORCE.delete(dir);
        agregar(dir);
        System.out.println(dir.isDirectory());
        /*for (File f : lista) {
            try {
                System.out.println(f.getCanonicalPath());
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }*/
        ListIterator<File> i = lista.listIterator(lista.size());
        try {
            while (i.hasPrevious()) {
                File f = i.previous();
                //f.delete();
                FileDeleteStrategy.FORCE.delete(f);
                //System.out.println(f.getCanonicalPath());
            }
            FileDeleteStrategy.FORCE.delete(dir);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void agregar(File li) {
        if (li.isDirectory()) {
            for (File f : li.listFiles()) {
                lista.add(f);
                agregar(f);
            }
        } else {
            lista.add(li);
        }
    }
}

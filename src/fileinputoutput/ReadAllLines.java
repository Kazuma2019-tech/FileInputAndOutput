/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileinputoutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * /**
 *
 * @author oladele
 */
public class ReadAllLines {

    public static void main(String[] args) {

        Path target = Paths.get("c:\\myfolder\\readAllLines.txt");
        List<String> lines;

        try {
            lines = Files.readAllLines(target);
            String output = "";

            for (String item : lines) {
                output += item + "\n";
            }
            System.out.println(output);

        } catch (Exception ex) {
            System.err.println(ex);

        }
    }
}

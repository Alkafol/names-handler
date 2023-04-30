package com.alkafol.nameshandler.ageproviders;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

@Component
@Order(1)
public class FileAgeProvider implements AgeProvider{
    @Override
    public short getAgeByName(String name) {
        String regex = "^[а-яА-ЯёЁ]+_[0-9]+$";
        Pattern pattern = Pattern.compile(regex);

        try (Scanner in = new Scanner(new File("name_age.txt"))) {
            while (in.hasNextLine()){
                String line = in.nextLine();
                if (!pattern.matcher(line).matches()){
                    continue;
                }

                String[] data = line.split("_");
                if (data[0].equals(name)){
                    return Short.parseShort(data[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return -1;
    }
}

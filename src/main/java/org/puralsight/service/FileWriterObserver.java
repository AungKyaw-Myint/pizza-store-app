package org.puralsight.service;

import org.puralsight.model.Order;

public class FileWriterObserver implements Observer{
    @Override
    public void update(Order order) {

        /*

        try (FileWriter writer =
                     new FileWriter("people.txt", true)) {

            writer.write(person.getName() + "\n");

            System.out.println("📂 Person saved to file.");

        } catch (IOException e) {

            e.printStackTrace();
        }

         */
    }
}

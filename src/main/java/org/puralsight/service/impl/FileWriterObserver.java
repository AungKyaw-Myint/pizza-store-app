package org.puralsight.service.impl;

import org.puralsight.model.Order;
import org.puralsight.service.Observer;

public class FileWriterObserver implements Observer {
    @Override
    public void update(Order order) {
        System.out.println(
                "📝 File writer observer: " + order.getDateTime()
        );
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

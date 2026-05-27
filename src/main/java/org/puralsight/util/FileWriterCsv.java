package org.puralsight.util;

import org.puralsight.model.Item;
import org.puralsight.model.Order;
import org.puralsight.service.FileWritable;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileWriterCsv {

    private static final Path FILE_PATH = Path.of("src", "main", "files");
    private static final String DELIMITER = "\\|";
    public static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
    public static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMdd");

    public void orderFileWriting(Order order) {
        Path fullPath =
                FILE_PATH.resolve("orders")
                        .resolve(order.getDateTime().format(DATE_FORMAT)+".txt");

        try (BufferedWriter writer = Files.newBufferedWriter(
                fullPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            // Format: date,time,description,vendor,amount

            /*
            if (isNewFile) {
                writer.write("date|time|description|vendor|amount");
                writer.newLine();
            }
             */
            String line =

                    order.getCustName() + "|" +
                    order.getDateTime().format(DATE_FORMAT) + "|" +
                    order.getTotalItems() + "|" +
                    order.calculateGrandTotal();

            writer.write(line);
            writer.newLine();

            System.out.println("Transaction saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public <T extends FileWritable> void writeItems(List<T> items, Order order) {
        Path fullPath =
                FILE_PATH.resolve("order-detail")
                        .resolve(order.getDateTime().format(DATE_TIME_FORMAT)+".txt");

        try (BufferedWriter writer = Files.newBufferedWriter(
                fullPath,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            for (T item : items) {
                writer.write(item.toFileString());
                writer.newLine();
            }

            System.out.println("Transaction saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

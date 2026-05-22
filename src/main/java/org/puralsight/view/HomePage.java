package org.puralsight.view;

import org.puralsight.util.Helpers;
import org.puralsight.view.enums.HomeViewOption;

import static org.puralsight.util.Helpers.displayFooter;
import static org.puralsight.util.Helpers.displayHeader;

public class HomePage {

    OrderPage orderPage= new OrderPage();

    public void starter(){

        HomeViewOption homeViewOption;
        do {
            displayHeader();
            displayHomeMenu();
            displayFooter();
            int choice = Helpers.readInt("Choose an option: ");
            homeViewOption = HomeViewOption.fromCode(choice).orElse(null);
            handleHomeViewChoice(homeViewOption);
        } while (homeViewOption != HomeViewOption.EXIT);

        System.out.println("Goodbye!");
    }

    private void displayHomeMenu() {
        for (HomeViewOption option : HomeViewOption.values()) {
            System.out.printf("      %d) %s%n", option.getCode(), option.getLabel());
        }
    }

    private void handleHomeViewChoice(HomeViewOption option) {
        if (option == null) {
            System.out.println("Invalid option. Please try again.");
            return;
        }
        switch (option) {
            case NEW_ORDER -> orderPage.orderMenu();
            case EXIT -> {
            }
        }
    }
}

package main;

import model.ExpenseType;
import model.Expenses;
import model.Revenues;
import utils.Utils;

import java.util.*;

public class App {

    private static final Scanner input = new Scanner(System.in);

    private static Utils utils = new Utils();

    private static final Set<Expenses> expenses = new HashSet<>();
    private static final Set<Revenues> revenues = new HashSet<>();


    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        System.out.println("\n------------ Personal finances --------");
        System.out.println("------- What do you want to do? -------");
        System.out.println("|  1  | - Register a new revenue");
        System.out.println("|  2  | - Register a new expense");
        System.out.println("|  3  | - List revenues");
        System.out.println("|  4  | - List expenses");
        System.out.println("|  5  | - List all");
        System.out.println("|  0  | - Exit");

        int action = getAction();

        switch (action) {
            case 1:
                registerRevenue();
                menu();
                break;
            case 2:
                registerExpense();
                menu();
                break;
            case 3:
                listRevenues();
                menu();
                break;
            case 4:
                listExpenses();
                menu();
                break;
            case 5:
                listAll();
                menu();
                break;
            case 0:
                exitProgram();
                break;
            default:
                System.out.println("Error! Please enter a valid action.");
                menu();
        }
    }

    private static int getAction() {
        int action = -1;
        boolean validAction = false;
        while (!validAction) {
            try {
                System.out.print("Action: ");
                action = input.nextInt();
                validAction = true;
            } catch (InputMismatchException e) {
                System.out.println("Error! Please enter only integer values.");
                input.next();
            }
        }
        return action;
    }

    private static void registerExpense() {
        System.out.println("\n----- Register a new expense -----");
        System.out.print("Expense description: ");
        input.nextLine();
        String description = input.nextLine();

        double value = 0.0;
        boolean isValidValue = false;
        while (!isValidValue) {
            try {
                System.out.print("Expense value: US$");
                value = input.nextDouble();
                if(value > 0.0){
                    isValidValue = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Please enter only real values");
                input.next();
            }
        }

        System.out.println("Essential or non-essential expense?");
        System.out.println("|  1  | - Essential");
        System.out.println("|  2  | - Non-essential");
        ExpenseType expenseType = ExpenseType.DEFAULT;
        boolean isValidAction = false;
        while (!isValidAction) {
            int action = getAction();
            if(action == 1){
                expenseType = ExpenseType.ESSENTIAL;
                isValidAction = true;
            } else if(action == 2){
                expenseType = ExpenseType.NON_ESSENTIAL;
                isValidAction = true;
            } else{
                System.out.println("Error! Please enter a valid action.");
            }
        }

        expenses.add(new Expenses(description, value, expenseType));
        System.out.println("New expense registered successfully!");
        menu();
    }

    private static void registerRevenue() {
        System.out.println("\n----- Register a new revenue -----");
        System.out.print("Revenue description: ");
        input.nextLine();
        String description = input.nextLine();

        double value = 0.0;
        boolean isValidValue = false;
        while(!isValidValue){
            try{
                System.out.print("Revenue value: US$");
                value = input.nextDouble();
                if(value > 0.0){
                    isValidValue = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Error! Please enter only real values");
                input.next();
            }
        }

        revenues.add(new Revenues(description, value));
        System.out.println("New revenue registered successfully!");
        menu();
    }

    private static void listExpenses() {
        System.out.println("\n----- List expenses -----");
        int index = 0;
        for(Expenses expense : expenses){
            System.out.print("#" + (index + 1) + " - ");
            System.out.print(expense.getDescription() + ", ");
            System.out.print("-US$" + expense.getValue() + ", ");
            System.out.println(expense.getExpenseType() + ".");
            index++;
        }
    }

    private static void listRevenues() {
        System.out.println("\n----- List revenues -----");
        int index = 0;
        for(Revenues revenue : revenues){
            System.out.print("#" + (index + 1) + " - ");;
            System.out.print(revenue.getDescription() + ", ");
            System.out.println("+US$" + revenue.getValue());
            index++;
        }
    }

    private static void listAll() {
        System.out.println("\n----- List all -----");
        listRevenues();
        listExpenses();
        menu();
    }

    private static void exitProgram() {
        System.out.println("\nExiting...");
        input.close();
        System.exit(0);
    }
}

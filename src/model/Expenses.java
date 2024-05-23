package model;

import java.util.TreeSet;

public class Expenses {

    private String description;
    private Double value;
    private ExpenseType expenseType;
    private Double total;

    public Expenses(String description, Double value, ExpenseType expenseType) {
        this.description = description;
        this.value = value;
        this.expenseType = expenseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    //TODO
    public String toString(){
        return null;
    }
}

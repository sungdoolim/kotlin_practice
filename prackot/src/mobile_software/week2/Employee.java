package mobile_software.week2;

public class Employee {
    private String name;
    private int salary;
    public Employee(String name){
        this.name=name;
    }
    public void setMonthlySalary(int salary){
        this.salary=salary;

    }
    public int getYearlySalary(){

        return 12*salary;
    }
}

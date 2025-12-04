import java.util.ArrayList;
import java.util.Scanner;
abstract class Employee{
    private int id;
    private String name;
    public Employee(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId(){
    return id;
    }
public abstract int  calculateSalary();
public String toString(){
    return "id is : "+id+", name is : "+name+", salary is : "+calculateSalary();
}
}
class FullTimeEmployee extends Employee{
    private int monthlySalary;
    public FullTimeEmployee(int id,String name,int monthlySalary){
        super(id,name);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public int calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private int hourRate;
    public PartTimeEmployee(int id,String name,int hoursWorked,int hourRate){
        super(id,name);
        this.hoursWorked=hoursWorked;
        this.hourRate=hourRate;
    }
    @Override
    public int calculateSalary(){
        return hoursWorked*hourRate;
    }
}
class PayrollSystem{
    private ArrayList<Employee>empList;
    public PayrollSystem(){
        empList=new ArrayList<Employee>();
    }
    public void addEmployee(Employee e){
        empList.add(e);
    }
    public void removeEmployee(int id){
        Employee removeObject=null;
        for(Employee e:empList){
           if( e.getId()==id){
            removeObject=e;
           }
        }
         if(removeObject!=null){
        empList.remove(removeObject);
    }
    }
   
    public void displayEmployee(){
        for(Employee e:empList){
            System.out.println(e);
        }
    }

}
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PayrollSystem ps=new PayrollSystem();
        FullTimeEmployee fts=new FullTimeEmployee(1, " Nisha", 20000);
        FullTimeEmployee fts1=new FullTimeEmployee(2, "Soniya", 30000);
        FullTimeEmployee fts2=new FullTimeEmployee(3, " Monila", 20000);
        FullTimeEmployee fts3=new FullTimeEmployee(4, "Madhuri", 40000);
        PartTimeEmployee pts=new PartTimeEmployee(5, "Monisha", 5, 100);
        PartTimeEmployee pts1=new PartTimeEmployee(6, "Moni", 6, 100);
        PartTimeEmployee pts2=new PartTimeEmployee(7, "Sanjana", 5, 200);
        PartTimeEmployee pts3=new PartTimeEmployee(8, "Soniya", 4, 200);
        ps.addEmployee(fts);
        ps.addEmployee(fts1);
        ps.addEmployee(fts2);
        ps.addEmployee(fts3);
        ps.addEmployee(pts);
        ps.addEmployee(pts1);
        ps.addEmployee(pts2);
        ps.addEmployee(pts3);
        System.out.println("Total employee working in our office now" );
        ps.displayEmployee();
        System.out.println("If you want to remove any employee you can do");
        System.out.print("Enter the employee id to remove:");
        int n=sc.nextInt();
        ps.removeEmployee(n);
        System.out.println("After removing the employee remaining employees are:");
        ps.displayEmployee();
    }

}


  
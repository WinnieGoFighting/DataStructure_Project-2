
package project2_ni_wei;

public class Employee implements Comparable<Employee> {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        int diff = this.salary-o.salary;
        return diff;
    }
}

   
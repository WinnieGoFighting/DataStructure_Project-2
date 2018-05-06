
package project2_ni_wei;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project2_NI_WEI {

    public static void main(String[] args) throws IOException {
        List<Employee> employees = new ArrayList<>();
        loadData(employees);
        //sort the ArrayList by salary before inserting nodes into binary tree
        Collections.sort(employees);   
        //put nodes into binary tree
        System.out.println("+++++++++++++++++++++++Insert nodes into BST+++++++++++++++++++++++++++++++");
        NodeManipulation m = new NodeManipulation();
        Employee[] employeeArray = employees.toArray(new Employee[employees.size()]);
        m.binarySearchInsertion(employeeArray);
        System.out.println("+++++++++++++++++++++++Inorder print BST++++++++++++++++++++++++++++++++");
        System.out.println("root information: "+m.root.employee.name+" "+m.root.employee.salary);
        m.printInorder(m.root);
        System.out.println("+++++++++++++++++++++++Search Node through Salary 87000++++++++++++++++++++");
        BSTNode searchNode = m.search(87000);
        System.out.println("+++++++++Try to search by salary 87000 after the node is deleted+++++++++++");
        m.delete(87000);
        searchNode = m.search(87000);
        }

    
    public static void loadData(List<Employee> employees) throws FileNotFoundException, IOException {
            FileReader fr = new FileReader("C:\\Users\\Ni\\Documents\\NetBeansProjects\\Project2_NI_WEI\\src\\project2_ni_wei\\EmployeeInfo.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!= null) {
                String[] splitData = line.split("\\s+");
                Employee s = new Employee(splitData[0],Integer.parseInt(splitData[1]));
                employees.add(s);
                line = br.readLine();
            }       
        }
    
    
}
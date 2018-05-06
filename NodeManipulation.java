
package project2_ni_wei;

import java.util.ArrayList;

public class NodeManipulation {
    BSTNode root;
    
    public boolean insert(Employee employee) {
        if(root==null) {
            root = new BSTNode(employee);
            return true;
        }
        else
            return insert(root,employee);
    }
    
    public boolean insert(BSTNode root,Employee employee) {
        //Salaries which are different by less then $3000 are not allowed to be added
        //System.out.println("dhfladlfa:"+employee.salary);
        if(Math.abs(employee.salary-root.employee.salary)<3000) {
            System.out.println("Salaries that are different by less than $3000 cannot be added");
            System.out.println(employee.name+" "+employee.salary+" failed to be added.");
            return false;
        }
        else if(employee.salary<root.employee.salary) {
            if(root.left == null) {
                root.left = new BSTNode(employee);
                return true;
            }
            else {
                return insert(root.left,employee);
            }
        }
        else {
            if(root.right == null) {
                root.right = new BSTNode(employee);
                return true;
            }
            else {
                return insert(root.right,employee);
            }
        }
    }
    
    //This method is used to insert nodes into BST through binary search order
    public void binarySearchInsertion(Employee[] employeeArray) {
        int n = employeeArray.length;  
        if(n==1||n==2){
            for(int i =0;i<n;i++) {
                insert(employeeArray[i]);
            }
            return;
        }

        int mid = n/2;
        insert(employeeArray[mid]);   
        Employee[] left = new Employee[mid];
        Employee[] right = new Employee[n-mid-1];  
        for(int i=0;i<mid;i++) {
            left[i]=employeeArray[i];
        }
        for(int i=0;i<n-mid-1;i++) {
            right[i]=employeeArray[i+mid+1];
        }
        binarySearchInsertion(left);
        binarySearchInsertion(right);
    }
    
    public BSTNode search(int salary) {
        if(root == null) {
            System.out.println("Empty Tree");
            return root; 
        }
        return search(root,salary);
    }
    
    public BSTNode search(BSTNode root, int salary) {
        if(root==null){
            System.out.println("Not found");
            return root;
        }
        else if(salary==root.employee.salary){
            System.out.println(root.employee.name+" "+root.employee.salary);
            return root;
        }
        else if(salary<root.employee.salary) {
            return search(root.left,salary);
        }
        else {
            return search(root.right,salary);
        } 
    }
    
    public BSTNode delete(int salary) {
         if(root == null) {
            System.out.println("Empty Tree");
        }
        return delete(root,salary);  
    }
    
    public BSTNode delete(BSTNode root,int salary) {
        if(root == null) {
            System.out.println("Failed to find the node to be deleted.");
            return null;
        }
        else if(salary<root.employee.salary) {
                root.left = delete(root.left, salary);    
        }
        else if(salary>root.employee.salary) {
                root.right = delete(root.right,salary);
        }
        //we found the node to be deleted!!!
        else {
            //case 1: No child
            if(root.left==null && root.right==null) {
               root=null;
            }
            //case 2: One child
            else if(root.left==null) {
                root=root.right;
            }
            else if(root.right==null) {
                root=root.left;
            }
            //case 3: 2 children
            else {
                BSTNode temp = findMin(root.right);
                root.employee = temp.employee;
                root.right = delete(root.right, temp.employee.salary);
        }
    }
        return root;
    }
    
    public BSTNode findMin(BSTNode root) {
        while(root.left!=null)
            root = root.left;
            return root;
    }
    
    void printInorder(BSTNode root) {
        if(root == null) return;
        printInorder(root.left);
        System.out.println(root.employee.name+" "+root.employee.salary);
        printInorder(root.right);
    }
}

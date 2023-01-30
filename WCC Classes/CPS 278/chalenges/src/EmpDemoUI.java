public class EmpDemoUI {

    public static void main (String[] args){
        EmployeeDemo emp1 = new EmployeeDemo();
        emp1.setName("Susan Meyer");
        emp1.setId(47899);
        emp1.setDepartment("Accounting");
        emp1.setPosition("Vice President");
        System.out.println(emp1.toString());

    }
}

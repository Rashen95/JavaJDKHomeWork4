import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Создание работников
        Employee e1 = new Employee(1, 5223, "Артем", 1);
        Employee e2 = new Employee(2, 2288, "Заур", 5);
        Employee e3 = new Employee(3, 1578, "Петр", 5);
        Employee e4 = new Employee(4, 1684, "Александр", 3);
        Employee e5 = new Employee(5, 5218, "Моня", 4);
        Employee e6 = new Employee(6, 1571, "Болик", 2);
        Employee e7 = new Employee(7, 1237, "Лелик", 4);
        Employee e8 = new Employee(8, 1234, "Сергей", 5);
        Employee e9 = new Employee(9, 8154, "Артур", 3);
        Employee e10 = new Employee(10, 1515, "Артем", 2);

        // Создание и наполнение справочника работниками
        EmployeeDirectory ed = new EmployeeDirectory();
        ed.add(e1);
        ed.add(e2);
        ed.add(e3);
        ed.add(e4);
        ed.add(e5);
        ed.add(e6);
        ed.add(e7);
        ed.add(e8);
        ed.add(e9);
        ed.add(e10);

        // Демонстрация
        System.out.println("Работники со стажем 5 лет");
        System.out.println(ed.experienceSearch(5));
        System.out.println("-------------------------");
        System.out.println("Номера телефонов людей с именем Артем");
        System.out.println(ed.numberSearch("Артем"));
        System.out.println("-------------------------");
        System.out.println("Работник с табельным номером 5");
        System.out.println(ed.employeeSearch(5));
    }
}

class EmployeeDirectory {
    List<Employee> directory;

    public EmployeeDirectory() {
        this.directory = new ArrayList<>();
    }

    public EmployeeDirectory(ArrayList<Employee> list) {
        this.directory = list;
    }

    public ArrayList<Employee> experienceSearch(int experience) {
        ArrayList<Employee> finalList = new ArrayList<>();
        for (Employee e : directory) {
            if (e.getExperience() == experience) {
                finalList.add(e);
            }
        }
        if (!finalList.isEmpty()) {
            return finalList;
        }
        return null;
    }

    public ArrayList<Integer> numberSearch(String name) {
        ArrayList<Integer> finalList = new ArrayList<>();
        for (Employee e : directory) {
            if (Objects.equals(e.getName(), name)) {
                finalList.add(e.getPhoneNumber());
            }
        }
        if (!finalList.isEmpty()) {
            return finalList;
        }
        return null;
    }

    public Employee employeeSearch(int personnelNumber) {
        for (Employee e : directory) {
            if (e.getPersonnelNumber() == personnelNumber) {
                return e;
            }
        }
        return null;
    }

    public void add(Employee addedEmp) {
        for (Employee e : directory) {
            if (e.getPersonnelNumber() == addedEmp.getPersonnelNumber() && e.getPhoneNumber() == addedEmp.getPhoneNumber()) {
                System.out.println("Возможно вы ошиблись. Сотрудник с данным табельным и номером телефона уже существует в справочнике");
                return;
            } else if (e.getPersonnelNumber() == addedEmp.getPersonnelNumber()) {
                System.out.println("Возможно вы ошиблись. Сотрудник с данным табельным уже существует в справочнике");
                return;
            } else if (e.getPhoneNumber() == addedEmp.getPhoneNumber()) {
                System.out.println("Возможно вы ошиблись. Сотрудник с данным номером телефона уже существует в справочнике");
                return;
            }
        }
        directory.add(addedEmp);
    }

}

class Employee {
    private int personnelNumber;
    private int phoneNumber;
    private String name;
    private int experience;

    public Employee(int personnelNumber, int phoneNumber, String name, int experience) {
        this.personnelNumber = personnelNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(int personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.personnelNumber, this.name);
    }
}
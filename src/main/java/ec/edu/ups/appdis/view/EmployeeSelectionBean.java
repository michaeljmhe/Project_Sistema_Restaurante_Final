package ec.edu.ups.appdis.view;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "empSelectBean")
@ViewScoped
public class EmployeeSelectionBean {
  private List<String> selectedEmployees;
  private List<String> employees;

  @PostConstruct
  public void init() {
      employees = Arrays.asList("Jim", "Sara", "Tom",
              "Diana", "Tina", "Joe", "Lara", "Charlie");
  }

  public void setSelectedEmployees(List<String> selectedEmployees) {
      this.selectedEmployees = selectedEmployees;
  }

  public List<String> getSelectedEmployees() {
      return selectedEmployees;
  }

  public List<String> getEmployees() {
      return employees;
  }
}
package com.thouseef.backend.mapper;

import com.thouseef.backend.dto.EmployeeDetailsResponse;
import com.thouseef.backend.dto.EmployeeRequest;
import com.thouseef.backend.dto.EmployeeResponse;
import com.thouseef.backend.entity.Departments;
import com.thouseef.backend.entity.Employees;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    Departments departments;
    public Employees toEmployee(EmployeeRequest request) {
        Employees employee = new Employees();
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setEmail(request.email());
        employee.setPassword(request.password());
        employee.setTitle(request.title());
        employee.setPhotographPath(request.photographPath());
        employee.setDepartmentId(request.departmentId());
        return employee;
    }

    public EmployeeResponse toEmployeeResponse(Employees employee) {
        return new EmployeeResponse(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getTitle()
        );
    }

    public EmployeeDetailsResponse toEmployeeDetailResponse(Employees employee){
        return new EmployeeDetailsResponse(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getTitle(),
                employee.getDepartmentId().getName()
        );
    }
}

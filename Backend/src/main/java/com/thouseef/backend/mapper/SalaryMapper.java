package com.thouseef.backend.mapper;

import com.thouseef.backend.dto.SalaryResponse;
import com.thouseef.backend.entity.EmployeeSalary;
import org.springframework.stereotype.Service;

@Service
public class SalaryMapper {
    public SalaryResponse toSalaryResponse(EmployeeSalary salary) {
        return new SalaryResponse(
                salary.getPaymentDate(),
                salary.getAmount(),
                salary.getDescription()
        );
//        SalaryResponse sal = new SalaryResponse();
//                sal.setPaymentDate(salary.getPaymentDate());
//                sal.setAmount(salary.getAmount());
//                sal.setDescription(salary.getDescription());
//        return sal;
    }
}

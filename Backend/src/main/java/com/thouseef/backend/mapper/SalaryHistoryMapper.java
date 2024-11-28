package com.thouseef.backend.mapper;

import com.thouseef.backend.dto.SalaryResponse;
import com.thouseef.backend.entity.EmployeeSalary;
import org.springframework.stereotype.Service;

@Service
public class SalaryHistoryMapper {
    public SalaryResponse toSalaryResponse(EmployeeSalary salary) {
        return new SalaryResponse(
                salary.getPaymentDate(),
                salary.getAmount(),
                salary.getDescription()
        );
    }
}

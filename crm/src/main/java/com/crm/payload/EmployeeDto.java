package com.crm.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {
    private Long id;

    @NotBlank
    @Size(min = 3, message = "At least 3 character required")
    private String name;

    @Email
    private String emailId;

    @Size(min=10, max = 10, message="At least 10 characters required")
    private String mobile;

    private Date date;
}

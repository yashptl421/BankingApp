package com.yash.banking.webervices.banking_web_services.dto;

import com.yash.banking.webervices.banking_web_services.dto.external.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAccountResponse {
    private CustomerResponse customerResponse;
    private AccountResponse accountResponse;
}

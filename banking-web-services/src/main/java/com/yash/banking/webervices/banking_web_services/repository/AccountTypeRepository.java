package com.yash.banking.webervices.banking_web_services.repository;

import com.yash.banking.webervices.banking_web_services.dto.AccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountTypeRepository extends JpaRepository<AccountTypes, Long> {

}

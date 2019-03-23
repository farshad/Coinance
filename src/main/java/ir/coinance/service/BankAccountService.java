package ir.coinance.service;

import ir.coinance.config.security.SecurityUtils;
import ir.coinance.dto.BankAccountDto;
import ir.coinance.mapper.BankAccountMapper;
import ir.coinance.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository repository;

    @Autowired
    private BankAccountMapper mapper;

    @Autowired
    private SecurityUtils securityUtils;

    @Transactional
    public BankAccountDto save(BankAccountDto dto){
        dto.setUserId(securityUtils.getCurrentUser().getId());
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Transactional(readOnly = true)
    public BankAccountDto findByUserId(){
        return mapper.toDto(repository.findByUserId(securityUtils.getCurrentUser().getId()));
    }
}

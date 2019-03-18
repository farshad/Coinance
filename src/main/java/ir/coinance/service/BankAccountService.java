package ir.coinance.service;

import ir.coinance.dto.BankAccountDto;
import ir.coinance.mapper.BankAccountMapper;
import ir.coinance.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BankAccountService {

    @Autowired
    private BankAccountRepository repo;

    @Autowired
    private BankAccountMapper mapper;

    public BankAccountDto add(BankAccountDto dto){
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

}

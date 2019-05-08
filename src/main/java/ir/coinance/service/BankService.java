package ir.coinance.service;

import ir.coinance.dto.BankDto;
import ir.coinance.mapper.BankMapper;
import ir.coinance.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BankService {

    @Autowired
    private BankRepository repository;

    @Autowired
    private BankMapper mapper;

    @Transactional(readOnly = true)
    public List<BankDto> fetchAll(){
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}

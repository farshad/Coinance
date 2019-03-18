package ir.coinance.service;

import ir.coinance.dto.UserDto;
import ir.coinance.mapper.UserMapper;
import ir.coinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserMapper mapper;

    public UserDto add(UserDto dto){
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }
}

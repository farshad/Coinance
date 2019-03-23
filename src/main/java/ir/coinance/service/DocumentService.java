package ir.coinance.service;

import ir.coinance.config.security.SecurityUtils;
import ir.coinance.domain.Document;
import ir.coinance.dto.DocumentAddDto;
import ir.coinance.dto.DocumentExceptUserDto;
import ir.coinance.mapper.DocumentMapper;
import ir.coinance.repository.DocumentRepository;
import ir.coinance.repository.EnumTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repository;

    @Autowired
    private EnumTypeRepository enumTypeRepository;

    @Autowired
    private DocumentMapper mapper;

    @Autowired
    private SecurityUtils securityUtils;

    @Transactional
    public DocumentExceptUserDto save(DocumentAddDto dto){
        Document document = new Document();
        document.setFileType(enumTypeRepository.getOne(dto.getFileTypeId()));
        document.setSuffix(dto.getImage().getContentType());
        document.setName(dto.getImage().getOriginalFilename());
        document.setStatus(enumTypeRepository.findByKey("document_type_status_wait"));
        document.setUser(securityUtils.getCurrentUser());

        try {
            document.setImage(dto.getImage().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapper.toExceptUserDto(repository.save(document));
    }

    @Transactional(readOnly = true)
    public List<DocumentExceptUserDto> findByUserId() {
        return repository.findByUserId(securityUtils.getCurrentUser().getId())
                .stream()
                .map(mapper::toExceptUserDto)
                .collect(Collectors.toList());
    }
}

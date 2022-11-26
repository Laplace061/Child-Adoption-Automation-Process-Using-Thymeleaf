package com.interswitch.academy.adoptionautomationsystem.service.serviceImpl;

import com.interswitch.academy.adoptionautomationsystem.dto.DocumentsDto;
import com.interswitch.academy.adoptionautomationsystem.entities.Documents;
import com.interswitch.academy.adoptionautomationsystem.mapper.DocumentsMapper;
import com.interswitch.academy.adoptionautomationsystem.repository.DocumentsRepository;
import com.interswitch.academy.adoptionautomationsystem.service.DocumentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentsServiceImpl implements DocumentsService {


    private DocumentsRepository documentsRepository;

    public DocumentsServiceImpl(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    @Override
    public List<DocumentsDto> findAllDocuments() {
        List<Documents> documents = documentsRepository.findAll();
        return documents.stream().map(DocumentsMapper::mapToDocumentsDto)  // Short form
                .collect(Collectors.toList());
    }

//    @Override
//    public List<Documents> uploadDocument(MultipartFile[] files) throws IOException {
//        List<String> fileNames = new ArrayList<>();
//
//        try {
//            List<Documents> storedFile = new ArrayList<>();
//
//            for (MultipartFile file : files) {
//                Documents document = documentsRepository.findByFileName(file.getOriginalFilename());
//                if (document != null) {
//                    // update new contents
//                    document.setData(file.getBytes());
//                } else {
//                    document = new Documents(file.getOriginalFilename(), file.getContentType(), file.getBytes());
//                }
//
//                fileNames.add(file.getOriginalFilename());
//                storedFile.add(document);
//            }
//
//            // Save all Files to database
//            return documentsRepository.saveAll(storedFile);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public Documents getByFileName(String docName) {

        return documentsRepository.findByFileName(docName);
    }
}
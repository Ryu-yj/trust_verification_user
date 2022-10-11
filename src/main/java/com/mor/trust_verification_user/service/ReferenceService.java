package com.mor.trust_verification_user.service;


import com.mor.trust_verification_user.domain.Reference.Reference;
import com.mor.trust_verification_user.domain.Reference.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ReferenceService {

    @Autowired
    private ReferenceRepository referenceRepository;


    public Page<Reference> getAllReferences(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "referenceId");
        return referenceRepository.findAllByReferenceStatus("show",pageable);
    }

    public Page<Reference> getReferenceId(int page, Long referenceId)  {
        Pageable pageable = PageRequest.of(page, 1, Sort.Direction.DESC, "referenceId");
        return referenceRepository.findAllByReferenceStatusAndReferenceId("show", referenceId, pageable);
    }

    public Page<Reference> getsearch(int page, String keyword) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "referenceId");
        return referenceRepository.findAllByReferenceStatusAndReferenceTitleContaining("show", keyword, pageable);
    }

//    public ResponseEntity<Reference> fileDownload() throws FileNotFoundException {
//        Path filePath = Paths.get("<file_path_string>");
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(filePath.toString()));
//        String fileName = "<file_name_string>";
//        logger.info("Success download input excel file : " + filePath);
//        return ResponseEntity.ok()
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .cacheControl(CacheControl.noCache())
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
//                .body(resource);
//    }


//    public List<Reference> getReferences() {
//        return referenceRepository.findAllByReferenceId();
//    }
}

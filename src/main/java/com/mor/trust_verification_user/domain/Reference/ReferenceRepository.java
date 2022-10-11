package com.mor.trust_verification_user.domain.Reference;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReferenceRepository extends JpaRepository<Reference, Long> {


    Page<Reference> findAllByReferenceStatus(String show, Pageable pageable);

    Page<Reference> findAllByReferenceStatusAndReferenceId(String show, Long referenceId, Pageable pageable);


    Page<Reference> findAllByReferenceStatusAndReferenceTitleContaining(String show, String keyword, Pageable pageable);
}

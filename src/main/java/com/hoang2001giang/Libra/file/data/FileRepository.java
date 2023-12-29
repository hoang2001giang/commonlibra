package com.hoang2001giang.Libra.file.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, String> {
    List<FileEntity> findByMappedEntityAndObjectId(FileEntity.Entity mappedEntity, String objectId);
}

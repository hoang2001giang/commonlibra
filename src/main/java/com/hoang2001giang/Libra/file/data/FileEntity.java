package com.hoang2001giang.Libra.file.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name="files")
public class FileEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private String path;
    private String mappedEntity;
    private String objectId;
}

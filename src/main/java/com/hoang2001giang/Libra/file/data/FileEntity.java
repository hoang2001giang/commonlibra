package com.hoang2001giang.Libra.file.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name="files")
public class FileEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private String path;
    @Enumerated(EnumType.STRING)
    private Entity mappedEntity;
    private String objectId;

    public enum Entity {
        PRODUCT, CATEGORY
    }
}

package org.ahea.build.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class FieldCategory {
    @Id
    String id;

    String name;
    String description;
    String regularExpression;
    String type;

    @Transient
    List<String> conditions;
}

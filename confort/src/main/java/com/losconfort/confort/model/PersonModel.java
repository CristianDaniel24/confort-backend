package com.losconfort.confort.model;

import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.sql.Timestamp;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@EqualsAndHashCode(callSuper = false)
public class PersonModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 1925216694390456940L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "VARCHAR(125)", nullable = false)
  private String firstName;

  @Column(columnDefinition = "VARCHAR(125)")
  private String secondName;

  @Column(columnDefinition = "VARCHAR(125)", nullable = false)
  private String lastName;

  @Column(columnDefinition = "VARCHAR(123)")
  private String secondLastName;

  @Column(columnDefinition = "VARCHAR(15)", nullable = false)
  private String document;

  @Column(columnDefinition = "VARCHAR(10)", nullable = false)
  private String phone;

  @Column(columnDefinition = "VARCHAR(150)", nullable = false)
  private String address;

  @Column(
      columnDefinition = "VARCHAR(150)",
      nullable = false) // Poner la anotacion para que sea unico el correo
  private String email;

  @Column(columnDefinition = "VARCHAR(125)", nullable = false)
  private String password;

  @Column(columnDefinition = "DATE", nullable = false)
  private LocalDate dateOfBirth;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}

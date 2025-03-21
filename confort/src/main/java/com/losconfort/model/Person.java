package com.losconfort.model;

import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@EqualsAndHashCode(callSuper = false)
public class Person extends DefaultModel<Long> {

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

  @Column(columnDefinition = "VARCHAR(150)", nullable = false)
  private String email;

  @Column(columnDefinition = "VARCHAR(10)", nullable = false)
  private String phone;

  @Column(columnDefinition = "VARCHAR(150)", nullable = false)
  private String address;

  @Column(columnDefinition = "DATE", nullable = false)
  private LocalDate dateOfBirth;
}

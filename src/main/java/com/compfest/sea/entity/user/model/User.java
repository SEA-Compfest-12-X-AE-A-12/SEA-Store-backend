package com.compfest.sea.entity.user.model;

import com.compfest.sea.entity.merchant.model.Merchant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "users",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "role"})})
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Size(max = 100)
  private String name;

  @Size(max = 50)
  @Email
  private String email;

  @Size(max = 100)
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  @Pattern(regexp = "\\d+")
  @Size(min = 10, max = 15)
  private String phone;

  @Size(max = 100)
  private String address;

  @Column
  private Role role;

  @Column(name = "active", columnDefinition = "boolean default true")
  private Boolean active = true;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonProperty(access = Access.WRITE_ONLY)
  private Merchant merchant;

  public User(int id, String name, String email, String password, String phone, String address, Role role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.address = address;
    this.role = role;
  }

  public User(String name, String email, String password, String phone, String address, Role role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.address = address;
    this.role = role;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

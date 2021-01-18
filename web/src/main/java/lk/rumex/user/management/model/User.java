package lk.rumex.user.management.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private Long id;
    private String address;
    private Integer age;

    public User() {
    }

    public User(Long id, String address, Integer age) {
      this.id = id;
      this.address = address;
      this.age = age;
    }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id=").append(id);
    sb.append(", address='").append(address).append('\'');
    sb.append(", age='").append(age).append('\'');
    sb.append('}');
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id.equals(user.id) &&
      Objects.equals(address, user.address) &&
      Objects.equals(age, user.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address, age);
  }
}


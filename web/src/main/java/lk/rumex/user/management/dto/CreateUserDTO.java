package lk.rumex.user.management.dto;

public class CreateUserDTO {

  private Long id;
  private String address;
  private Integer age;

  public CreateUserDTO(Long id, String address, Integer age) {
    this.id = id;
    this.address = address;
    this.age = age;
  }

  public CreateUserDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CreateUserDTO{");
    sb.append("id=").append(id);
    sb.append(", address='").append(address).append('\'');
    sb.append(", age='").append(age).append('\'');
    sb.append('}');
    return sb.toString();
  }
}

package lk.rumex.user.management.dto;

public class FindAllUsersResponseDTO {

  private String id;

  private String address;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("FindAllUsersResponseDTO{");
    sb.append("id='").append(id).append('\'');
    sb.append(", address='").append(address).append('\'');
    sb.append('}');
    return sb.toString();
  }
}

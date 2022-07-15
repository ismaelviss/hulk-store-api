package com.ismaelviss.hulkstore.domain.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Product
 */
@Validated
@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(name="products",
	   uniqueConstraints = {
			   @UniqueConstraint(columnNames = "id"),
			   @UniqueConstraint(columnNames = "name")
    })
public class Product   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("category")
  private String category = null;

  
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("photoUrls")
  private String photoUrls = null;

  @JsonProperty("status")
  private Boolean status = null;

  @JsonProperty("quantity")
  private Integer quantity = null;
  
  private Double price = null;

  public Product() {
	  
  }
  
  public Product id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Product category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")

  //@Valid

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Product name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "doggie", required = true, value = "")
  //@NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product photoUrls(String photoUrls) {
    this.photoUrls = photoUrls;
    return this;
  }

  /**
   * Get photoUrls
   * @return photoUrls
  **/
  @ApiModelProperty(required = true, value = "")
  //@NotNull


  public String getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(String photoUrls) {
    this.photoUrls = photoUrls;
  }

  public Product status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * product status in the store
   * @return status
  **/
  @ApiModelProperty(value = "product status in the store")


  public Boolean isStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Product quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  **/
  @ApiModelProperty(value = "")


  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.category, product.category) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.photoUrls, product.photoUrls) &&
        Objects.equals(this.status, product.status) &&
        Objects.equals(this.quantity, product.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category, name, photoUrls, status, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


package com.ismaelviss.hulkstore.domain.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * JWT
 */
@Validated
public class JWT {
	@JsonProperty("jwt")
	private String jwt = null;

	public JWT(String token) {
		this.jwt = jwt;
	}

	public JWT() {
		
	}
	
	public JWT jwt(String jwt) {
		this.jwt = jwt;
		return this;
	}

	/**
	 * Get jwt
	 * 
	 * @return jwt
	 **/
	@ApiModelProperty(value = "")

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JWT JWT = (JWT) o;
		return Objects.equals(this.jwt, JWT.jwt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(jwt);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class JWT {\n");

		sb.append("    jwt: ").append(toIndentedString(jwt)).append("\n");
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

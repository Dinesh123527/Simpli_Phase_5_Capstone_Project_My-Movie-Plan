package com.example.capstone.movie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="movie_resource")
public class MovieResource {
	@Column
	@NotNull
	private String resourceCode;
	@Id
	@Column
	@NotNull
	private String resourceDetail;
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	public String getResourceDetail() {
		return resourceDetail;
	}
	public void setResourceDetail(String resourceDetail) {
		this.resourceDetail = resourceDetail;
	}
}

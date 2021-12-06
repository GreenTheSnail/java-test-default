package com.etnetera.hr.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Simple data entity describing basic properties of every JavaScript framework.
 * 
 * @author Etnetera
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JavaScriptFramework {

	@Id
	private Long id;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false)
	private LocalDate deprecationDate;

	@Column(nullable = false)
	private int hypeLevel;

	@OneToMany(mappedBy = "javaScriptFramework", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Version> versionList;

	@Override
	public String toString() {
		return "JavaScriptFramework [id=" + id + ", name=" + name + "]";
	}

}

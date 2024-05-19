package org.giriraj.Model;

import java.util.List;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long RiderId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@NotNull(message = "Name is mandotory")
	@Size(min = 2, message = "name should be of greater than 2 letters")
	private String name;

	@NotNull
	@Pattern(regexp = "^[6-9][0-9]{9}")
	private String phoneNumber;
	
	@OneToMany(mappedBy="Rider")
	private List<Orders> orders;

	@Enumerated(EnumType.STRING)
	private Condition status;

//	public Rider() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public Rider(
			@NotNull(message = "Name is mandotory") @Size(min = 2, message = "name should be of greater than 2 letters") String name,
			@NotNull @Pattern(regexp = "^[6-9][0-9]{9}") String phoneNumber, Condition status) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Rider [RiderId=" + RiderId + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", status=" + status + "]";
	}

}

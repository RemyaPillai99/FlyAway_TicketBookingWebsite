package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PassengerIDProof {
	
	@Id
	@Column(name="IdProof_no")
	private String IdProof_no;
	
	@Column(name="idProofName")
	private String idProofName;
	
	public String getIdProof_no() {
		return IdProof_no;
	}
	public void setIdProof_no(String idProof_no) {
		IdProof_no = idProof_no;
	}
	public String getIdProofName() {
		return idProofName;
	}
	public void setIdProofName(String idProofName) {
		this.idProofName = idProofName;
	}
	
}

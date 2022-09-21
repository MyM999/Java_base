package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

@Builder  
@Entity
public class Dept {
	@Id
	@Column
	private Long deptno;
	
	@NonNull
	@Column
	private String dname;
	
	@NonNull
	@Column
	private String loc;

}

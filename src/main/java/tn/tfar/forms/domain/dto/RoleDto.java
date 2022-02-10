package tn.tfar.forms.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDto {
	private Long idRole;
	
	private String titre;
	
	private String description;
	
	private Boolean deleted;
	
	private Long codeUser;

}

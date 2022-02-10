package tn.tfar.forms.domain.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.tfar.forms.enumeration.AgentPortant;
import tn.tfar.forms.enumeration.IR;
import tn.tfar.forms.enumeration.Instabilite;
import tn.tfar.forms.enumeration.Lymphocytes;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
@ToString()
@Entity
@Table(name = "cytogenetique")
public class Cytogenetique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "n_etude_cyto")
	private Long netudeCyto;

	@Column(name = "lymphocytes", length = 10)
	@Enumerated(EnumType.STRING)
	private Lymphocytes lymphocytes;

	@Column(name = "date_sang")
	private Date dateSang;

	@Column(name = "agent_portant", length = 5)
	@Enumerated(EnumType.STRING)
	private AgentPortant agentPortant;

	@Column(name = "instabilite", length = 5)
	@Enumerated(EnumType.STRING)
	private Instabilite instabilite;

	@Column(name = "instabilite_pourcentage")
	private Double instabilitePourcentage;

	@Column(name = "ir", length = 5)
	@Enumerated(EnumType.STRING)
	private IR ir;

	@Column(name = "ir_pourcentage")
	private Double irPourcentage;

	@Column(name = "moelle")
	private String moelle;

	@Column(name = "date_moelle")
	private Date dateMoelle;

	@Column(name = "resultat_moelle")
	private String resultatMoelle;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_laboratoire", referencedColumnName = "id")
	private Laboratoire laboratoire;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_fiche", referencedColumnName = "id_fiche")
	private Fiche fiche;

	public Cytogenetique(Lymphocytes lymphocytes, Date dateSang, AgentPortant agentPortant, Instabilite instabilite,
			Double instabilitePourcentage, IR ir, Double irPourcentage, String moelle, Date dateMoelle,
			String resultatMoelle, Laboratoire laboratoire, Fiche fiche) {
		this.lymphocytes = lymphocytes;
		this.dateSang = dateSang;
		this.agentPortant = agentPortant;
		this.instabilite = instabilite;
		this.instabilitePourcentage = instabilitePourcentage;
		this.ir = ir;
		this.irPourcentage = irPourcentage;
		this.moelle = moelle;
		this.dateMoelle = dateMoelle;
		this.resultatMoelle = resultatMoelle;
		this.laboratoire = laboratoire;
		this.fiche = fiche;
	}
}

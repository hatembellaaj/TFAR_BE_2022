package com.getaf.tfar.domain.dto;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.getaf.tfar.enumeration.Enum1;
import com.getaf.tfar.enumeration.Enum10;
import com.getaf.tfar.enumeration.Enum11;
import com.getaf.tfar.enumeration.Enum2;
import com.getaf.tfar.enumeration.Enum3;
import com.getaf.tfar.enumeration.Enum4;
import com.getaf.tfar.enumeration.Enum5;
import com.getaf.tfar.enumeration.Enum6;
import com.getaf.tfar.enumeration.Enum7;
import com.getaf.tfar.enumeration.Enum8;
import com.getaf.tfar.enumeration.Enum9;
import com.getaf.tfar.enumeration.Score;
import com.getaf.tfar.enumeration.Statut;
import com.getaf.tfar.enumeration.Toxicite;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fiche2Dto {
	private Long idFiche;

	private String ndossierFiche;

	private Date dateDiagnostique;

	private Date dateEnregistrement;

	private String degConsang;
	
	private Long nbVivant;
	
	private Long nbMort;

	private Long placeEnfant;

	private Long mortNe;

	private Long avortement;

	private Long nbCousin;

	private Long nbMembre;

	private String arbreGenealogique;

	private String arbreGenealogiqueCancer;

	private Enum1 syndromeAnemique;

	private Enum1 syndromeHem;

	private Enum1 syndromeInf;
	
	private Enum1 enqueteFam;

	private Enum1 decouverteFort;
	
	private Enum1 cancer;

	private String typeCancer;
	
	private String autreCirDec;

	private Double tailleNaiss;

	private Double poidsNaiss;

	private Enum1 hypotrophie;

	private Enum1 troubleCroi;

	private Long aageChDiag;
	
	private Long aageOssDiag;
	
	private Long ageRetard;
	
	private Double poids;
	
	private Double taille;

	private Long mageChDiag;

	private Long mageOssDiag;

	private String poidsDS;

	private String tailleDS;

	private Enum1 atteinteCut;

	private Enum1 tacheCaf;
	
	private Enum1 dos;

	private Enum1 ventre;

	private Enum1 membreSup;

	private Enum1 membreInf;

	private Enum1 visage;

	private Enum1 thorax;

	private Enum1 hyperPig;
	
	private String couleurPeau;

	private String autreAtCut;

	private Enum1 atteinteTete;

	private Enum1 microcephalie;

	private Enum1 facieTrig;
	
	private Enum1 traitsFin;
	
	private Enum1 microphtalmie;
	
	private String autreAtTete;
	
	private Enum1 malUro;

	private Enum2 uiv;

	private Enum2 echo;
	
	private Enum1 reinEctop;

	private String siegeEctopie;

	private Enum1 reinFerChev;
	
	private String petitRein;

	private Enum1 reinUnique;

	private String ectopTest;
	
	private String anomVerge;
	
	private String anomVoisUri;
	
	private String typeAnomVoisUri;

	private Enum1 retardPubertaire;

	private String mtanner;

	private String ptanner;

	private String ttanner;
	
	private String autreUrogenital;

	private Enum1 atteinteOss;
	
	private Enum1 anomPouce;
	
	private Enum1 anomAutreDoigts;
	
	private Enum1 courtsTrapus;

	private Enum1 syndactylie;
	
	private String autreAnomAutreDoigts;
	
	private Enum1 agenesieRadius;
	
	private Enum1 anomOrteil;
	
	private String typeAnomOrteil;
	
	private Enum1 bifide;
	
	private Enum1 luxCongHanche;
	
	private String anomRachis;

	private String autreAnomOss;
	
	private Enum1 anomNeuro;

	private Enum1 retardMent;
	
	private Enum3 performanceScolaire;
	
	private Enum1 hypoacousie;
	
	private String autreAnomNeuro;
	
	private Enum1 strabisme;
	
	private Enum1 anomCardVas;

	private Enum1 echoCoeur;
	
	private String preciseAnomCardio;

	private Enum1 anomDig;

	private String preciseAnomDig;

	private Enum1 endocrinopathie;
	
	private Enum1 diabete;
	
	private Enum1 hypothyroidie;

	private Long ageDecouverte;
	
	private String autreSympEndo;
	
	private Enum1 deficiteGH;
	
	private String autreAnomCong;
	
	private Double hb;

	private Double vgm;

	private Double retic;

	private Double leuco;

	private Double pnn;

	private Double plq;
	
	private Double ageDebutManiHema;
	
	private Enum1 hbInf;

	private Enum1 plq_inf;

	private Enum1 pnnInf;

	private Enum2 electrophoreseHb;
	
	private Double hbf;

	private Enum2 myelogramme;

	private Enum4 cellularite;

	private Double erythroblaste;
	
	private Enum5 morphologie;
	
	private Enum6 bom;
	
	private Double pourcenAdipo;
	
	private Enum1 ubiquitination;

	private Enum7 resUbiquitination;

	private String groupComp;

	private String mutationFANC;
	
	private Enum2 congelationCellule;

	private String labo;

	private String typePrelevement;
	
	private Long scoreClinique;

	private Long scoreEBMT;

	private Score score;
	
	private Enum1 transfusion;

	private Long ageTransf;
	
	private Enum8 nbCG;
	
	private Enum1 chelationFer;
	
	private Double delaiDiag;

	private Enum8 nbCP;

	private String chelateur;
	
	private Enum1 nilevar;
	
	private Enum1 oxymetholone;

	private Enum1 androtordyl;

	private String autreAndrogene;

	private Date androDebut;

	private Date androFin;

	private String observance;

	private Toxicite toxicite;

	private String autreToxicite;
	
	private Enum1 enqueteHLA;

	private String pourquoiEnqHLA;

	private Long nbFratTyp;

	private Long nbFratNTyp;

	private Long donneurComp;

	private String preciseDonneur;

	private String donneur;

	private Enum1 greffeFaite;

	private Double delaiRappDiag;
	
	private String pourquoiNfaite;

	private Enum1 cyclophosphamide;
	
	private Double doseCum1;
	
	private Enum1 fludarabine;

	private Double doseCum2;
	
	private Enum1 busulfan;

	private Double doseCum3;
	
	private String autreConditionnement;

	private String irradiation;

	private Enum2 serotherapie;

	private Enum1 sal;

	private Double doseSAL;

	private String sourceCellule;

	private Long sortieAplasie;

	private Enum9 gradeaGvH;

	private Enum10 cgvH;

	private Enum1 mvo;

	private Enum1 complicationPulmonaire;

	private String preciseCompPulm;

	private Enum1 survieJ100;
	
	private Enum1 smd;
	
	private String critereDiagSMD;
	
	private String traitementSMD;

	private Long ageDiagSMD;
	
	private Enum11 transformationAigue;

	private Long ageDiagLA;
	
	private Enum1 traitementLA;

	private Enum1 cancerE;

	private String localisation;

	private String typeHistologique;

	private Enum1 traitementCancer;

	private String preciseTraitement;

	private Enum1 evolution_cyto;

	private String formuleChrom;

	private Long ageE;
	
	private String autresCancers;

	private Date ddn;

	private Statut statut;
	
	private Double survieGlobale;
	
	private Long code_user;
	
	
	private PatientDto patient;
	
	private List<AndrogeneDto> androgene;
	
	private CousinDto cousin;
	
	private FrereDto frere;
	
	private List<CytogenetiqueDto> cytogenetique;
}

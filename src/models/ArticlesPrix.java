package models;
// Generated Jun 22, 2021 1:56:43 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ArticlesPrix generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "articles_prix", catalog = "g_vente")
public class ArticlesPrix implements java.io.Serializable {

	private Integer codeArt;
	private String nomArt;
	private String descArt;
	private int prixPdt;

	public ArticlesPrix() {
	}

	public ArticlesPrix(String nomArt, String descArt, int prixPdt) {
		this.nomArt = nomArt;
		this.descArt = descArt;
		this.prixPdt = prixPdt;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "codeArt", unique = true, nullable = false)
	public Integer getCodeArt() {
		return this.codeArt;
	}

	public void setCodeArt(Integer codeArt) {
		this.codeArt = codeArt;
	}

	@Column(name = "nomArt", nullable = false, length = 20)
	public String getNomArt() {
		return this.nomArt;
	}

	public void setNomArt(String nomArt) {
		this.nomArt = nomArt;
	}

	@Column(name = "descArt", nullable = false, length = 200)
	public String getDescArt() {
		return this.descArt;
	}

	public void setDescArt(String descArt) {
		this.descArt = descArt;
	}

	@Column(name = "prixPdt", nullable = false)
	public int getPrixPdt() {
		return this.prixPdt;
	}

	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}

}

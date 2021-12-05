package action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import models.ArticlesPrix;
import models.ArticlesStock;
import models.Commandes;
import services.ArticlesPrixService;
import services.ArticlesPrixServicesImp;
import services.ArticlesStockServices;
import services.ArticlesStockServicesImp;
import services.CommandesService;
import services.CommandesServicesImp;
import util.InvoiceGenerator;
public class addCommande extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String codeArt;
	private String dateCMD;
	private String qteArt;
	private List<Commandes> mescommandes=null;
	private InputStream inputStream;
	private Map<String,Object> session = ActionContext.getContext().getSession();

	public String getCodeArt() {
		return codeArt;
	}
	public void setCodeArt(String codeArt) {
		this.codeArt = codeArt;
	}
	public String getDateCMD() {
		return dateCMD;
	}
	public void setDateCMD(String dateCMD) {
		this.dateCMD = dateCMD;
	}
	public String getQteArt() {
		return qteArt;
	}
	public void setQteArt(String qteArt) {
		this.qteArt = qteArt;
	}
	public List<Commandes> getMescommandes() {
		return mescommandes;
	}
	public void setMescommandes(List<Commandes> mescommandes) {
		this.mescommandes = mescommandes;
	}
	
    public String execute(){
    	String user = (String) session.get("username");
    	session.remove("commande");
    	int code = Integer.parseInt(codeArt);
		int qte = Integer.parseInt(qteArt);
		ArticlesPrixService article = new ArticlesPrixServicesImp();
		CommandesService a = new CommandesServicesImp();
		ArticlesStockServices stock = new ArticlesStockServicesImp();
		ArticlesStock art;
		Commandes commande = new Commandes();
		try {
			article.findById(code);
			commande.setCodeArt(code);
			commande.setDateCmd(new SimpleDateFormat("dd/MM/yyyy").parse(dateCMD));
			commande.setQteCmd(qte);
			commande.setClient(user);
			art = stock.findById(code);
			if(art.getQteArt() >= qte) {
				int nv_qte = art.getQteArt() - qte;
				art.setQteArt(nv_qte);
				stock.edit(art);
			}else {
				addActionError("La quantité demandé n'existe pas dans le stock");
				return ERROR;
			}
			int codeCMD = a.add(commande);
			commande.setCodeCmd(codeCMD);
			session.put("commande", commande);
		}catch(Exception e) {
			addActionError("L'article demandé n'existe pas");
			return ERROR;
		}
		addActionMessage("L'article est ajouté avec succes. Cliquez dans Telecharger pour telecharger la facture de la commande.");
		return SUCCESS;
	}
	
    public String telecharger() {
    	String user = (String) session.get("username");
        Commandes commande = new Commandes();
        commande = (Commandes) session.get("commande");
        InvoiceGenerator pdf = new InvoiceGenerator();
        inputStream = pdf.createPDF(commande,user);
    	return SUCCESS;
    }

	
	public InputStream getInputStream() {
        return inputStream;
    }
	
	
	public String getcommande() {
		String user = (String) session.get("username");
		CommandesService a = new CommandesServicesImp();
		setMescommandes(a.findCommandByUser(user));
		return "success";
	}
	
}

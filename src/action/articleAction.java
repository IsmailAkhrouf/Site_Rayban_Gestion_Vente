package action;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import models.ArticlesPrix;
import models.ArticlesStock;
import services.ArticlesPrixService;
import services.ArticlesPrixServicesImp;
import services.ArticlesStockServices;
import services.ArticlesStockServicesImp;

public class articleAction extends ActionSupport{
	private static final long serialVersionUID = -4215116840067378030L;
	private List<ArticlesStock> Article= null;
	
	public List<ArticlesStock> getArticle() {
		return Article;
	}


	public void setArticle(List<ArticlesStock> article) {
		Article = article;
	}


	public String execute() {
		setArticle(new ArrayList<ArticlesStock>());
		List<ArticlesPrix> tmp_article;
		ArticlesPrixService avente = new ArticlesPrixServicesImp();
		ArticlesStockServices astock = new ArticlesStockServicesImp();
		tmp_article = avente.findAll();
		ArticlesStock tmp;
		int qteArt,codeArt;
		for(int i = 0; i < tmp_article.size(); i++) {
			tmp = new ArticlesStock();
			codeArt = tmp_article.get(i).getCodeArt();
			qteArt = astock.findById(codeArt).getQteArt();
			tmp.setCodeArt(codeArt);
			tmp.setDescArt(tmp_article.get(i).getDescArt());
			tmp.setNomArt(tmp_article.get(i).getNomArt());
			tmp.setPrixArt(tmp_article.get(i).getPrixPdt());
			tmp.setQteArt(qteArt);
			getArticle().add(tmp);
		}
		return "success";
	}
}

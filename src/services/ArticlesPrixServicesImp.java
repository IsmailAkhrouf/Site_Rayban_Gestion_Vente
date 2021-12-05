package services;

import java.util.List;

import models.ArticlesPrix;
import models.ArticlesPrixDAO;
import models.ArticlesPrixDAOImp;


public class ArticlesPrixServicesImp implements ArticlesPrixService {

	ArticlesPrixDAO artp = new ArticlesPrixDAOImp();

	@Override
	public List<ArticlesPrix> findAll() {
		return artp.findAll();
	}

	@Override
	public ArticlesPrix findById(int id) {
		return artp.findById(id);
	}

}

package services;

import java.util.List;

import models.ArticlesStock;
import models.ArticlesStockDAO;
import models.ArticlesStockDAOImp;

public class ArticlesStockServicesImp implements ArticlesStockServices {

	ArticlesStockDAO arts = new ArticlesStockDAOImp();
	@Override
	public void add(ArticlesStock e) {
		arts.add(e);
	}

	@Override
	public ArticlesStock edit(ArticlesStock e) {
		return arts.edit(e);
	}

	@Override
	public List<ArticlesStock> findAll() {
		return arts.findAll();
	}

	@Override
	public ArticlesStock findById(int id) {
		return arts.findById(id);
	}

	
	
}

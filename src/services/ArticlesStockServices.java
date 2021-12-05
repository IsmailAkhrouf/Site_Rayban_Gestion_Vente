package services;

import java.util.List;

import models.ArticlesStock;

public interface ArticlesStockServices {
	
	public void add(ArticlesStock e);
	public ArticlesStock edit(ArticlesStock e);
	public List<ArticlesStock> findAll();
	public ArticlesStock findById(int id); 
}

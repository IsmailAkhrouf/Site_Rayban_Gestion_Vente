package services;

import java.util.List;

import models.ArticlesPrix;

public interface ArticlesPrixService {
	
	public List<ArticlesPrix> findAll();
	public ArticlesPrix findById(int id);
	
}

import services.ArticlesPrixService;
import services.ArticlesPrixServicesImp;

public class Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArticlesPrixService article = new ArticlesPrixServicesImp();
		article.findById(29);
	}

}

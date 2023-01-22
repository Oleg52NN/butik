package myButik.projeсt;

public class ArticleNumber {
    private static ArticleNumber instance = null;
    private int article = 1000;

    private ArticleNumber() {

    }
    public static ArticleNumber get() {
        if (instance == null) instance = new ArticleNumber();
        return instance;
    }

    public int getArticle() {
        return article++;
    }

}

package com.hbase.article;

public class Article {

	String articleId;
	String articleTitle;
	String articleUrl;
	String articleThumbnailUrl;

	public Article(String articleId, String articleTitle, String articleUrl,
			String articleThumbnailUrl) {
		
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleUrl = articleUrl;
		this.articleThumbnailUrl = articleThumbnailUrl;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getArticleThumbnailUrl() {
		return articleThumbnailUrl;
	}

	public void setArticleThumbnailUrl(String articleThumbnailUrl) {
		this.articleThumbnailUrl = articleThumbnailUrl;
	}

}

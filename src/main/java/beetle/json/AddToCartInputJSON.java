package beetle.json;

import beetle.enums.ComponentType;

public class AddToCartInputJSON {
    private ComponentType component;
    private Long article;

    public ComponentType getComponent() {
        return component;
    }

    public void setComponent(ComponentType component) {
        this.component = component;
    }

    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }
}

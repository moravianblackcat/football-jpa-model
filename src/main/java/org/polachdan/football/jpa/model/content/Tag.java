package org.polachdan.football.jpa.model.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Tag {

    @Id
    @Column(name = "tag_name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Article> articles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

}

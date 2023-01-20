package org.project.entity;

public class Movie extends AbstractEntity<Integer> {
    private Integer id;
    private String title;

    public Movie(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
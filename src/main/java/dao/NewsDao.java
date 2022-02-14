package dao;

import models.News;

import java.util.List;

public interface NewsDao {

    //post new news object
    void add(News news);

    //get allNewsObjects
    List<News> getNewsObject();
}

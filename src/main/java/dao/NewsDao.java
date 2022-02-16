package dao;

import models.News;

import java.util.List;

public interface NewsDao {

    //post new news object
    void add(News news);

    //get allNewsObjects
    List<News> getAllNews();

    //get news by Id
    News findById(int id);

    //get news by depart
    List<News> findNewsByDepart(int departId);
}

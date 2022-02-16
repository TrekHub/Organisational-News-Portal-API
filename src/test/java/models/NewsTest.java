package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Test
    public void news_InstantiateCorrectly_true(){
        News testNews = new News("Rest Api", "Application Interface", 1);
        assertEquals(true, testNews instanceof  News);
    }

    @Test
    public void news_InstantiateWithTitle_true(){
        News testNews = new News("Rest Api", "Application Interface", 1);
        assertEquals("Rest Api", testNews.getTitle());
    }

    @Test
    public void news_InstantiateWithContent_true(){
        News testNews = new News("Rest Api", "Application Interface", 1);
        assertEquals("Application Interface", testNews.getContent());
    }


    @Test
    public void news_InstantiateWithDepartId_true(){
        News testNews = new News("Rest Api", "Application Interface", 1);
        assertEquals(1, testNews.getDepartId());
    }

}
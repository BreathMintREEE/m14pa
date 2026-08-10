// Book.java
// D. Singletary
// 11/20/24
// Book model component in MVC example

package edu.cop3330c.bookmanager;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}

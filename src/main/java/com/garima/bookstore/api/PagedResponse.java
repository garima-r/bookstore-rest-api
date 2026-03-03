package com.garima.bookstore.api;

import java.util.List;

public class PagedResponse<T> {
    private List<T> data;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public PagedResponse(List<T> data,
                        int page,
                        int size,
                        long totalElements,
                        int totalPages,
                        boolean last){
        this.data = data;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }

    //getters
    public List<T> getData(){
        return data;
    }
    
    public int getPage(){
        return page;
    }

    public int getSize(){
        return size;
    }

    public long getTotalElements(){
        return totalElements;
    }

    public int getTotalPages(){
        return totalPages;
    }

    public boolean isLast(){
        return last;
    }
}

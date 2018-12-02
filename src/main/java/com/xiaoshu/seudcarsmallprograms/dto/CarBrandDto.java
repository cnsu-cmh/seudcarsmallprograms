package com.xiaoshu.seudcarsmallprograms.dto;


import java.io.Serializable;
import java.util.List;

public class CarBrandDto implements Serializable {

    private static final long serialVersionUID = -336015513686371234L;

    private Integer id;

    private String title;

    private List<CarBrandInfo> list;

    public CarBrandDto(Integer id, String title, List<CarBrandInfo> list) {
        this.id = id;
        this.title = title;
        this.list = list;
    }

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

    public List<CarBrandInfo> getList() {
        return list;
    }

    public void setList(List<CarBrandInfo> list) {
        this.list = list;
    }

    public static class CarBrandInfo{

        private  Long id;

        private  String name;

        private String src;

        public CarBrandInfo(Long id, String name, String src) {
            this.id = id;
            this.name = name;
            this.src = src;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }
}

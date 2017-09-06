package com.example.administrator.funtv.entity;

/**
 * Created by acer on 2016/11/23.
 */

public class PostSearchBean {
   // os =1

    //categoryid = 0  key = xxx  page =0/1  size =10

   // v = 2.2.4  ver =4

    private int os =1;
    private p p;
    public class  p{

        public p(int page, String key) {
            this.page = page;
            this.key = key;
        }

        private  int categoryid =0;
        private String key ;
        private  int page ;
        private int size  =10;

        public int getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(int categoryid) {
            this.categoryid = categoryid;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "p{" +
                    "categoryid=" + categoryid +
                    ", key='" + key + '\'' +
                    ", page=" + page +
                    ", size=" + size +
                    '}';
        }
    }
     private  float v =2.24f ;
     private  float ver =4;

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public float getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }

    public float getVer() {
        return ver;
    }

    public void setVer(float ver) {
        this.ver = ver;
    }

    public p p() {
        return p;
    }

    public void setp(p details) {
        this.p = details;
    }

    @Override
    public String toString() {
        return "PostSearchBean{" +
                "os=" + os +
                ", details=" + p +
                ", v=" + v +
                ", ver=" + ver +
                '}';
    }
}

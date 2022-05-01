package com.example.gifslistapitestwork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {
    public ArrayList<GifElement> data;
    public Pagination pagination;
    public Meta meta;

    public ArrayList<GifElement> getGifElementsArray() {
        return data;
    }

    public void setGifElementsArray(ArrayList<GifElement> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }



    public class Pagination {
        @SerializedName("total_count")
        @Expose
        public int total_count;
        @SerializedName("count")
        @Expose
        public int count;
        @SerializedName("offset")
        @Expose
        public int offset;

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }
    }

    public class Meta {
        @SerializedName("status")
        @Expose
        public int status;
        @SerializedName("msg")
        @Expose
        public String msg;
        @SerializedName("response_id")
        @Expose
        public String response_id;
        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getResponse_id() {
            return response_id;
        }

        public void setResponse_id(String response_id) {
            this.response_id = response_id;
        }
    }
}

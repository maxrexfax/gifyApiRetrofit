package com.example.gifslistapitestwork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class GifElement {

    static int instanceCounter = 1;
    private int creation_id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("bitly_gif_url")
    @Expose
    private String bitly_gif_url;
    @SerializedName("bitly_url")
    @Expose
    private String bitly_url;
    @SerializedName("embed_url")
    @Expose
    private String embed_url;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("content_url")
    @Expose
    private String content_url;
    @SerializedName("source_tld")
    @Expose
    private String source_tld;
    @SerializedName("source_post_url")
    @Expose
    private String source_post_url;
    @SerializedName("isSticker")
    @Expose
    private boolean isSticker;
    @SerializedName("import_datetime")
    @Expose
    private String import_datetime;
    @SerializedName("trending_datetime")
    @Expose
    private String trending_datetime;

    //images
    private Images images;

    public GifElement(String title, String embedUrl){
        this.title = title;
        this.embed_url = embedUrl;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public static int getInstanceCounter() {
        return instanceCounter;
    }

    public int getCreation_id() {
        return creation_id;
    }

    public void setCreation_id(int creation_id) {
        this.creation_id = creation_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBitly_gif_url() {
        return bitly_gif_url;
    }

    public void setBitly_gif_url(String bitly_gif_url) {
        this.bitly_gif_url = bitly_gif_url;
    }

    public String getBitly_url() {
        return bitly_url;
    }

    public void setBitly_url(String bitly_url) {
        this.bitly_url = bitly_url;
    }

    public String getEmbed_url() {
        return embed_url;
    }

    public void setEmbed_url(String embed_url) {
        this.embed_url = embed_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getSource_tld() {
        return source_tld;
    }

    public void setSource_tld(String source_tld) {
        this.source_tld = source_tld;
    }

    public String getSource_post_url() {
        return source_post_url;
    }

    public void setSource_post_url(String source_post_url) {
        this.source_post_url = source_post_url;
    }

    public boolean isSticker() {
        return isSticker;
    }

    public void setSticker(boolean sticker) {
        isSticker = sticker;
    }

    public String getImport_datetime() {
        return import_datetime;
    }

    public void setImport_datetime(String import_datetime) {
        this.import_datetime = import_datetime;
    }

    public String getTrending_datetime() {
        return trending_datetime;
    }

    public void setTrending_datetime(String trending_datetime) {
        this.trending_datetime = trending_datetime;
    }

    public class Images {
        public Original getOriginal() {
            return original;
        }

        public void setOriginal(Original original) {
            this.original = original;
        }

        public Original original;

        public class Original {
            @SerializedName("height")
            @Expose
            public String height;
            @SerializedName("width")
            @Expose
            public String width;
            @SerializedName("size")
            @Expose
            public String size;
            @SerializedName("url")
            @Expose
            public String url;
            @SerializedName("mp4_size")
            @Expose
            public String mp4_size;
            @SerializedName("mp4")
            @Expose
            public String mp4;
            @SerializedName("webp_size")
            @Expose
            public String webp_size;

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getMp4_size() {
                return mp4_size;
            }

            public void setMp4_size(String mp4_size) {
                this.mp4_size = mp4_size;
            }

            public String getMp4() {
                return mp4;
            }

            public void setMp4(String mp4) {
                this.mp4 = mp4;
            }

            public String getWebp_size() {
                return webp_size;
            }

            public void setWebp_size(String webp_size) {
                this.webp_size = webp_size;
            }

            public String getWebp() {
                return webp;
            }

            public void setWebp(String webp) {
                this.webp = webp;
            }

            public String webp;
        }
    }
}

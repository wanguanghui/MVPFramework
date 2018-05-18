package com.wgh.mvpframework.common.net.model;

import com.google.gson.annotations.SerializedName;

/**
 * @version V0.1.0
 * @author: wgh
 * @date: 2018/4/10
 * @description
 */
public class TestBean {


    @SerializedName("args")
    private ArgsBean args;
    private String data;
    private FilesBean files;
    private FormBean form;
    private HeadersBean headers;
    private Object json;
    private String origin;
    private String url;

    public ArgsBean getArgs() {
        return args;
    }

    public void setArgs(ArgsBean args) {
        this.args = args;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public FilesBean getFiles() {
        return files;
    }

    public void setFiles(FilesBean files) {
        this.files = files;
    }

    public FormBean getForm() {
        return form;
    }

    public void setForm(FormBean form) {
        this.form = form;
    }

    public HeadersBean getHeaders() {
        return headers;
    }

    public void setHeaders(HeadersBean headers) {
        this.headers = headers;
    }

    public Object getJson() {
        return json;
    }

    public void setJson(Object json) {
        this.json = json;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class ArgsBean {

        private String pwd;
        private String username;

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "ArgsBean{" +
                    "pwd='" + pwd + '\'' +
                    ", username='" + username + '\'' +
                    '}';
        }
    }

    public static class FilesBean {
    }

    public static class FormBean {

        private String pwd;
        private String username;
        private String url;

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "FormBean{" +
                    "pwd='" + pwd + '\'' +
                    ", username='" + username + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }

    }

    public static class HeadersBean {
        @SerializedName("Accept")
        private String Accept;
        @SerializedName("Accept-Encoding")
        private String AcceptEncoding;
        @SerializedName("Cache-Control")
        private String CacheControl;
        private String Connection;
        @SerializedName("Content-Length")
        private String ContentLength;
        @SerializedName("Content-Type")
        private String ContentType;
        private String Host;
        @SerializedName("Postman-Token")
        private String PostmanToken;
        @SerializedName("User-Agent")
        private String UserAgent;

        public String getAccept() {
            return Accept;
        }

        public void setAccept(String accept) {
            Accept = accept;
        }

        public String getAcceptEncoding() {
            return AcceptEncoding;
        }

        public void setAcceptEncoding(String AcceptEncoding) {
            this.AcceptEncoding = AcceptEncoding;
        }

        public String getCacheControl() {
            return CacheControl;
        }

        public void setCacheControl(String CacheControl) {
            this.CacheControl = CacheControl;
        }

        public String getConnection() {
            return Connection;
        }

        public void setConnection(String Connection) {
            this.Connection = Connection;
        }

        public String getContentLength() {
            return ContentLength;
        }

        public void setContentLength(String ContentLength) {
            this.ContentLength = ContentLength;
        }

        public String getContentType() {
            return ContentType;
        }

        public void setContentType(String ContentType) {
            this.ContentType = ContentType;
        }

        public String getHost() {
            return Host;
        }

        public void setHost(String Host) {
            this.Host = Host;
        }

        public String getPostmanToken() {
            return PostmanToken;
        }

        public void setPostmanToken(String PostmanToken) {
            this.PostmanToken = PostmanToken;
        }

        public String getUserAgent() {
            return UserAgent;
        }

        public void setUserAgent(String UserAgent) {
            this.UserAgent = UserAgent;
        }
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "args=" + args +
                ", data='" + data + '\'' +
                ", form=" + form +
                ", headers=" + headers +
                ", json=" + json +
                ", origin='" + origin + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

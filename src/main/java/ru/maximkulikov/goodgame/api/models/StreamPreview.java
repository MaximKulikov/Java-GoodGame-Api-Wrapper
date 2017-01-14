package ru.maximkulikov.goodgame.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamPreview {

    private String small;
    private String medium;
    private String large;
    private String template;

    public StreamPreview(final String small, final String medium, final String large, final String template) {
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.template = template;
    }

    public String getLarge() {
        return this.large;
    }

    public void setLarge(final String large) {
        this.large = large;
    }

    public String getMedium() {
        return this.medium;
    }

    public void setMedium(final String medium) {
        this.medium = medium;
    }

    public String getSmall() {

        return this.small;
    }

    public void setSmall(final String small) {
        this.small = small;
    }

    public String getTemplate() {
        return this.template;
    }

    public void setTemplate(final String template) {
        this.template = template;
    }

    @Override
    public int hashCode() {
        int result = this.small != null ? this.small.hashCode() : 0;
        result = 31 * result + (this.medium != null ? this.medium.hashCode() : 0);
        result = 31 * result + (this.large != null ? this.large.hashCode() : 0);
        result = 31 * result + (this.template != null ? this.template.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StreamPreview that = (StreamPreview) o;

        if (this.small != null ? !this.small.equals(that.small) : that.small != null) {
            return false;
        }
        if (this.medium != null ? !this.medium.equals(that.medium) : that.medium != null) {
            return false;
        }
        if (this.large != null ? !this.large.equals(that.large) : that.large != null) {
            return false;
        }

        return !(this.template != null ? !this.template.equals(that.template) : that.template != null);

    }

    @Override
    public final String toString() {
        return "StreamPreview{" +
                "small='" + small + '\'' +
                ", medium='" + medium + '\'' +
                ", large='" + large + '\'' +
                ", template='" + template + '\'' +
                '}';
    }
}

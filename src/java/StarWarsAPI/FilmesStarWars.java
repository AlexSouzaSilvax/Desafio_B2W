/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StarWarsAPI;

/**
 *
 * @author homer
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmesStarWars {

    @SerializedName("count")
    @Expose
    public Integer count;

    @SerializedName("next")
    @Expose
    public Object next;

    @SerializedName("previous")
    @Expose
    public Object previous;

    @SerializedName("results")
    @Expose
    public List<FilmesStarWarsResult> results = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<FilmesStarWarsResult> getResults() {
        return results;
    }

    public void setResults(List<FilmesStarWarsResult> results) {
        this.results = results;
    }

}

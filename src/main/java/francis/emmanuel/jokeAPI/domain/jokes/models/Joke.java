package francis.emmanuel.jokeAPI.domain.jokes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Joke {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String joke;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Joke(){
    }

    public Long getId(){
        return this.id;
    }

    public String getJoke(){
        return this.joke;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setJoke(String joke){
        this.joke = joke;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", joke: '" + joke + '\'' +
                '}';
    }

}

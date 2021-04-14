package cn.su.spel.domain;

import java.util.Date;

/**
 * @author SuZuQi
 * @title: Inventor
 * @projectName testSpel
 * @description: TODO
 * @date 2021/3/25
 */
public class Inventor {

    private String name ;

    private Date birth ;

    private String nationality ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Inventor(String name, Date birth, String nationality) {
        this.name = name;
        this.birth = birth;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Inventor{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public Inventor(){}
}

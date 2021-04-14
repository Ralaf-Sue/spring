package cn.su.spel.domain;

/**
 * @author SuZuQi
 * @title: NumberGuess
 * @projectName testSpel
 * @description: TODO
 * @date 2021/3/29
 */
public class NumberGuess {

    private Double randomNumber ;

    private String userRegion ;

    private String environment ;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getUserRegion() {
        return userRegion;
    }

    public void setUserRegion(String userRegion) {
        this.userRegion = userRegion;
    }

    public Double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Double randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public String toString() {
        return "NumberGuess{" +
                "randomNumber=" + randomNumber +
                ", userRegion='" + userRegion + '\'' +
                ", environment='" + environment + '\'' +
                '}';
    }
}

package cn.su.spel.domain;

/**
 * @author SuZuQi
 * @title: MyMessage
 * @projectName testSpel
 * @description: TODO
 * @date 2021/3/29
 */
public class MyMessage {

    private String payload = "111";

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "payload='" + payload + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return 12345 ;
    }

    public static String tryAppend(String text) {
        return new StringBuffer("hello,").append(text).toString();
    }
    public  String append(String text) {
        return new StringBuffer("hello,").append(text).toString();
    }

    public String add() {
        String text = "world" ;
        return new StringBuffer("hello,").append(text).toString();
    }
}

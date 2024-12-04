public class player {
    public static String Username;
    public static String Class;
    public static String startingGift;

    public player(String username, String startingclass, String startinggift){
        Username = username;
        Class = startingclass;
        startingGift = startinggift;
    }
    public String getPlayerName(){
        return Username;
    }
    public String getPlayerClass(){
        return Class;
    }
    public String getPlayerGift(){
        return startingGift;
    }
}

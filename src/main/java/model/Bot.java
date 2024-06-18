package model;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;


    public Bot(int id, char symbol ,BotDifficultyLevel botDifficultyLevel) {
        super(id, "CHITTI" , symbol , PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}

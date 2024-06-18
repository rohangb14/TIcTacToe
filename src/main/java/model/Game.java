package model;

import exceptions.InvalidBotCountException;
import exceptions.InvalidPlayerSizeException;
import exceptions.InvalidSymbolSetupException;
import service.winningStratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Board currentBoards;
    private List<Player> players;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardStates;
    private WinningStratergy winningStratergy;
    private int numberofSymbols;

    private Game(Board currentBoards, List<Player> players, WinningStratergy winningStratergy) {
        this.currentBoards = currentBoards;
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.winningStratergy = winningStratergy;
        this.numberofSymbols = players.size();
    }

    public static Builder builder(){
        return new Builder();
    }

    public Board getCurrentBoards() {
        return currentBoards;
    }

    public void setCurrentBoards(Board currentBoards) {
        this.currentBoards = currentBoards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public WinningStratergy getWinningStratergy() {
        return winningStratergy;
    }

    public void setWinningStratergy(WinningStratergy winningStratergy) {
        this.winningStratergy = winningStratergy;
    }

    public int getNumberofSymbols() {
        return numberofSymbols;
    }

    public void setNumberofSymbols(int numberofSymbols) {
        this.numberofSymbols = numberofSymbols;
    }

    public static class Builder{
        private int dimension;
        private Board currentBoard;
        private List<Player> players;
        private WinningStratergy winningStratergy;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStratergy(WinningStratergy winningStratergy) {
            this.winningStratergy = winningStratergy;
            return this;
        }

        public void validateNumberofPlayers(){

            if(players.size() < dimension - 2 || players.size() >= dimension){
                throw new InvalidPlayerSizeException(" Player size should be N-2 or N-1 as per the board size ");
            }
        }

        public void validatePlayerSymbols(){
            HashSet<Character> symbols = new HashSet<>();

            for(Player player : players){
                symbols.add(player.getSymbol());
            }

            if(symbols.size() != players.size()){
                throw new InvalidSymbolSetupException("There should be unique symbols for each Player");
            }
        }

        public void validateBotCount(){
            int botcount = 0;

            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botcount++;
                }
            }

            if(botcount > 1 || botcount <0){
                throw new InvalidBotCountException(" We can have maximum 1 BOT per game ");
            }
        }

        public void validate(){
            validateBotCount();
            validateNumberofPlayers();
            validatePlayerSymbols();
        }
    }
}

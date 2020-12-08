package game.domain.player;

public class PlayerCreator {
    private PlayerCreator() {
    }

    public static Player createPlayer(String name) {
        return new Player(name);
    }
}

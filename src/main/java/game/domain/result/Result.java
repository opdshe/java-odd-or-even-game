package game.domain.result;

public class Result {
    public enum ResultFlag {
        WIN, LOSE;
    }

    private final ResultFlag resultFlag;

    public Result(ResultFlag resultFlag) {
        this.resultFlag = resultFlag;
    }

    public boolean isWin() {
        return resultFlag == (ResultFlag.WIN);
    }
}

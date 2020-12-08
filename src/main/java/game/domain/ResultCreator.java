package game.domain;

public class ResultCreator {
    private ResultCreator() {
    }

    public static Result createResult(TargetNumber number, BettingMoney bettingMoney, OddOrEven oddOrEven) {
        if (number.isRight(oddOrEven)) {
            return new Result(bettingMoney, Result.ResultFlag.WIN);
        }
        return new Result(bettingMoney, Result.ResultFlag.LOSE);
    }
}

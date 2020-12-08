package game.domain.result;

import game.domain.BettingMoney;
import game.domain.TargetNumber;
import game.domain.oddoreven.OddOrEven;

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
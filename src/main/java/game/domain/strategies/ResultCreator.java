package game.domain.strategies;

import game.domain.BettingMoney;
import game.domain.OddOrEven;
import game.domain.Result;
import game.domain.TargetNumber;

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

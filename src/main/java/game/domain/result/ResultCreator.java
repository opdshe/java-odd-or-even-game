package game.domain.result;

import game.domain.BettingMoney;
import game.domain.TargetNumber;
import game.domain.oddoreven.OddOrEven;

public class ResultCreator {
    private ResultCreator() {
    }

    public static NormalModeResult createNormalResult(TargetNumber number, BettingMoney bettingMoney, OddOrEven oddOrEven) {
        if (number.isRightOddOrEven(oddOrEven)) {
            return new NormalModeResult(bettingMoney.getMoney(), Result.ResultFlag.WIN);
        }
        return new NormalModeResult(bettingMoney.getMoney(), Result.ResultFlag.LOSE);
    }

    public static SuperBettingModeResult createSuperBettingModeResult(TargetNumber number, int superBettingNumber) {
        if (number.isRightSuperBettingNumber(superBettingNumber)) {
            return new SuperBettingModeResult(Result.ResultFlag.WIN);
        }
        return new SuperBettingModeResult(Result.ResultFlag.LOSE);
    }
}

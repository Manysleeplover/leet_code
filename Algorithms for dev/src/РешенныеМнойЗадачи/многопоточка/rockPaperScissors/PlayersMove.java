package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;


import java.util.Objects;

public class PlayersMove {
    private long playersId;
    private SignEnum signEnum;

    public PlayersMove(long playersId, SignEnum signEnum) {
        this.playersId = playersId;
        this.signEnum = signEnum;
    }

    public long getPlayersId() {
        return playersId;
    }

    public void setPlayersId(long playersId) {
        this.playersId = playersId;
    }

    public SignEnum getSignEnum() {
        return signEnum;
    }

    public void setSignEnum(SignEnum signEnum) {
        this.signEnum = signEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayersMove that = (PlayersMove) o;
        return signEnum == that.signEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(signEnum);
    }
}

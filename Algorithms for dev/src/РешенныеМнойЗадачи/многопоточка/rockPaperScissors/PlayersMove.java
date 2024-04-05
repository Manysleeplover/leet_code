package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;


import java.util.Objects;

record PlayersMove(long playersId, SignEnum signEnum) {
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

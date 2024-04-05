package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;

public enum SignEnum {
    rock(0), paper(1), scissors(2);

    SignEnum(int signNumber) {}

    public static SignEnum getSign(int signNumber) {
        return SignEnum.values()[signNumber];
    }
}
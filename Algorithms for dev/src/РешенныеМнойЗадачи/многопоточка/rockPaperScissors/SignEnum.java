package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;

enum SignEnum {
    rock(0), paper(1), scissors(2);

    private final int signNumber;

    SignEnum(int signNumber) {
        this.signNumber = signNumber;
    }

    public static SignEnum getSign(int signNumber){
        return SignEnum.values()[signNumber];
    }
}
package common;

public interface NumberConvertor
{
    Number convert(Number temp);

    Number[][] convert(DiffusionArguments args);

    Number add(Number... numbers);

    Number divide(Number add, int i);

    String convertForDisplay(Number number, int precision);
}

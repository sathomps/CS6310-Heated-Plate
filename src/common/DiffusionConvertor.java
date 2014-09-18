package common;

public interface DiffusionConvertor
{
    Number convert(Number[][] internals, int row, int cell);

    Number convert(Number temp);

    Number[][] convert(DiffusionArguments args);
}
